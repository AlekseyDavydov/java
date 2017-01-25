package ru.itis.dto;

/**
 * Created by home on 22.01.2017.
 */
public class AutoDto {
    public String getColor() {
        return color;
    }

    public Integer getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    private Integer id;
    private String model;
    private String color;
    private UserDto userDto;

    public AutoDto() {
    }

    private AutoDto(AutoDtoBuilder autoDto) {
        this.id = autoDto.id;
        this.model = autoDto.model;
        this.color = autoDto.color;
        this.userDto = autoDto.userDto;
    }

    public static class AutoDtoBuilder {
        private Integer id;
        private String model;
        private String color;
        private UserDto userDto;

        public AutoDtoBuilder id(Integer value) {
            this.id = value;
            return this;
        }

        public AutoDtoBuilder model(String value) {
            this.model = value;
            return this;
        }

        public AutoDtoBuilder color(String value) {
            this.color = value;
            return this;
        }

        public AutoDtoBuilder userDto(UserDto value) {
            this.userDto = value;
            return this;
        }

        public AutoDto build() {
            return new AutoDto(this);
        }
    }
}
