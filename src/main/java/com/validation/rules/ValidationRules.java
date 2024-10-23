package com.validation.rules;

import java.util.*;

import com.validation.dto.*;
import com.validation.enums.*;
import com.validation.services.*;;

public class ValidationRules {

  public static ValidationRuleDto nameRule() {

    return ValidationRuleDto.builder()
        .allowedChars(FieldEnum.NAME.getValue())
        .mandatory(true)
        .unique(false)
        .min(2)
        .max(30)
        .build();
  }

  public static ValidationRuleDto orderRule() {
    return ValidationRuleDto.builder()
        .allowedChars(FieldEnum.WHOLE_NUMBER.getValue())
        .mandatory(false)
        .unique(false)
        .min(1)
        .max(30)
        .build();
  }

  public static ValidationRuleDto businessIdRule() {
    return ValidationRuleDto.builder()
        .allowedChars(FieldEnum.NAME_NUMBERS_HYPHEN.getValue())
        .mandatory(true)
        .unique(true)
        .min(9)
        .max(9)
        .subStrings(Arrays.asList(new ValuePair<Integer, String>(8, "^[\\-]$")))
        .build();
  }

  public static ValidationRuleDto personalId() {
    return ValidationRuleDto.builder()
        .allowedChars(FieldEnum.NAME_NUMBERS_HYPHEN.getValue())
        .mandatory(true)
        .unique(true)
        .min(11)
        .max(11)
        .subStrings(Arrays.asList(new ValuePair<Integer, String>(7, "^[\\-\\+A]$\r\n"),
            new ValuePair<Integer, String>(7,
                FieldEnum.WHOLE_NUMBER.getValue())))
        .build();
  }

}
