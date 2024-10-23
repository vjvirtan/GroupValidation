package com.validation.exeption;

import java.util.*;

import lombok.*;

@Getter
public class ValidationException extends RuntimeException {
  private List<ValidationError<?, ?>> errorMessages;

  public ValidationException(List<ValidationError<?, ?>> messages) {
    super("Errors has occured: ");
    this.errorMessages = messages;
  }
}
