package com.api.security.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class HttpResponse {

	private int httpStatusCode; // 200, 201,404, 500
	
	private String reason;
	
	private String message;
}
