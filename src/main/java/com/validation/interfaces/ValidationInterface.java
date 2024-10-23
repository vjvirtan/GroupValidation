package com.validation.interfaces;

import com.validation.dto.*;
import com.validation.exeption.*;

public interface ValidationInterface {
  ValidationErrors validate(ValidationServiceDto validDto);

}