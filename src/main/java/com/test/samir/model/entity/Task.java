package com.test.samir.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "task")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "task")
    private String task;

    @Column(name = "completed")
    private  Boolean completed;

    @Column(name = "created_date", columnDefinition = "timestamp")
    private LocalDate createdDate;

    public Task(Integer id, String task, Boolean completed) {
        this.id = id;
        this.task = task;
        this.completed = completed;
    }

    @JsonIgnore
    @PrePersist
    public void setCreatedDate() {
        this.createdDate = LocalDate.now();
    }
}
