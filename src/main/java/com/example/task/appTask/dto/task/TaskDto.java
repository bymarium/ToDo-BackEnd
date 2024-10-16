package com.example.task.appTask.dto.task;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class TaskDto {
    private long id;
    private String title;
    private String description;
    private boolean completed;
}
