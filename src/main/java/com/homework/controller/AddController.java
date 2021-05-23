package com.homework.controller;

import com.homework.model.User;
import com.homework.operations.UserOperations;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AddController {

    @GetMapping("/add")
    public String userAdd(User user) {
        return "addPage";
    }

    @PostMapping("/add")
    public String userAdd(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/addPage";
            //return userSubmit(model);
        } else {
            UserOperations.add(user);
            return "goodResult";
        }
    }
}
