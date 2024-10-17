package com.example.task.appTask.dto.user;

import com.example.task.appTask.dto.task.GetTaskDto;

import java.util.List;

public class GetUserDto extends UserDto {
    private List<GetTaskDto> tasks;

    public GetUserDto() {
    }

    public GetUserDto(List<GetTaskDto> tasks) {
        this.tasks = tasks;
    }

    public GetUserDto(long document, String userName, String email, String password, List<GetTaskDto> tasks) {
        super(document, userName, email, password);
        this.tasks = tasks;
    }

    public List<GetTaskDto> getTasks() {
        return tasks;
    }

    public void setTasks(List<GetTaskDto> tasks) {
        this.tasks = tasks;
    }
}
