package com.example.task.appTask.dto.task;

public class GetTaskDto extends TaskDto{
    public GetTaskDto() {
    }

    public GetTaskDto(long id, String title, String description, boolean completed) {
        super(id, title, description, completed);
    }
}
