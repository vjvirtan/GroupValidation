package com.validation.dto;

import java.util.*;

import com.fasterxml.jackson.annotation.*;
import com.validation.services.*;

import lombok.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public record ValidationRuleDto(boolean mandatory,
        boolean unique,
        double max,
        double min,
        String allowedChars,
        List<ValuePair<Integer, String>> subStrings) {

}
