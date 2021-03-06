package ru.itis.converter;

import ru.itis.dto.AutoDto;
import ru.itis.dto.UserDto;
import ru.itis.models.Auto;

public class AutoToAutoDtoConverter {
    public static AutoDto convertWithoutUser(Auto auto) {
        AutoDto autoDto = new AutoDto.AutoDtoBuilder()
                .id(auto.getId())
                .model(auto.getModel())
                .color(auto.getColor())
                .build();
        return autoDto;
    }

    public static AutoDto convertWithUser(Auto auto) {
        UserDto userDto = UserToUserDtoConverter.convertWithoutAutos(auto.getUser());
        AutoDto autoDto = new AutoDto.AutoDtoBuilder()
                .id(auto.getId())
                .model(auto.getModel())
                .color(auto.getColor())
                .userDto(userDto)
                .build();
        return autoDto;
    }
}
