package com.ladam.oas.enums;

import org.springframework.http.HttpStatus;

import com.ladam.oas.exception.OasApiException;

public enum SubjectCategory {

	O_LEVEL(1, "OLevel"), A_LEVEL(2, "ALevel");

	private final int code;
	private final String label;

	SubjectCategory(int code, String label) {
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
	public static SubjectCategory fromCode(int code) {
		for (SubjectCategory c : values()) {
			if (c.code == code) {
				return c;
			}
		}

		throw new OasApiException(HttpStatus.BAD_REQUEST, "Invalid subject category code: " + code);
	}

	// Convert label -> Enum
	public static SubjectCategory fromLabel(String label) {
		for (SubjectCategory c : values()) {
			if (c.label == label) {
				return c;
			}
		}

		throw new OasApiException(HttpStatus.BAD_REQUEST, "Invalid subject category label: " + label);
	}

}
