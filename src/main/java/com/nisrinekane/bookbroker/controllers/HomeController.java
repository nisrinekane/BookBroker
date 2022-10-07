package com.nisrinekane.bookbroker.controllers;


import com.nisrinekane.bookbroker.models.LoginUser;
import com.nisrinekane.bookbroker.models.User;
import com.nisrinekane.bookbroker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class HomeController {
    // Add once service is implemented:
    @Autowired
    private UserService userService;

//    @GetMapping("/books")
//    public String books(Model model, HttpSession session) {
//        model.addAttribute("user", userService.getUser((Long) session.getAttribute("userId")));
//        return "books.jsp";
//    }

    @GetMapping("/")
    public String index(Model model) {
        // Bind empty User and LoginUser objects to the JSP
        // to capture the form input
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser")
                           User newUser,
                           BindingResult result,
                           Model model,
                           HttpSession session) {
        User user = userService.register(newUser, result);
        if(result.hasErrors()) {
            // Be sure to send in the empty LoginUser before
            // re-rendering the page.
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
        // if no errors, log user in with session
        System.out.println(user.getId());
        session.setAttribute("userId", user.getId());
        return "redirect:/books";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin")
                        LoginUser newLogin,
                        BindingResult result,
                        Model model,
                        HttpSession session) {
        // Add once service is implemented:
        User user = userService.login(newLogin, result);
        if(result.hasErrors() || user==null) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
        // No errors!
        session.setAttribute("userId", user.getId());
        session.setAttribute("user", user);
        return "redirect:/books";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

}