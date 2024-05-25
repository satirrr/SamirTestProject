package com.test.samir.repository;

import com.test.samir.model.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    TaskRepository taskRepository;

    @Override
    public void run(String... args) throws Exception {
        Task task1 = new Task(1, "mencuci", false);
        Task task2 = new Task(2, "belanja", true);
        taskRepository.saveAll(Arrays.asList(task1, task2));
    }
}
