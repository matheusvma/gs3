package com.gs3.app.common.exceptions;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class ApiErrors {

    @Getter
    private List<String> errors;

    public ApiErrors(List<String> errors) {
        this.errors = errors;
    }

    public ApiErrors(String message) {
        this.errors = Arrays.asList(message);
    }
}
