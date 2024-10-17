package com.example.task.appTask.dto.task;

public class DeleteTaskDto extends TaskDto {
    public DeleteTaskDto() {
    }

    public DeleteTaskDto(long id, String title, String description, boolean completed) {
        super(id, title, description, completed);
    }
}
