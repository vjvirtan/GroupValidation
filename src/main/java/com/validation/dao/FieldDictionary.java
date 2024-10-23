package com.validation.dao;

import java.util.*;
import org.springframework.data.mongodb.core.mapping.*;

import com.validation.services.*;

import lombok.*;
import lombok.Builder;

@Document
@Builder
@Getter
@Setter
public class FieldDictionary extends UUIDGen {
  private String key;
  private List<Category> categories;
  private List<ValuePair<String, String>> translations;
  private ValidationRule validationRule;
}
