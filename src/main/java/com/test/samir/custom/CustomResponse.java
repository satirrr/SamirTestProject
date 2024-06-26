package com.test.samir.custom;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum CustomResponse {
    SUCCESS("200", "success"),
    BAD_REQUEST("400", "bad Request"),
    GENERAL_ERROR("500", "Internal Service Error"),
    TASK_NOT_FOUND("400", "Task Not Found or Already Completed"),
    TASK_EMPTY("201", "There's No Task Available"),
    NO_INCOMPLETE("201", "There's No Incomplete Task")
    ;
    private final String code;
    private final String message;
}