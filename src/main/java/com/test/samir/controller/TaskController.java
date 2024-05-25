package com.test.samir.controller;

import com.test.samir.model.dto.request.CreateTaskRequest;
import com.test.samir.model.dto.response.CreateTaskResponse;
import com.test.samir.service.TaskService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    TaskService taskService;

    @PostMapping("/create")
    public ResponseEntity<CreateTaskResponse> createTask(
            @Valid @RequestBody CreateTaskRequest createTaskRequest,
            HttpServletRequest request
    ){
        return taskService.createTask(createTaskRequest);
    }
}
