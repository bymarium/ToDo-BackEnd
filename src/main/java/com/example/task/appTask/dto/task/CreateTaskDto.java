package com.example.task.appTask.dto.task;

import jakarta.validation.constraints.NotNull;

public class CreateTaskDto extends TaskDto {
    @NotNull(message = "El documento no puede ser nulo")
    private long userDocument;

    public CreateTaskDto() {
    }

    public CreateTaskDto(long userDocument) {
        this.userDocument = userDocument;
    }

    public CreateTaskDto(long id, String title, String description, boolean completed, long userDocument) {
        super(id, title, description, completed);
        this.userDocument = userDocument;
    }

    @NotNull(message = "El documento no puede ser nulo")
    public long getUserDocument() {
        return userDocument;
    }

    public void setUserDocument(@NotNull(message = "El documento no puede ser nulo") long userDocument) {
        this.userDocument = userDocument;
    }
}
