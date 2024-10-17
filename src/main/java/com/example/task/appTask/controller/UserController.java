package com.example.task.appTask.controller;

import com.example.task.appTask.dto.user.*;
import com.example.task.appTask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/saveUser")
    public ResponseEntity<CreateUserDto> saveUser(@RequestBody CreateUserDto userDto) {
        return new ResponseEntity<CreateUserDto>(userService.saveUser(userDto), HttpStatus.CREATED);
    }

    //GetAll Rest Api
    @GetMapping("/getAllUsers")
    public ResponseEntity<List<GetUserDto>> getAllUsers() {
        List<GetUserDto> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    //Get by document Rest Api
    @GetMapping("/getUserById/{document}")
    //localhost:8080/api/users/1
    public ResponseEntity<GetUserDto> getUserById(@PathVariable("document") long userDocument) {
        return new ResponseEntity<GetUserDto>(userService.getUserById(userDocument), HttpStatus.OK);
    }

    //Update Rest Api
    @PutMapping("/updateUser/{document}")
    public ResponseEntity<UpdateUserDto> updateUser(@PathVariable("document") long document, @RequestBody UpdateUserDto userDto) {
        return new ResponseEntity<UpdateUserDto>(userService.updateUser(userDto, document), HttpStatus.OK);
    }

    //Delete Rest Api
    @DeleteMapping("/deleteUser/{document}")
    public ResponseEntity<DeleteUserDto> deleteUser(@PathVariable("document") long document) {
        //delete user from database
        DeleteUserDto userDto = userService.deleteUser(document);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }
}
