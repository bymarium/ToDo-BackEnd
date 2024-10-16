package com.example.task.appTask.service;

import com.example.task.appTask.converter.TaskConverter;
import com.example.task.appTask.dto.task.CreateTaskDto;
import com.example.task.appTask.dto.task.DeleteTaskDto;
import com.example.task.appTask.dto.task.GetTaskDto;
import com.example.task.appTask.dto.task.UpdateTaskDto;
import com.example.task.appTask.model.Task;
import com.example.task.appTask.repository.ITaskRepository;
import com.example.task.appTask.service.interfaces.ITaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService implements ITaskService {
    private final ITaskRepository taskRepository;

    public TaskService(ITaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    //save task in database
    @Override
    public CreateTaskDto saveTask(CreateTaskDto taskDto) {
        Task task = TaskConverter.convertDtoToEntityC(taskDto);
        taskRepository.save(task);
        return TaskConverter.convertEntityToDtoC(task);
    }

    //get all tasks form database
    @Override
    public List<GetTaskDto> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();

        return tasks.stream()
                .map(TaskConverter::convertEntityToDtoG)
                .toList();
    }

    //get task using id
    @Override
    public GetTaskDto getTaskById(long id) {
        Optional<Task> taskOptional = taskRepository.findById(id);

        if (taskOptional.isPresent()) {
            Task task = taskOptional.get();
            return TaskConverter.convertEntityToDtoG(task);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    //update task
    @Override
    public UpdateTaskDto updateTask(UpdateTaskDto taskDto, long id) {
        Task existingTask = taskRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Task not found")
        );

        existingTask.setTitle(taskDto.getTitle());
        existingTask.setDescription(taskDto.getDescription());
        existingTask.setCompleted(taskDto.isCompleted());
        //save
        taskRepository.save(existingTask);
        return TaskConverter.convertEntityToDtoU(existingTask);
    }

    //delete task
    @Override
    public DeleteTaskDto deleteTask(long id) {
        //check
        Task task = taskRepository.findById(id).orElseThrow(()->new RuntimeException("Task not found"));
        //delete
        taskRepository.deleteById(id);

        return TaskConverter.convertEntityToDtoD(task);
    }
}
