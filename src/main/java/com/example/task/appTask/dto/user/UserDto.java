package com.example.task.appTask.dto.user;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class UserDto {
    private long document;
    private String userName;
    private String email;
    private String password;
}
