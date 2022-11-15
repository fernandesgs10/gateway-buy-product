package br.com.gateway.buy.product.config;

import br.com.gateway.buy.product.common.FinnetConnectException;
import br.com.gateway.buy.product.common.ResponseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ConstraintViolationException;

@Slf4j
@ControllerAdvice
@RestController
public class HandlerExceptionConfig {

    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity<ResponseException> exceptionContraintError(ConstraintViolationException exception, WebRequest request) {
        Throwable throwable = exception;
        ServletWebRequest servletWebRequest = (ServletWebRequest) request;
        ResponseException responseMensage = ResponseException.builder()
                .message(throwable.toString()).
                error(HttpStatus.BAD_REQUEST.name())
                .status(HttpStatus.BAD_REQUEST.value())
                .path(servletWebRequest.getRequest().getRequestURL().toString().toString())
                .build();

        log.error(throwable.getMessage(), throwable);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseMensage);
    }

    @ExceptionHandler(value = FinnetConnectException.class)
    public ResponseEntity<ResponseException> exceptionFinnetConnecta(FinnetConnectException exception, WebRequest request) {
        Throwable throwable = exception;
        ServletWebRequest servletWebRequest = (ServletWebRequest) request;
        ResponseException responseMensage = ResponseException.builder()
                .message(throwable.toString()).
                        error(HttpStatus.INTERNAL_SERVER_ERROR.name())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .path(servletWebRequest.getRequest().getRequestURL().toString().toString())
                .build();

        log.error(throwable.getMessage(), throwable);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseMensage);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ResponseException> exception(Exception exception, WebRequest request) {
        Throwable throwable = exception;
        ServletWebRequest servletWebRequest = (ServletWebRequest) request;

        ResponseException responseMensage = ResponseException.builder()
                .message(throwable.toString()).
                        error(HttpStatus.INTERNAL_SERVER_ERROR.name())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .path(servletWebRequest.getRequest().getRequestURL().toString().toString())
                .build();

        log.error(throwable.getMessage(), throwable);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseMensage);
    }

  }
