package com.example.task.appTask.dto.task;

public class UpdateTaskDto extends TaskDto {
    public UpdateTaskDto() {
    }

    public UpdateTaskDto(long id, String title, String description, boolean completed) {
        super(id, title, description, completed);
    }
}
