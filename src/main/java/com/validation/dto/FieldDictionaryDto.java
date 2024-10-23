package com.validation.dto;

import java.util.*;

import com.validation.services.*;

import lombok.*;

@Builder
public record FieldDictionaryDto(String id, String key, List<CategoryDto> categories,
    List<ValuePair<String, String>> translations,
    ValidationRuleDto validationRule) {

}
