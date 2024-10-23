package com.validation.services;

import java.util.*;
import java.util.stream.*;

import org.springframework.http.*;
import org.springframework.stereotype.*;

import com.validation.dao.*;
import com.validation.dto.*;
import com.validation.interfaces.*;
import com.validation.repositories.*;

import lombok.*;

@RequiredArgsConstructor
@Service
public class FieldDictionaryService implements FieldDictionaryInterface {
  private static Map<String, FieldDictionaryDto> fieldDictionary;
  private final DictionaryRepository dictionaryRepository;
  private final ValidationRuleService validationRuleService;

  public void loadMemory() {
    List<FieldDictionary> allFieldDictionaries = dictionaryRepository.findAll();
    if (allFieldDictionaries == null || allFieldDictionaries.size() == 0) {
      // TODO: SOME ERROR OR SOMETHING: DEFAULT RULES RUN ON STARTUP AND SHOULD
    } else {
      fieldDictionary = allFieldDictionaries.stream()
          .map((dao) -> convertDaoToDto(dao))
          .collect(Collectors.toMap(k -> k.key().toString(), v -> v));
    }

  }

  public ResponseEntity<FieldDictionaryDto> read(String key) {

    if (fieldDictionary.containsKey(key)) {
      return new ResponseEntity<>(fieldDictionary.get(key), HttpStatus.OK);
    } else {
      Optional<FieldDictionary> fdDao = this.dictionaryRepository.findByKey(key);
      if (fdDao.isPresent()) {
        fieldDictionary.put(key, convertDaoToDto(fdDao.get()));
        return new ResponseEntity<>(fieldDictionary.get(key), HttpStatus.OK);
      }
      throw new IllegalArgumentException();
    }
  }

  public ResponseEntity<FieldDictionaryDto> create(String key, FieldDictionaryDto dto) {

    if (fieldDictionary == null) {
      fieldDictionary = new HashMap<>();
    }

    // THIS OVERRIDES POSSIBLE OLD RULE

    Optional<FieldDictionary> fdDao = this.dictionaryRepository.findByKey(key);
    if (fdDao.isPresent()) {
      return update(FieldDictionaryDto.builder()
          .categories(dto.categories())
          .id(fdDao.get().getId())
          .key(dto.key())
          .translations(dto.translations())
          .validationRule(dto.validationRule())
          .build());
    }

    this.dictionaryRepository.save(convertDtoToDao(dto));
    fieldDictionary.put(key, dto);
    return new ResponseEntity<>(fieldDictionary.get(key), HttpStatus.OK);

  }

  public ResponseEntity<FieldDictionaryDto> update(FieldDictionaryDto dto) {
    Optional<FieldDictionary> fd = this.dictionaryRepository.findById(dto.id());
    if (fd.isPresent()) {
      FieldDictionary saveFd = fd.get();
      saveFd.setCategories(dto.categories().stream().map(e -> Category.builder().name(e.name()).build()).toList());
      saveFd.setKey(dto.key());
      saveFd.setTranslations(
          dto.translations().stream().map(e -> new ValuePair<String, String>(e.key(), e.value())).toList());
      saveFd.setValidationRule(this.validationRuleService.convertDtoToDao(dto.validationRule()));
      this.dictionaryRepository.save(saveFd);

      fieldDictionary.put(saveFd.getKey(), convertDaoToDto(saveFd));
      return new ResponseEntity<>(fieldDictionary.get(dto.key()), HttpStatus.OK);
    } else {
      throw new NoSuchElementException();
    }
  }

  public ResponseEntity<FieldDictionaryDto> delete(FieldDictionary dto) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
  }

  public FieldDictionaryDto convertDaoToDto(FieldDictionary dao) {
    return FieldDictionaryDto.builder()
        .categories(dao.getCategories().stream().map(d -> CategoryDto.builder()
            .name(d.getName())
            .build())
            .toList())
        .key(dao.getKey())
        .translations(dao.getTranslations().stream().map(e -> new ValuePair<>(e.key(), e.value())).toList())
        .validationRule(ValidationRuleDto.builder()
            .allowedChars(dao.getValidationRule().allowedChars())
            .mandatory(dao.getValidationRule().mandatory())
            .max(dao.getValidationRule().max())
            .min(dao.getValidationRule().min())
            .subStrings(dao.getValidationRule().subStrings())
            .build())
        .build();
  }

  public FieldDictionary convertDtoToDao(FieldDictionaryDto dto) {
    return FieldDictionary.builder()
        .categories(dto.categories().stream().map(d -> Category.builder()
            .name(d.name())
            .build())
            .toList())
        .key(dto.key())
        .translations(dto.translations().stream().map(e -> new ValuePair<>(e.key(), e.value())).toList())
        .validationRule(ValidationRule.builder()
            .allowedChars(dto.validationRule().allowedChars())
            .mandatory(dto.validationRule().mandatory())
            .max(dto.validationRule().max())
            .min(dto.validationRule().min())
            .subStrings(dto.validationRule().subStrings())
            .build())
        .build();
  }

  // TODO:
  @Override
  public ResponseEntity<FieldDictionaryDto> delete(FieldDictionaryDto dto) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
  }

}
