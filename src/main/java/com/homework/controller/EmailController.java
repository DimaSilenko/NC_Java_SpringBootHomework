package com.homework.controller;

import com.homework.model.EmailContent;
import com.homework.model.ShortUser;
import com.homework.model.User;
import com.homework.operations.UserOperations;
import com.homework.service.DefaultEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmailController {

    @Autowired
    DefaultEmailService defaultEmailService;

    @GetMapping("/send")
    public String sendEmail(@ModelAttribute ShortUser su, Model model) {
        User user = UserOperations.find(su);
        model.addAttribute("user", user);
        EmailContent emailContent = new EmailContent();
        emailContent.setToAddress(user.getEmail());
        model.addAttribute("email", emailContent);
        return "sendPage";
    }

    @PostMapping("/send")
    public String sendMessage(@ModelAttribute EmailContent emailContent, RedirectAttributes attributes) {
        defaultEmailService.sendSimpleEmail(emailContent.getToAddress(),
                emailContent.getSubject(),
                emailContent.getMassage());
        attributes.addFlashAttribute("message", "You successfully send an email!");
        return "redirect:/send";
    }
}
