package com.test.samir.model.dto.request;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

import java.util.List;

@Getter
@JsonSerialize
public class ProblemSolvingRequest {
    @NotEmpty(message = "invalid input {numbers}")
    List<Integer> numbers;
}
