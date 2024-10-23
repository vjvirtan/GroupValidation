package com.validation.repositories;

import java.util.*;

import org.springframework.data.mongodb.repository.*;
import com.validation.dao.*;

public interface DictionaryRepository extends MongoRepository<FieldDictionary, String> {

  Optional<FieldDictionary> findByKey(String key);
}
