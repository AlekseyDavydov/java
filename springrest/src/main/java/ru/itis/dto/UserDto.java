package ru.itis.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

    private Integer id;
    private String name;
    private Integer age;
    private List<AutoDto> autoDto;

    public UserDto() {
    }

    private UserDto(UserDtoBuilder userDto) {
        this.id = userDto.id;
        this.name = userDto.name;
        this.age = userDto.age;
        this.autoDto = userDto.autoDto;

    }

    public static class UserDtoBuilder {
        private Integer id;
        private String name;
        private Integer age;
        private List<AutoDto> autoDto;

        public UserDtoBuilder id(Integer value) {
            this.id = value;
            return this;
        }

        public UserDtoBuilder name(String value) {
            this.name = value;
            return this;
        }

        public UserDtoBuilder age(Integer value) {
            this.age = value;
            return this;
        }

        public UserDtoBuilder autoDto(List<AutoDto> value) {
            this.autoDto = value;
            return this;
        }

        public UserDto build() {
            return new UserDto(this);
        }
    }

    public Integer getAge() {
        return age;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<AutoDto> getAutoDto() {
        return autoDto;
    }

}
