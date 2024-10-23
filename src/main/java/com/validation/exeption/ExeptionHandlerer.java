package com.validation.exeption;



import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.*;

@ControllerAdvice
public class ExeptionHandlerer {

  @ExceptionHandler(ValidationException.class)
  public ResponseEntity<ValidationErrors> handleValidationException(
      ValidationException validationExeption,
      WebRequest request) {

    return new ResponseEntity<ValidationErrors>(
        validationExeption.getErrorMessages(), HttpStatus.BAD_REQUEST);
  }
}
