package com.validation.enums;

public enum FieldEnum {
  NAME(
      "[a-zA-ZäöåÄÖÅ]+"),
  NAME_NUMBERS_HYPHEN("^[a-zA-ZäöåÄÖÅ0-9-]+$"),
  DECIMAL("^\\d+([.,]\\d+)?$"),
  WHOLE_NUMBER("^[0-9]+$");

  private String value;

  FieldEnum(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
