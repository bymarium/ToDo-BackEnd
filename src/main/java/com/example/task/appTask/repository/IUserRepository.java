package com.example.task.appTask.repository;

import com.example.task.appTask.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
}
