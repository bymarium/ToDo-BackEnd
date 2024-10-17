package com.example.task.appTask.converter;

import com.example.task.appTask.dto.task.GetTaskDto;
import com.example.task.appTask.dto.user.CreateUserDto;
import com.example.task.appTask.dto.user.DeleteUserDto;
import com.example.task.appTask.dto.user.GetUserDto;
import com.example.task.appTask.dto.user.UpdateUserDto;
import com.example.task.appTask.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserConverter {
    public static User convertDtoToEntityC (CreateUserDto userDto) {
        User user = new User();
        user.setDocument(userDto.getDocument());
        user.setUserName(userDto.getUserName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        return user;
    }

    public static CreateUserDto convertEntityToDtoC (User user) {
        CreateUserDto userDto = new CreateUserDto();
        userDto.setDocument(user.getDocument());
        userDto.setUserName(user.getUserName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        return userDto;
    }

    public static User convertDtoToEntityG (GetUserDto userDto) {
        User user = new User();
        user.setDocument(userDto.getDocument());
        user.setUserName(userDto.getUserName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        List<Task> tasks = userDto.getTasks().stream()
                .map(taskDto -> {
                    Task task = new Task();
                    task.setId(taskDto.getId());
                    task.setTitle(taskDto.getTitle());
                    task.setDescription(taskDto.getDescription());
                    task.setCompleted(taskDto.isCompleted());
                    return task;
                })
                .collect(Collectors.toList());

        user.setTasks(tasks);
        return user;
    }

    public static GetUserDto convertEntityToDtoG (User user) {
        GetUserDto userDto = new GetUserDto();
        userDto.setDocument(user.getDocument());
        userDto.setUserName(user.getUserName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());

        List<GetTaskDto> tasks = new ArrayList<>();

        if (user.getTasks() != null) {
            tasks = user.getTasks().stream()
                    .map(task -> {
                        GetTaskDto taskDto = new GetTaskDto();
                        taskDto.setId(task.getId());
                        taskDto.setTitle(task.getTitle());
                        taskDto.setDescription(task.getDescription());
                        taskDto.setCompleted(task.isCompleted());
                        return taskDto;
                    })
                    .collect(Collectors.toList());
        }

        userDto.setTasks(tasks);
        return userDto;
    }

    public static UpdateUserDto convertEntityToDtoU (User user) {
        UpdateUserDto userDto = new UpdateUserDto();
        userDto.setDocument(user.getDocument());
        userDto.setUserName(user.getUserName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        return userDto;
    }

    public static DeleteUserDto convertEntityToDtoD (User user) {
        DeleteUserDto userDto = new DeleteUserDto();
        userDto.setDocument(user.getDocument());
        userDto.setUserName(user.getUserName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        return userDto;
    }
}
