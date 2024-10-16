package com.example.task.appTask.converter;

import com.example.task.appTask.dto.task.CreateTaskDto;
import com.example.task.appTask.dto.task.DeleteTaskDto;
import com.example.task.appTask.dto.task.GetTaskDto;
import com.example.task.appTask.dto.task.UpdateTaskDto;
import com.example.task.appTask.model.Task;
import com.example.task.appTask.model.User;


public class TaskConverter {
    public static Task convertDtoToEntityC (CreateTaskDto taskDto) {
        Task task = new Task();
        task.setId(taskDto.getId());
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setCompleted(taskDto.isCompleted());

        User user = new User();
        user.setDocument(taskDto.getUserDocument());
        task.setUser(user);

        return task;
    }

    public static CreateTaskDto convertEntityToDtoC (Task task) {
        CreateTaskDto taskDto = new CreateTaskDto();
        taskDto.setId(task.getId());
        taskDto.setTitle(task.getTitle());
        taskDto.setDescription(task.getDescription());
        taskDto.setCompleted(task.isCompleted());

        if (task.getUser() != null) {
            taskDto.setUserDocument(task.getUser().getDocument());
        }

        return taskDto;
    }

    public static Task convertDtoToEntityG (GetTaskDto taskDto) {
        Task task = new Task();
        task.setId(taskDto.getId());
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setCompleted(taskDto.isCompleted());

        return task;
    }

    public static GetTaskDto convertEntityToDtoG (Task task) {
        GetTaskDto taskDto = new GetTaskDto();
        taskDto.setId(task.getId());
        taskDto.setTitle(task.getTitle());
        taskDto.setDescription(task.getDescription());
        taskDto.setCompleted(task.isCompleted());

        return taskDto;
    }

    public static UpdateTaskDto convertEntityToDtoU (Task task) {
        UpdateTaskDto taskDto = new UpdateTaskDto();
        taskDto.setId(task.getId());
        taskDto.setTitle(task.getTitle());
        taskDto.setDescription(task.getDescription());
        taskDto.setCompleted(task.isCompleted());
        return taskDto;
    }

    public static DeleteTaskDto convertEntityToDtoD (Task task) {
        DeleteTaskDto taskDto = new DeleteTaskDto();
        taskDto.setId(task.getId());
        taskDto.setTitle(task.getTitle());
        taskDto.setDescription(task.getDescription());
        taskDto.setCompleted(task.isCompleted());
        return taskDto;
    }
}
