package com.ladam.oas.enums;

import org.springframework.http.HttpStatus;

import com.ladam.oas.exception.OasApiException;

public enum MaritalStatus {

	SINGLE(1, "Single"), MARRIED(2, "Married"), DIVORCED(3, "Divorced"), WIDOWED(4, "Widowed"),
	SEPARATED(5, "Separated"), OTHERS(6, "Others");

	private final int code;
	private final String label;

	MaritalStatus(int code, String label) {
		this.code = code;
		this.label = label;
	}

	public int getCode() {
		return code;
	}

	public String getLabel() {
		return label;
	}

	// Convert DB value -> Enum
	public static MaritalStatus fromCode(int code) {
		for (MaritalStatus c : values()) {
			if (c.code == code) {
				return c;
			}
		}

		throw new OasApiException(HttpStatus.BAD_REQUEST, "Invalid Marital status code: " + code);
	}

	// Convert label -> Enum
	public static MaritalStatus fromLabel(String label) {
		for (MaritalStatus c : values()) {
			if (c.label == label) {
				return c;
			}
		}

		throw new OasApiException(HttpStatus.BAD_REQUEST, "Invalid Marital status label: " + label);
	}

}
