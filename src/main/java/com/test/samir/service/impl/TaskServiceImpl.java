package com.test.samir.service.impl;

import com.test.samir.custom.CustomResponse;
import com.test.samir.model.dto.request.MarkCompletedRequest;
import com.test.samir.model.dto.request.TaskRequest;
import com.test.samir.model.dto.response.GetListTaskResponse;
import com.test.samir.model.dto.response.TaskResponse;
import com.test.samir.model.entity.Task;
import com.test.samir.repository.TaskRepository;
import com.test.samir.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskRepository taskRepository;

    @Override
    public ResponseEntity<TaskResponse> createTask(TaskRequest req) {
        TaskResponse response = new TaskResponse();
        HttpStatus httpStatus = HttpStatus.OK;
        try {
            Task task = new Task();
            task.setTask(req.getTask());
            task.setCompleted(false);

            task = taskRepository.saveAndFlush(task);
            response.setResponse(CustomResponse.SUCCESS);
            response.setTask(task);
        }catch (Exception e){
            e.printStackTrace();
            response.setResponse(CustomResponse.GENERAL_ERROR);
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(response, httpStatus);
    }

    @Override
    public ResponseEntity<TaskResponse> markTaskCompleted(MarkCompletedRequest req) {
        TaskResponse response = new TaskResponse();
        HttpStatus httpStatus = HttpStatus.OK;
        try {
            Task task = taskRepository.findByCompleted(req.getTaskId());
            if (Objects.isNull(task)) {
                response.setResponse(CustomResponse.TASK_NOT_FOUND);
                return ResponseEntity.badRequest().body(response);
            }
            task.setCompleted(true);
            task = taskRepository.saveAndFlush(task);
            response.setTask(task);
        }catch (Exception e) {
            e.printStackTrace();
            response.setResponse(CustomResponse.GENERAL_ERROR);
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(response, httpStatus);
    }

    @Override
    public ResponseEntity<GetListTaskResponse> getAllTask() {
        GetListTaskResponse response = new GetListTaskResponse();
        HttpStatus httpStatus = HttpStatus.OK;
        try {
            List<Task> tasks = taskRepository.findAll();
            if (tasks.isEmpty()){
                response.setResponse(CustomResponse.TASK_EMPTY);
                return ResponseEntity.accepted().body(response);
            }
            response.setTasks(tasks);
            response.setResponse(CustomResponse.SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            response.setResponse(CustomResponse.GENERAL_ERROR);
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(response, httpStatus);
    }

    @Override
    public ResponseEntity<GetListTaskResponse> getIncomplete() {
        GetListTaskResponse response = new GetListTaskResponse();
        HttpStatus httpStatus = HttpStatus.OK;

        try {
            List<Task> tasks = taskRepository.findAllIncompleted();
            if (tasks.isEmpty()){
                response.setResponse(CustomResponse.NO_INCOMPLETE);
                return ResponseEntity.accepted().body(response);
            }
            response.setTasks(tasks);
            response.setResponse(CustomResponse.SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            response.setResponse(CustomResponse.GENERAL_ERROR);
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(response, httpStatus);
    }
}
