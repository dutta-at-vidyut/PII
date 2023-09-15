package com.vidyuttech.PII.exception;

import com.vidyuttech.PII.controller.shared.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import java.security.NoSuchAlgorithmException;

@RestControllerAdvice
@Slf4j
public class ExceptionAdvice {

  @ExceptionHandler({HttpClientErrorException.class})
  @ResponseBody
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse handleHttpClientErrorExceptionException(HttpClientErrorException e) {
    log.error("[ERR] = HttpClientErrorException = {}", e.getMessage());
    ErrorResponse errorResponse =
        new ErrorResponse(
            e.getMessage(), com.vidyuttech.PII.controller.shared.ResponseStatus.FAILED);
    return errorResponse;
  }

  @ExceptionHandler({NoSuchAlgorithmException.class})
  @ResponseBody
  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
  public ErrorResponse handleNoSuchAlgorithmExceptionException(NoSuchAlgorithmException e) {
    log.error("[ERR] = NoSuchAlgorithmException = {}", e.getMessage());
    return new ErrorResponse(
        e.getMessage(), com.vidyuttech.PII.controller.shared.ResponseStatus.OKAY);
  }

  @ExceptionHandler({DataIntegrityViolationException.class})
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse handleDataIntegrityViolationExceptionException(
      DataIntegrityViolationException e) {
    log.error("[ERR] = DataIntegrityViolationException = {}", e.getMessage());
    return new ErrorResponse(
        e.getMessage(), com.vidyuttech.PII.controller.shared.ResponseStatus.FAILED);
  }

  @ExceptionHandler({VTException.class})
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  @ResponseBody
  public ErrorResponse handleVTException(VTException e) {
    log.error("[ERR] = VTException = {}", e.getMessage());
    return new ErrorResponse(
        e.getMessage(), com.vidyuttech.PII.controller.shared.ResponseStatus.FAILED);
  }

  @ExceptionHandler({Exception.class})
  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
  @ResponseBody
  public ErrorResponse handleException(Exception e) {
    log.error("[ERR] = Exception = {}", e.getMessage());
    return new ErrorResponse(
        e.getMessage(), com.vidyuttech.PII.controller.shared.ResponseStatus.FAILED);
  }
}
