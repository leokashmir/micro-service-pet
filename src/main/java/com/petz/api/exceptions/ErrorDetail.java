package com.petz.api.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter @NoArgsConstructor
public class ErrorDetail {
	
	private String title;
	private int status;
	private String messageDetail;
	private LocalDate data;
	private String message;

}
