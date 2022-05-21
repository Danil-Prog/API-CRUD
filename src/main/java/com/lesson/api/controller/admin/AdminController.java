package com.lesson.api.controller.admin;


import com.lesson.api.entity.User;
import com.lesson.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/admin/v1/users")
    public String userList(Model model){
        model.addAttribute("userList", userService.allUsers());
        return "admin/users";
    }

}
