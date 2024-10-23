package com.validation.services;

import org.springframework.stereotype.*;

import com.validation.dto.*;

import lombok.*;

@Service
@RequiredArgsConstructor
public class ValidationRuleService {

  public ValidationRule convertDtoToDao(ValidationRuleDto dto) {
    return ValidationRule.builder()
        .mandatory(dto.mandatory())
        .allowedChars(dto.allowedChars())
        .max(dto.max())
        .min(dto.min())
        .unique(dto.unique())
        .subStrings(dto.subStrings())
        .build();
  }

  public ValidationRuleDto convertDaoToDto(ValidationRule dao) {
    return ValidationRuleDto.builder()
        .mandatory(dao.mandatory())
        .allowedChars(dao.allowedChars())
        .max(dao.max())
        .min(dao.min())
        .unique(dao.unique())
        .subStrings(dao.subStrings())
        .build();
  }
}
