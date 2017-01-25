package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.models.Auto;
import ru.itis.models.User;
import ru.itis.service.AutoService;
import ru.itis.service.UsersService;

import java.util.List;

@Controller
public class AutoController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private AutoService autoService;


    @ResponseBody
    @RequestMapping(value = "/users/{user-id}/auto", method = RequestMethod.GET)
    ModelAndView viewAutoByUsers(@PathVariable("user-id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("просмотр авто");
        System.out.println(usersService.getUser(id).getAuto());
        modelAndView.addObject("autos", usersService.getUser(id).getAuto());
        //   modelAndView.addObject("userid", id);
        modelAndView.addObject("auto", new Auto());
        modelAndView.setViewName("auto");
        return modelAndView;
    }


    //users/{user-id}/auto
    @PostMapping(value = "users/{user-id}/auto")

    @ResponseBody
    ModelAndView addAuto(
            @ModelAttribute("auto") Auto auto,
            @PathVariable("user-id") int userId) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("Добавление авто");
        //  Auto auto1 =
        User user = usersService.getUser(userId);
       // auto.setUser(user);
       System.out.println(user);
        Auto auto1 = new Auto.AutoBuilder()
                .id(auto.getId())
                .model(auto.getModel())
                .color(auto.getColor())
                .user(user)
                .build();
        System.out.println(auto);
        autoService.saveAuto(auto1);
        List<Auto> autoList = usersService.getUser(userId).getAuto();
        modelAndView.addObject("autos", autoList);
        modelAndView.setViewName("auto");
        return modelAndView;


    }

    @PostMapping(value = "/users/{user-id}/auto/{auto-id}")
    @ResponseBody
    ModelAndView showUpdatePage(
            @PathVariable("auto-id") int autoId) {
        System.out.println("   @PostMapping переход на редактирование");
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(autoService.findAuto(autoId));
        Auto auto = autoService.findAuto(autoId);
        System.out.println(auto);
        modelAndView.addObject("auto", auto);
        // modelAndView.addObject("auto", new Auto());
        modelAndView.setViewName("updateAuto");
        return modelAndView;
    }

    @PutMapping(value = "/users/{user-id}/auto/{auto-id}")
    public String updateAuto(
            @PathVariable("user-id") int userId,
            @PathVariable("auto-id") int autoId,
            @RequestParam("model") String model,
            @RequestParam("color") String color) {
        System.out.println("Редактирование");
        Auto auto = autoService.findAuto(autoId);
        Auto auto2 = new Auto.AutoBuilder()
                .id(autoId)
                .model(model)
                .color(color)
                .user(auto.getUser())
                .build();
        System.out.println(auto2);
        autoService.update(auto2);
        return "redirect:/users/" + userId + "/auto";
    }

    @DeleteMapping(value = "/users/{user-id}/auto/{auto-id}")
    public String deleteAuto(
            @PathVariable("user-id") int userId,
            @PathVariable("auto-id") int autoId) {
        System.out.println("удаление автомобиля");
        System.out.println("delete User");
        autoService.deleteAuto(autoId);
        return "redirect:/users/" + userId + "/auto";

    }


}





