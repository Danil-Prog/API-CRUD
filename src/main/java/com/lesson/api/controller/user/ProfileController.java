package com.lesson.api.controller.user;

import com.lesson.api.entity.User;
import com.lesson.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProfileController {

    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public String userProfile(@AuthenticationPrincipal User user, Model model){
        model.addAttribute("user", user.getId());
        model.addAttribute("username", user.getUsername());
        model.addAttribute("userRole", user.getRoles());
        model.addAttribute("userGetDateRegistration", user.getDate());
        return "user/profile";
    }

    @PostMapping("/profile/update/{id}")
    public String profileUserUpdate(@PathVariable Long id,
                                    @ModelAttribute("user") User user) {
        User existingUser = userService.findUserById(id);
        existingUser.setUsername(user.getUsername());
        userService.updateUser(existingUser);
        System.out.println("Данные изменены! Новое имя: " + user.getUsername());

        return "redirect:/logout";
    }
}
