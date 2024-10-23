package com.validation.interfaces;

import org.springframework.http.*;
import java.io.*;
import com.validation.dto.*;
import com.validation.services.*;

public interface ValidationRuleInterface {
  ValidationRuleDto convertDaoToDto(ValidationRule dao);

  ValidationRule convertDtoToDao(ValidationRuleDto dto);

  <T extends Serializable> ResponseEntity<Boolean> valid(ValidationRuleDto dto, T value);
}
