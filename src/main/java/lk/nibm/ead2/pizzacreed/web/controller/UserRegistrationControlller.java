package lk.nibm.ead2.pizzacreed.web.controller;


import lk.nibm.ead2.pizzacreed.web.Service.IUserService;
import lk.nibm.ead2.pizzacreed.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserRegistrationControlller {
    @Autowired
    IUserService service;

    // Shows Registration view.
    @GetMapping("/Registration")
    public String ShowRegistration(){return "Registration";}

    // Save user, redirects to log in with user information
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute User user){
        service.save(user);

        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("login");
        modelAndView.addObject("user",user);
        return modelAndView;
    }
}
