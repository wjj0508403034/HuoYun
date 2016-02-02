package com.huoyun.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.huoyun.core.common.ErrorCode;
import com.huoyun.core.locale.LocaleService;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private LocaleService localeService;

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> UnexpectedError(Exception businessException) {
		return new ResponseEntity<Object>(new BusinessExceptionResponse(
				ErrorCode.General_Error,
				localeService.getErrorMessage(ErrorCode.General_Error)),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<Object> BusinessError(
			BusinessException businessException) {
		return new ResponseEntity<Object>(new BusinessExceptionResponse(
				businessException), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(LocalableBusinessException.class)
	public ResponseEntity<Object> LocalableBusinessError(
			LocalableBusinessException businessException) {
		return new ResponseEntity<Object>(
				new LocalableBusinessExceptionResponse(businessException),
				HttpStatus.BAD_REQUEST);
	}

}
