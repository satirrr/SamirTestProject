package com.test.samir.model.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.test.samir.model.dto.BaseResponse;
import com.test.samir.model.entity.Task;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetListTaskResponse extends BaseResponse {
    @JsonProperty(value = "incompleteTasks")
    private List<Task> tasks;
}
