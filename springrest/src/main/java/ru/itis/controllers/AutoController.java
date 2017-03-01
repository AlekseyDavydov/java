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
        modelAndView.addObject("autos", usersService.getUser(id).getAuto());
        modelAndView.addObject("auto", new Auto());
        modelAndView.setViewName("auto");
        return modelAndView;
    }

    @ResponseBody
    @PostMapping(value = "users/{user-id}/auto")
       ModelAndView addAuto(
            @ModelAttribute("auto") Auto auto,
            @PathVariable("user-id") int userId) {
        ModelAndView modelAndView = new ModelAndView();
        User user = usersService.getUser(userId);
        Auto auto1 = new Auto.AutoBuilder()
                .id(auto.getId())
                .model(auto.getModel())
                .color(auto.getColor())
                .user(user)
                .build();
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
        ModelAndView modelAndView = new ModelAndView();
        Auto auto = autoService.findAuto(autoId);
        modelAndView.addObject("auto", auto);
        modelAndView.setViewName("updateAuto");
        return modelAndView;
    }

    @PutMapping(value = "/users/{user-id}/auto/{auto-id}")
    public String updateAuto(
            @PathVariable("user-id") int userId,
            @PathVariable("auto-id") int autoId,
            @RequestParam("model") String model,
            @RequestParam("color") String color) {
        Auto auto = autoService.findAuto(autoId);
        Auto auto2 = new Auto.AutoBuilder()
                .id(autoId)
                .model(model)
                .color(color)
                .user(auto.getUser())
                .build();
        autoService.update(auto2);
        return "redirect:/users/" + userId + "/auto";
    }

    @DeleteMapping(value = "/users/{user-id}/auto/{auto-id}")
    public String deleteAuto(
            @PathVariable("user-id") int userId,
            @PathVariable("auto-id") int autoId) {
        autoService.deleteAuto(autoId);
        return "redirect:/users/" + userId + "/auto";
    }
}





