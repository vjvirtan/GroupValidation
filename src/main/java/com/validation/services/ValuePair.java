package com.validation.services;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ValuePair<T, K>(T key, K value) {

}
