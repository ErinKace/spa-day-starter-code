package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {
    @GetMapping("/")
    public String displayUserPage() {
        return "user/index";
    }
    @GetMapping("add")
    public String displayAddUserForm(Model model) {
        model.addAttribute(new User());
        return "user/add";
    }
    @PostMapping("/add")
    public String processAddUserForm(Model model, @ModelAttribute @Valid User user, String verify) {
        model.addAttribute("username",user.getUsername());
        model.addAttribute("email", user.getEmail());
        // add form submission handling code here
        if (verify.equals(user.getPassword())) {

            return "redirect:";
        } else {
            String error = "Passwords do not match";
            model.addAttribute("error", error);
            return "user/add";
        }
    }
}
