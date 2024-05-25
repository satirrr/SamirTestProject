package com.test.samir.service;

import com.test.samir.model.dto.request.MarkCompletedRequest;
import com.test.samir.model.dto.request.TaskRequest;
import com.test.samir.model.dto.response.GetListTaskResponse;
import com.test.samir.model.dto.response.TaskResponse;
import org.springframework.http.ResponseEntity;

public interface TaskService {
    ResponseEntity<TaskResponse> createTask(TaskRequest req);
    ResponseEntity<TaskResponse> markTaskCompleted(MarkCompletedRequest req);
    ResponseEntity<GetListTaskResponse> getIncomplete();
    ResponseEntity<GetListTaskResponse> getAllTask();
}
