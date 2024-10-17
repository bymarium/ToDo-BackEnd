package com.example.task.appTask.dto.user;

public class DeleteUserDto extends UserDto{
    public DeleteUserDto() {
    }

    public DeleteUserDto(long document, String userName, String email, String password) {
        super(document, userName, email, password);
    }
}
