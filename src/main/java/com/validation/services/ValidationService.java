package com.validation.services;

import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import org.springframework.stereotype.*;

import com.validation.dto.*;
import com.validation.exeption.*;
import com.validation.interfaces.*;

import lombok.*;

@RequiredArgsConstructor
@Service
public class ValidationService implements ValidationInterface {
  private final ValidationProsess validationProsess;

  // TODO: UNNESSARY METHOD
  public ValidationErrors validate(ValidationServiceDto validDto) {

    return autoTest(validDto);

  }

  @SuppressWarnings("null")
  private ValidationErrors autoTest(ValidationServiceDto validDto) {

    ValidationErrors errors = new ValidationErrors(new ArrayList<>());
    try {

      for (Field ruleField : validDto.validationRule().getClass().getDeclaredFields()) {

        ruleField.setAccessible(true);

        // CASE MANDATORY
        if (!validDto.validationRule().mandatory()) {
          if (validDto.value() == "" || validDto.value() == null) {
            return errors;
          }
        }

        switch (ruleField.getName()) {

          case "max":
            var max = validationProsess.testMax((Serializable) validDto.value(), validDto.validationRule().max());
            if (!max.key()) {
              errors.errors().add(max.value());
            }
            break;
          case "min":
            var min = validationProsess.testMin((Serializable) validDto.value(), validDto.validationRule().min());
            if (!min.key()) {
              errors.errors().add(min.value());
            }
            break;
          case "allowedChars":
            var all = validationProsess.testAllowedChars((Serializable) validDto.value(),
                validDto.validationRule().allowedChars());
            if (!all.key()) {
              errors.errors().add(all.value());
            }
            break;
          case "subString":
            var sub = validationProsess.testSubstring((String) validDto.value(),
                validDto.validationRule().subStrings());
            if (!sub.key()) {
              errors.errors().add(sub.value());
            }
            break;
          default:
            break;
        }

        // CHECK ERRORS, IF ANY FOUND THROW EXCEPTION

      }

    } catch (IllegalArgumentException e) {

      e.printStackTrace();
    }
    System.out.println("ERRORS " + errors.toString());
    return errors;
  }

}
