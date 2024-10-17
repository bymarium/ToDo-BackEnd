package com.example.task.appTask.dto.user;

public class CreateUserDto extends UserDto{
    public CreateUserDto() {
    }

    public CreateUserDto(long document, String userName, String email, String password) {
        super(document, userName, email, password);
    }
}

