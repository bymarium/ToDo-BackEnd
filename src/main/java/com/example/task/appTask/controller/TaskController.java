package com.example.task.appTask.controller;

import com.example.task.appTask.dto.task.CreateTaskDto;
import com.example.task.appTask.dto.task.DeleteTaskDto;
import com.example.task.appTask.dto.task.GetTaskDto;
import com.example.task.appTask.dto.task.UpdateTaskDto;
import com.example.task.appTask.service.interfaces.ITaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final ITaskService taskService;

    public TaskController(ITaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<CreateTaskDto> saveTask(@Valid @RequestBody CreateTaskDto taskDto) {
        return new ResponseEntity<CreateTaskDto>(taskService.saveTask(taskDto), HttpStatus.CREATED);
    }

    //GetAll Rest Api
    @GetMapping
    public ResponseEntity<List<GetTaskDto>> getAllTasks() {
        List<GetTaskDto> tasks = taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    //Get by document Rest Api
    @GetMapping("{id}")
    //localhost:8080/api/tasks/1
    public ResponseEntity<GetTaskDto> getTaskById(@PathVariable("id") long taskId) {
        return new ResponseEntity<>(taskService.getTaskById(taskId), HttpStatus.OK);
    }

    //Update Rest Api
    @PutMapping("{id}")
    public ResponseEntity<UpdateTaskDto> updateTask(@PathVariable("id") long id, @RequestBody UpdateTaskDto taskDto) {
        return new ResponseEntity<UpdateTaskDto>(taskService.updateTask(taskDto, id), HttpStatus.OK);
    }

    //Delete Rest Api
    @DeleteMapping("{id}")
    public ResponseEntity<DeleteTaskDto> deleteTask(@PathVariable("id") long id) {
        //delete task from database
        DeleteTaskDto taskDto = taskService.deleteTask(id);
        return new ResponseEntity<>(taskDto, HttpStatus.OK);
   }
}
