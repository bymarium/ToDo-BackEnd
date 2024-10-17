package com.example.task.appTask.dto.user;

public class UpdateUserDto extends UserDto{
    public UpdateUserDto() {
    }

    public UpdateUserDto(long document, String userName, String email, String password) {
        super(document, userName, email, password);
    }
}
