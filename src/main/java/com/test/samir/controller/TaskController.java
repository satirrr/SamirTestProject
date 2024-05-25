package com.test.samir.controller;

import com.test.samir.model.dto.request.MarkCompletedRequest;
import com.test.samir.model.dto.request.TaskRequest;
import com.test.samir.model.dto.response.TaskResponse;
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
    public ResponseEntity<TaskResponse> createTask(
            @Valid @RequestBody TaskRequest req,
            HttpServletRequest request
    ){
        return taskService.createTask(req);
    }

    @PostMapping("/mark-complete")
    public ResponseEntity<TaskResponse> createTask(
            @Valid @RequestBody MarkCompletedRequest req,
            HttpServletRequest request
    ){
        return taskService.markTaskCompleted(req);
    }
}
