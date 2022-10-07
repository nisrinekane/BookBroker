package com.nisrinekane.bookbroker.controllers;


import com.nisrinekane.bookbroker.models.User;
import com.nisrinekane.bookbroker.services.BookService;
import com.nisrinekane.bookbroker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    BookService bookService;

    // show all users
    @RequestMapping("/users")
    public String index(Model model, @ModelAttribute("user") User user) {
        List<User> users = userService.allUsers();
        model.addAttribute("users", users);
        return "users.jsp";
    }

    //show one user
    @GetMapping("/users/{id}")
    public String showPerson(@PathVariable Long id, Model model) {
        User user = userService.findUser(id);
        model.addAttribute("user", user);
        return "showOneUser.jsp";
    }

    //create new user: render the form
    @GetMapping("/users/new")
    public String createUserForm(Model model, @ModelAttribute("user") User user ) {
        return "newUser.jsp";
    }

    //create user: post route/ process data
    @PostMapping("/createUser")
    public String createUser(@Valid @ModelAttribute("user") User user, BindingResult result) {
        if (result.hasErrors()) {
            return "newUser.jsp";
        }
        userService.createUser(user);
        return "redirect:/users";
    }

    //update user: render form
    @RequestMapping("/users/{userId}/edit")
    public String editUser(@PathVariable("userId") Long userId, Model model) {
        User user = userService.findUser(userId);
        model.addAttribute("user", user);
        return "editUser.jsp";
    }

    //update user: process data
    @PutMapping ("/users/{id}")
    public String updateUser(@Valid @ModelAttribute("user") User user, BindingResult result) {
        if (result.hasErrors()) {
            return "editUser.jsp";
        }
        userService.updateUser(user);
        return "redirect:/users";

    }

    //delete a user
    @DeleteMapping("/users/{userId}/delete")
    public String destroyUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
        return "redirect:/users";
    }
}
