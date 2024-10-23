package com.validation.exeption;

import java.util.*;

import lombok.*;

@Getter
public class ValidationException extends RuntimeException {
  private ValidationErrors errorMessages;

  public ValidationException(List<ValidationError<String, String>> messages) {
    super("Errors has occured: ");
    errorMessages = new ValidationErrors(messages);

  }
}
