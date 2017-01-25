package ru.itis.converter;

import ru.itis.dto.AutoDto;
import ru.itis.dto.UserDto;
import ru.itis.models.Auto;
import ru.itis.models.User;

import java.util.ArrayList;

public class UserToUserDtoConverter {
    public static UserDto convertWithoutAutos(User user) {
        UserDto userDto = new UserDto.UserDtoBuilder()
                .id(user.getId())
                .name(user.getName())
                .age(user.getAge())
                .build();
        return userDto;
    }

    public static UserDto convertWithAutos(User user) {
        UserDto userDto = new UserDto.UserDtoBuilder()
                .id(user.getId())
                .name(user.getName())
                .age(user.getAge())
                .autoDto(new ArrayList<AutoDto>())
                .build();
        for (Auto auto : user.getAuto()) {
            AutoDto autoDto = AutoToAutoDtoConverter.convertWithoutUser(auto);
            userDto.getAutoDto().add(autoDto);
        }
        return userDto;
    }
}
