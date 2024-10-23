package com.validation.dto;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ValidationServiceDto(String key, String value, ValidationRuleDto validationRule) {

}
