package com.tnv.userManager.controller.UsersControllersByRole;

import com.tnv.userManager.model.User;
import com.tnv.userManager.UserDetailsService.JpaUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminUsersController {
    JpaUserDetailsService userService;

    @Autowired
    public AdminUsersController(JpaUserDetailsService userService) {
        this.userService = userService;
    }

    @GetMapping("/hi")
    public String admin() {
        return "Hello, Admin!";
    }

}