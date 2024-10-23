package com.validation.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.validation.dto.*;
import com.validation.interfaces.*;

import lombok.*;

@RestController
@RequiredArgsConstructor
public class FieldDictionaryController {
  private final FieldDictionaryInterface fieldDictionaryInterface;

  @PostMapping("fieldRules")
  public ResponseEntity<FieldDictionaryDto> postMethodName(@RequestBody ValidationServiceDto e) {
    return this.fieldDictionaryInterface.read(e.key());
  }

  // TODO: ALL CRUD INTERFACES
}
