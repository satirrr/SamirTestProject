package com.test.samir;

import com.test.samir.model.entity.Task;
import com.test.samir.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SamirApplication implements CommandLineRunner {
	@Autowired
	TaskRepository taskRepository;

	public static void main(String[] args) {
		SpringApplication.run(SamirApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Task task1 = new Task(1, "mencuci", false);
		Task task2 = new Task(2, "berenang", false);
		Task task3 = new Task(2, "meeting at 9", false);
		Task task4 = new Task(2, "belanja", true);
		taskRepository.saveAll(Arrays.asList(task1, task2, task3, task4));
	}

}
