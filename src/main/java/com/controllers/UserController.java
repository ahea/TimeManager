package com.controllers;

import com.validation.EmailExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.services.UserService;
import com.models.User;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;

/**
 * Created by aleksei on 22.01.17.
 */
@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(User user){
            return "home";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String checkForm(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "home";
        }
        return "redirect:/dashboard";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup(Model model){
        model.addAttribute("user", new User());
        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String saveUser(@Valid User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "redirect:/signup?fieldError";
        }
        try {
            userService.saveUser(user);
        }catch (EmailExistsException e){
            return "redirect:/signup?emailError";
        }
        return "redirect:/?signedup";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(){
        return "redirect:/?error";
    }

}
