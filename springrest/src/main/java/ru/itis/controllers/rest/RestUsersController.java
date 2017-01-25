package ru.itis.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.converter.UserToUserDtoConverter;
import ru.itis.dto.UserDto;
import ru.itis.models.User;
import ru.itis.service.UsersService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest")

public class RestUsersController {

    @Autowired
    private UsersService usersService;


    @GetMapping(value = "/users")
    List<UserDto> getUser() {
        List<UserDto> result = new ArrayList<>();

        List<User> users = usersService.findAll();
        for (User user : users) {
            result.add(UserToUserDtoConverter.convertWithAutos(user));
        }
        return result;
    }


    @PostMapping(value = "/users")
    public ResponseEntity<List<UserDto>> save(@RequestBody UserDto userDto) {
        User user = new User.UserBuild()
                .id(userDto.getId())
                .age(userDto.getAge())
                .name(userDto.getName())
                .build();
        usersService.save(user);
        List<UserDto> result = new ArrayList<>();
        List<User> users = usersService.findAll();
        for (User currentUser : users) {
            result.add(UserToUserDtoConverter.convertWithAutos(currentUser));
        }
        ResponseEntity<List<UserDto>> response = new
                ResponseEntity<List<UserDto>>(result, HttpStatus.CREATED);
        return response;
    }

    @DeleteMapping(value = "/users/{userId}")
    public ResponseEntity<List<UserDto>> deleteUser(@PathVariable("user-d") int userId) {
        usersService.delete(userId);
        List<UserDto> result = new ArrayList<>();
        List<User> users = usersService.findAll();
        for (User currentUser : users) {
            result.add(UserToUserDtoConverter.convertWithAutos(currentUser));
        }
        ResponseEntity<List<UserDto>> response = new
                ResponseEntity<List<UserDto>>(result, HttpStatus.OK);

        return response;
    }

    @PutMapping(value = "/users/{userId}")
    public ResponseEntity<List<UserDto>> updateUser(@PathVariable("user-id") int userId,
                                                    @RequestParam("name") String name,
                                                    @RequestParam("age") int age) {
        User user = new User.UserBuild()
                .id(userId)
                .name(name)
                .age(age)
                .build();
        usersService.update(user);
        List<UserDto> result = new ArrayList<>();
        List<User> users = usersService.findAll();
        for (User currentUser : users) {
            result.add(UserToUserDtoConverter.convertWithoutAutos(currentUser));
        }
        ResponseEntity<List<UserDto>> response = new
                ResponseEntity<List<UserDto>>(result, HttpStatus.OK);

        return response;
    }


}