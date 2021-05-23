package com.homework.controller;

import com.homework.model.ShortUser;
import com.homework.model.User;
import com.homework.operations.UserOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Controller
public class FindController {
    @GetMapping("/find")
    public String findUser(ShortUser shortUser) {
        return "findPage";
    }

    @PostMapping("/find")
    public String findUser(@Valid ShortUser shortUser, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "/findPage";
        } else {
            User findUser = UserOperations.find(shortUser);

            if (findUser == null) {
                return "redirect:/notFounded";
            } else {
                model.addAttribute("findUser", findUser);
                model.addAttribute("localDateTime", LocalDateTime.now());
                return "information";
            }
        }
    }

    @GetMapping("/notFounded")
    public String notFounded() {
        return "notFounded";
    }
}
