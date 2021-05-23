package com.homework.controller;

import com.homework.operations.UserOperations;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@Controller
public class UploadController {
    @GetMapping("/upload")
    public String uploadUser() {
        return "uploadPage";
    }

    @PostMapping("/upload")
    public String uploadUser(@RequestParam("file") MultipartFile file, RedirectAttributes attributes) {
        if (file.isEmpty()) {
            attributes.addFlashAttribute("message", "File is Empty");
            return "badResult";
        }

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            Path path = Paths.get(fileName);
            Files.write(path, file.getBytes(), StandardOpenOption.CREATE);
            if (UserOperations.addFromFile(path)) {
                attributes.addFlashAttribute("message", "You successfully uploaded " + fileName + '!');
                return "redirect:/upload";
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "badResult";
    }

}

