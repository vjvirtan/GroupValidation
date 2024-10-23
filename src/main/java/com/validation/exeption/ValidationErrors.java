package com.validation.exeption;

import java.util.*;

public record ValidationErrors(List<ValidationError<String, String>> errors) {

}
