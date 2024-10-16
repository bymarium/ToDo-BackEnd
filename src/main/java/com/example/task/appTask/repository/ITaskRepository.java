package com.example.task.appTask.repository;

import com.example.task.appTask.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITaskRepository extends JpaRepository<Task, Long> {
}
