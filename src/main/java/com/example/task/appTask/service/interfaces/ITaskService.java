package com.example.task.appTask.service.interfaces;

import com.example.task.appTask.dto.task.CreateTaskDto;
import com.example.task.appTask.dto.task.DeleteTaskDto;
import com.example.task.appTask.dto.task.GetTaskDto;
import com.example.task.appTask.dto.task.UpdateTaskDto;

import java.util.List;

public interface ITaskService {
    CreateTaskDto saveTask(CreateTaskDto taskDto);
    List<GetTaskDto> getAllTasks();
    GetTaskDto getTaskById(long id);
    UpdateTaskDto updateTask(UpdateTaskDto taskDto, long id);
    DeleteTaskDto deleteTask(long id);
}
