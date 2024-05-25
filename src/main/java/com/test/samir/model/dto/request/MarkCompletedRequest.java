package com.test.samir.model.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MarkCompletedRequest {
    @NotNull(message = "field {taskId} should not be empty")
    private Integer taskId;
}