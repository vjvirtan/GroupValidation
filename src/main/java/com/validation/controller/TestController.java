package com.validation.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class TestController {
  @GetMapping("path")
  public String getMethodName() {
    return "Moikka";
  }

}
