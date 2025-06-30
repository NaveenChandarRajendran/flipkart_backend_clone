package com.clone.flipkart.exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;


@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, Object>> handleValidationErrors(MethodArgumentNotValidException ex) {
	    Map<String, String> fieldErrors = new HashMap<>();

	    ex.getBindingResult().getFieldErrors().forEach(err -> {
	        fieldErrors.put(err.getField(), err.getDefaultMessage());
	    });

	    Map<String, Object> response = new LinkedHashMap<>();
	    response.put("message", "Validation failed");
	    response.put("errors", fieldErrors);

	    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
    
    // ✅ Handle ensum or format parsing error (like your RROT issue)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, String>> handleEnumErrors(HttpMessageNotReadableException ex) {
        Throwable cause = ex.getCause();
        if (cause instanceof InvalidFormatException) {
            InvalidFormatException ife = (InvalidFormatException) cause;
            if (ife.getTargetType().isEnum()) {
                Object[] enumConstants = ife.getTargetType().getEnumConstants();
                List<String> acceptedValues = new ArrayList<>();
                for (Object constant : enumConstants) {
                    acceptedValues.add(constant.toString());
                }

                Map<String, String> error = new HashMap<>();
                error.put("error", "Invalid value for 'user_type'. Allowed values: " + String.join(", ", acceptedValues));
                return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
            }
        }

        // fallback for other message parsing issues
        Map<String, String> fallback = new HashMap<>();
        fallback.put("error", "Malformed JSON request");
        return new ResponseEntity<>(fallback, HttpStatus.BAD_REQUEST);
    }
}