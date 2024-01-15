package lk.nibm.ead2.pizzacreed.web.controller;

import lk.nibm.ead2.pizzacreed.web.Service.Impl.UserService;
import lk.nibm.ead2.pizzacreed.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    //display login on the root path
    @GetMapping("/")
    public String showLogin(){
        return "login";
    }

    //request for login form
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model)
    {
        User user = userService.findByUsername(username);
        if(user != null && user.getPassword().equals(password))
        {
            return "home";
        }
        else
        {
            model.addAttribute("error","Invalid username or password");
            return "login";
        }
    }
}
