package com.test.samir.service;

import com.test.samir.model.dto.request.CreateTaskRequest;
import com.test.samir.model.dto.response.CreateTaskResponse;
import org.springframework.http.ResponseEntity;

public interface TaskService {
    ResponseEntity<CreateTaskResponse> createTask(CreateTaskRequest req);
}
