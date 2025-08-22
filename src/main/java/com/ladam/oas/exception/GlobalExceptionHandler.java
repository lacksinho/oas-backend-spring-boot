package com.ladam.oas.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ladam.oas.dto.ErrorDetails;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception) {
		ErrorDetails errorDetails = new ErrorDetails(exception.getStatus().value(), exception.getMessage());

		logger.error("Resource not found: ", exception);

		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(OasApiException.class)
	public ResponseEntity<ErrorDetails> handleBlogApiException(OasApiException exception) {
		ErrorDetails errorDetails = new ErrorDetails(exception.getStatus().value(), exception.getMessage());

		logger.error("OAS error: ", exception);

		return new ResponseEntity<>(errorDetails, exception.getStatus());
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleGlobalException(Exception exception) {
		ErrorDetails errorDetails = new ErrorDetails(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage());
		logger.error("Global error: ", exception);
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ErrorDetails> handleDuplicateKey(DataIntegrityViolationException ex) {
		String message = "Duplicate value exists";
		String causeMessage = ex.getMostSpecificCause().getMessage();

		// Pattern for MySQL "Duplicate entry '...' for key 'constraint_name'"
		Pattern pattern = Pattern.compile("Duplicate entry .* for key '(.*)'");
		Matcher matcher = pattern.matcher(causeMessage);

		if (matcher.find()) {
			String constraintName = matcher.group(1);

			// Map known constraints to friendly messages
			switch (constraintName) {
			case "academic_years_year_unique":
				message = "Academic year already exists";
				break;
			case "campuses_code_unique":
				message = "Campus code already exists";
				break;
			case "courses_code_unique":
				message = "Course code already exists";
				break;
			default:
				// Generic message if unknown constraint
				message = "Duplicate value violates constraint: " + constraintName;
			}
		}

		ErrorDetails errorDetails = new ErrorDetails(HttpStatus.BAD_REQUEST.value(), message);

		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		Map<String, String> validationErrors = new HashMap<>();
		exception.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String messasge = error.getDefaultMessage();
			validationErrors.put(fieldName, messasge);
		});

		ErrorDetails errorDetails = new ErrorDetails(HttpStatus.BAD_REQUEST.value(), "Validation failed",
				validationErrors);

		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}
}
