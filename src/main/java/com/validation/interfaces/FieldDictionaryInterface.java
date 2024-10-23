package com.validation.interfaces;

import org.springframework.http.*;

import com.validation.dao.*;
import com.validation.dto.*;

public interface FieldDictionaryInterface {

  ResponseEntity<FieldDictionaryDto> create(String key, FieldDictionaryDto dto);

  ResponseEntity<FieldDictionaryDto> update(FieldDictionaryDto dto);

  ResponseEntity<FieldDictionaryDto> delete(FieldDictionaryDto dto);

  ResponseEntity<FieldDictionaryDto> read(String key);

  FieldDictionaryDto convertDaoToDto(FieldDictionary dao);

  FieldDictionary convertDtoToDao(FieldDictionaryDto dto);

  void loadMemory();

}
