package com.example.task.appTask.dto.task;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CreateTaskDto extends TaskDto {
    public CreateTaskDto() {
        super();
    }

    @NotNull(message = "El documento no puede ser nulo")
    private long userDocument;
}
