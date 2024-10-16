package com.example.task.appTask.service.interfaces;

import com.example.task.appTask.dto.user.*;

import java.util.List;

public interface IUserService {
    CreateUserDto saveUser(CreateUserDto userDto);
    List<GetUserDto> getAllUsers();
    GetUserDto getUserById(long document);
    UpdateUserDto updateUser(UpdateUserDto userDto, long document);
    DeleteUserDto deleteUser(long document);
}
