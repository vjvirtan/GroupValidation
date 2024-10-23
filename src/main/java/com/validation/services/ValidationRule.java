package com.validation.services;

import java.util.*;

import org.springframework.data.mongodb.core.mapping.*;

import lombok.*;

// TODO: TRANSFER METHODS TO THE SERVICE
@Document
@Builder
public record ValidationRule(
        boolean mandatory,
        boolean unique,
        double max,
        double min,
        String allowedChars,
        List<ValuePair<Integer, String>> subStrings) {

}
