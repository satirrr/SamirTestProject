package com.test.samir.repository;

import com.test.samir.model.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    @Query(value = "SELECT * FROM TASK WHERE completed = false", nativeQuery = true)
    List<Task> findByCompleted();
}
