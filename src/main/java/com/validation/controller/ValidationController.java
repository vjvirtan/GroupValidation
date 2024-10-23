package com.validation.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.validation.dto.*;
import com.validation.exeption.*;
import com.validation.services.*;

import lombok.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@RestController
public class ValidationController {
  private final ValidationService validationService;

  @PostMapping("validate")
  public ResponseEntity<ValidationErrors> valid(@RequestBody ValidationServiceDto validDto) {
    System.out.println("validation contorller " + validDto.toString());
    // THIS ONLY RETURNS RESPONSE OK. NOTHING ELSE MATTERS
    return new ResponseEntity<ValidationErrors>(this.validationService.validate(validDto), HttpStatus.OK);
  }

}
