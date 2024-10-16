package com.example.task.appTask.dto.user;

import com.example.task.appTask.dto.task.GetTaskDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GetUserDto extends UserDto {
    public GetUserDto() {
        super();
    }
    private List<GetTaskDto> tasks;
}
