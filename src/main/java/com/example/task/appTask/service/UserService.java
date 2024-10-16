package com.example.task.appTask.service;

import com.example.task.appTask.dto.user.CreateUserDto;
import com.example.task.appTask.dto.user.DeleteUserDto;
import com.example.task.appTask.dto.user.GetUserDto;
import com.example.task.appTask.dto.user.UpdateUserDto;
import com.example.task.appTask.model.User;
import com.example.task.appTask.converter.UserConverter;
import com.example.task.appTask.repository.IUserRepository;
import com.example.task.appTask.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {
    private final IUserRepository userRepository;
    @Autowired
    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //save user in database
    @Override
    public CreateUserDto saveUser(CreateUserDto userDto) {
        User user = UserConverter.convertDtoToEntityC(userDto);
        userRepository.save(user);
        return UserConverter.convertEntityToDtoC(user);
    }

    //get all users form database
    @Override
    public List<GetUserDto> getAllUsers() {
        List<User> users = userRepository.findAll();

        return users.stream()
                .map(UserConverter::convertEntityToDtoG)
                .collect(Collectors.toList());
    }

    //get user using id
    @Override
    public GetUserDto getUserById(long document) {
        Optional<User> userOptional = userRepository.findById(document);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return UserConverter.convertEntityToDtoG(user);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    //update user
    @Override
    public UpdateUserDto updateUser(UpdateUserDto userDto, long document) {
        User existingUser = userRepository.findById(document).orElseThrow(
                () -> new RuntimeException("User not found")
        );

        existingUser.setUserName(userDto.getUserName());
        existingUser.setEmail(userDto.getEmail());
        existingUser.setPassword(userDto.getPassword());

        //save
        userRepository.save(existingUser);
        return UserConverter.convertEntityToDtoU(existingUser);
    }

    //delete user
    @Override
    public DeleteUserDto deleteUser(long document) {
        //check
        User user = userRepository.findById(document).orElseThrow(() -> new RuntimeException("Document not found"));
        //delete
        userRepository.deleteById(document);

        return UserConverter.convertEntityToDtoD(user);
    }
}
