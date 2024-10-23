package com.validation.dao;

import java.util.*;

import org.springframework.data.mongodb.core.mapping.*;

import com.validation.service.*;

import lombok.*;

@Document
@Builder
@Getter
public class Dictionary {
  private String key;
  private Map<Locale, String> translations;
  private ValidationRule validationRule;
}
