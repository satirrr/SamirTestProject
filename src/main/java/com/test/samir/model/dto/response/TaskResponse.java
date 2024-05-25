package com.test.samir.model.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.test.samir.model.dto.BaseResponse;
import com.test.samir.model.entity.Task;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaskResponse extends BaseResponse {
    private Task task;
}
