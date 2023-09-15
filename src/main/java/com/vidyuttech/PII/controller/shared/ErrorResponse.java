package com.vidyuttech.PII.controller.shared;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

  private String message;

  private ResponseStatus status;

  public ErrorResponse(ResponseStatus responseStatus) {
    this.setStatus(responseStatus);
  }
}
