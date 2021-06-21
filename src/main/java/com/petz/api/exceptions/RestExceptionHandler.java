package com.petz.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {   
	
	@ExceptionHandler(UniqueException.class)
    public ResponseEntity<ErrorDetail> handleUniqueException(UniqueException exc,
            HttpServletRequest request) {
		
		ErrorDetail errorDetail = new ErrorDetail();
        errorDetail.setData( LocalDate.now());
        errorDetail.setStatus(HttpStatus.OK.value());
        errorDetail.setTitle("Cadastro de Cliente");
        errorDetail.setMessageDetail(exc.getMessage());
        errorDetail.setMessage(ServiceExceptionHandlerEnum.ERRO500.getDescription());

        return new ResponseEntity<ErrorDetail>(errorDetail, null, HttpStatus.OK);
    }
	
	
	@ExceptionHandler(GenericException.class)
    public ResponseEntity<ErrorDetail> handleValidaCamposException(GenericException vld,
                                                         HttpServletRequest request) {
		
		ErrorDetail errorDetail = new ErrorDetail();
        errorDetail.setData( LocalDate.now());
        errorDetail.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorDetail.setTitle("Erro na Operação");
        errorDetail.setMessageDetail(vld.getMsg());
        errorDetail.setMessage(ServiceExceptionHandlerEnum.ERRO500.getDescription());

        return new ResponseEntity<ErrorDetail>(errorDetail, null, HttpStatus.UNPROCESSABLE_ENTITY);
    }
	
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetail> geralException(Exception exc,
            HttpServletRequest request) {

		ErrorDetail errorDetail = new ErrorDetail();
        errorDetail.setData( LocalDate.now());
        errorDetail.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorDetail.setTitle("Erro Interno");
        errorDetail.setMessageDetail(exc.getMessage());
        errorDetail.setMessage(ServiceExceptionHandlerEnum.ERRO500.getDescription());

        return new ResponseEntity<ErrorDetail>(errorDetail, null, HttpStatus.OK);
    }
	
	
	@ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorDetail> erroInternoException(NullPointerException exc,
            HttpServletRequest request) {
		
		ErrorDetail errorDetail = new ErrorDetail();
        errorDetail.setData( LocalDate.now());
        errorDetail.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorDetail.setMessage(ServiceExceptionHandlerEnum.ERRO500.getDescription());
        errorDetail.setMessageDetail(exc.getMessage());
       

        return new ResponseEntity<ErrorDetail>(errorDetail, null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
	


}
