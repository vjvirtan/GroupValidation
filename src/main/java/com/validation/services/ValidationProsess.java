package com.validation.services;

import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.regex.*;

import org.springframework.stereotype.*;

import com.validation.exeption.*;

@Service
public class ValidationProsess {
  public <T extends Serializable> ValuePair<Boolean, ValidationError<String, String>> testMandatory(T value,
      boolean mandatory) {
    if (mandatory) {
      if (value == null || value.toString().equals("")) {
        return new ValuePair<Boolean, ValidationError<String, String>>(false,
            new ValidationError<String, String>("mandatoryField", value.toString(),
                mandatory + ""));
      }
    }
    return new ValuePair<Boolean, ValidationError<String, String>>(true, null);
  }

  // TODO:REMOVE THIS, IMPLEMENT THIS IN CLIENT SYSTEM!!!
  public boolean testUnique(Class<?> repo, Class<?> valueClass, Field validationField, boolean unique) {
    boolean response = true;
    String fieldNameWithCapitalFirst = validationField.getName().substring(0, 1).toUpperCase()
        + validationField.getName().substring(1);

    try {
      var value = (Serializable) validationField.get(valueClass);
      Method m = repo.getClass().getMethod("existsBy" + fieldNameWithCapitalFirst);
      response = !(boolean) m.invoke(repo, value);

      if (unique) {
        if (value instanceof Number) {

        } else if (value instanceof String) {

        }

        return response;
      }
    } catch (NoSuchMethodException | SecurityException | IllegalAccessException | InvocationTargetException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return true;
  }

  public <T extends Serializable> ValuePair<Boolean, ValidationError<String, String>> testAllowedChars(T value,
      String allowedChars) {
    boolean response = Pattern.matches(allowedChars, value.toString());

    return response ? new ValuePair<Boolean, ValidationError<String, String>>(true, null)
        : new ValuePair<Boolean, ValidationError<String, String>>(false,
            new ValidationError<String, String>("allowedChars", value.toString(),
                allowedChars.toLowerCase()));
  }

  public <T extends Serializable> ValuePair<Boolean, ValidationError<String, String>> testMin(T value, double min) {
    boolean response = value instanceof Number ? Double.parseDouble(value.toString()) >= min
        : value.toString().length() >= min;

    return response ? new ValuePair<Boolean, ValidationError<String, String>>(true, null)
        : new ValuePair<Boolean, ValidationError<String, String>>(false,
            new ValidationError<String, String>(value instanceof Number ? "tooShort"
                : "tooShortString", value.toString(), min + ""));
  }

  public <T extends Serializable> ValuePair<Boolean, ValidationError<String, String>> testMax(T value, double max) {
    if (max == 0) {
      return new ValuePair<Boolean, ValidationError<String, String>>(true, null);
    }
    boolean response = value instanceof Number ? Double.parseDouble(value.toString()) <= max
        : value.toString().length() <= max;
    return response ? new ValuePair<Boolean, ValidationError<String, String>>(true, null)
        : new ValuePair<Boolean, ValidationError<String, String>>(false,
            new ValidationError<String, String>(value instanceof Number ? "tooLong" : "tooLongString", value.toString(),
                max + ""));
  }

  public <T extends Serializable> ValuePair<Boolean, ValidationError<String, String>> testSubstring(T value,
      List<ValuePair<Integer, String>> subStrings) {
    for (ValuePair<Integer, String> e : subStrings) {
      if (Pattern.matches(e.value(), value.toString().substring(e.key(), e.key() + 1))) {
        return new ValuePair<Boolean, ValidationError<String, String>>(false,
            new ValidationError<String, String>("illegalCharacter", value.toString(),
                e.key() + " " + e.value()));
      }
    }
    return new ValuePair<Boolean, ValidationError<String, String>>(true, null);
  }

  /*
   * @Override
   * public final String toString() {
   * return "{\"mandatory\":\"" + mandatory
   * + "\",\"unique\":\"" + unique
   * + "\",\"max\":\"" + max
   * + "\",\"min\":\"" + min
   * + "\",\"allowedChars\":\"" + allowedChars
   * + ",\"subStrings\":\"" + subStringToString()
   * + "}";
   * }
   * 
   * private String subStringToString() {
   * if (subStrings == null) {
   * return "[]";
   * }
   * StringBuilder sb = new StringBuilder("[");
   * subStrings.forEach(e -> {
   * sb.append("{\"" + e.key() + "\":\"" + e.value() + "\" },");
   * });
   * sb.deleteCharAt(sb.length() - 1);
   * sb.append("]");
   * return sb.toString();
   * }
   */
}
