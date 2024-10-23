package com.validation.enums;

import lombok.*;

@Getter
public enum BoardRolesEnum {
  CEO("Ceo"),
  HEAD_OF_BOARD("Head of board"),
  BOARD_MEMBER("Board member"),
  DEPUTY_BOARD_MEMBER("Deputy board member");

  private String value;

  private BoardRolesEnum(String value) {

    this.value = value;
  }

}
