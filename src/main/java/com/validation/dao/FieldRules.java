package com.validation.dao;

import org.springframework.data.mongodb.core.mapping.*;

import lombok.*;

@Document
@Builder
@Getter
public class FieldRules {
  private String fieldName;

}
