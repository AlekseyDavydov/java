package ru.itis.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.converter.AutoToAutoDtoConverter;
import ru.itis.dto.AutoDto;
import ru.itis.models.Auto;
import ru.itis.models.User;
import ru.itis.service.AutoService;
import ru.itis.service.UsersService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class RestAutoController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private AutoService autoService;

    @GetMapping(value = "/users/{user-id}/auto")
    List<AutoDto> viewAutoByUsers(@PathVariable("user-id") int id) {

        List<AutoDto> result = new ArrayList<>();

        List<Auto> autos = usersService.getUser(id).getAuto();
        for (Auto auto1 : autos) {
            result.add(AutoToAutoDtoConverter.convertWithUser(auto1));
        }
        return result;
    }


    @PostMapping(value = "users/{user-id}/auto")
    public ResponseEntity<List<AutoDto>> addAuto(@ModelAttribute("auto") Auto auto,
                                                 @PathVariable("user-id") int userId) {
        User user = usersService.getUser(userId);
        System.out.println(user);
        Auto auto1 = new Auto.AutoBuilder()
                .id(auto.getId())
                .model(auto.getModel())
                .color(auto.getColor())
                .user(user)
                .build();
        autoService.saveAuto(auto1);
        List<AutoDto> result = new ArrayList<>();
        List<Auto> autos = usersService.getUser(userId).getAuto();
        for (Auto auto2 : autos) {
            result.add(AutoToAutoDtoConverter.convertWithUser(auto2));
        }
        ResponseEntity<List<AutoDto>> respons = new ResponseEntity<List<AutoDto>>(result, HttpStatus.OK);
        return respons;

    }


}





