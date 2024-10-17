package com.example.task.appTask.dto.user;

import com.example.task.appTask.dto.task.GetTaskDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GetUserDto extends UserDto {
    public GetUserDto() {
        super();
    }
    private List<GetTaskDto> tasks;
}
