package com.test.samir.custom;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum CustomResponse {
    SUCCESS("200", "success"),
    BAD_REQUEST("400", "bad request"),
    GENERAL_ERROR("500", "Internal Service Error")
    ;
    private final String code;
    private final String message;
}
