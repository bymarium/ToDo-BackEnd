package com.example.task.appTask.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class UserDto {
    private long document;
    private String userName;
    private String email;
    private String password;
}
