package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.models.User;
import ru.itis.service.UsersService;

import java.util.List;

@Controller
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping(value = {"/", "/index"})
    @ResponseBody
    ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }


    @GetMapping(value = "/users")
    @ResponseBody
    ModelAndView getUsers() {
        ModelAndView modelAndView = new ModelAndView();
        List<User> userList = usersService.findAll();
        modelAndView.addObject("users", userList);
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("users");
        return modelAndView;
    }

    @PostMapping(value = "/users")
    @ResponseBody
    ModelAndView addUser(@ModelAttribute("user") User user) {
        usersService.save(new User.UserBuild()
                .id(user.getId())
                .name(user.getName())
                .age(user.getAge())
                .build());
        return getUsers();
    }

    @DeleteMapping(value = "/users/{user-id}")
    public String deleteUser(
            @PathVariable("user-id") int userId) {
        usersService.delete(userId);
        return "redirect:/users";
    }

    @PostMapping(value = "/users/{user-id}")
    @ResponseBody
    ModelAndView showUpdatePage(
            @PathVariable("user-id") int userId) {
        ModelAndView modelAndView = new ModelAndView();
        User user = usersService.getUser(userId);
        modelAndView.addObject("user", user);
        modelAndView.setViewName("updateUser");
        return modelAndView;
    }

    @PutMapping(value = "/users/{user-id}")
    public String updateUser(@PathVariable("user-id") int userId,
                             @RequestParam("name") String name,
                             @RequestParam("age") int age) {
        User user = new User.UserBuild()
                .id(userId)
                .name(name)
                .age(age)
                .build();
        usersService.update(user);
        return "redirect:/users";
    }
}