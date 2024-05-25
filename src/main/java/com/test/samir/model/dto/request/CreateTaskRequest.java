package com.test.samir.model.dto.request;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@JsonSerialize
public class CreateTaskRequest {
    @NotBlank(message = "field {task} should not be empty")
    private String task;
}
