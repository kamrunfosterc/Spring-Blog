package com.codeup.springblog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repos.UserRepository;

@Controller
public class UserController {

    @Autowired
    private final UserRepository userDao;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserRepository userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

//    @GetMapping("/user/create")
//    public String createUserForm(){
//        return "user/create";// ref file in directory bc in template
//    }
    @GetMapping("/sign-up")
    public String showSignupForm(Model model){
        model.addAttribute("user", new User());
        return "user/sign-up";
}

    @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute User user){
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userDao.save(user);
        return "redirect:/login";
    }

    @GetMapping("/user/{username}/ads")
    public String showUserAds(
            @PathVariable String username,
            Model model
    ){
        User userToDisplay = userDao.getByUsername(username);
        model.addAttribute("user", userToDisplay);


        return "user/displayAds";
    }

    @PostMapping("/user/create")
    @ResponseBody
    public String createUser(
            @RequestParam(name = "uname") String username,
            @RequestParam(name = "psw") String password
    ){
        System.out.println("Username:" + username);
        System.out.println("Password:" + password);
        return "User Created";
    }
    //Anything having to do with users will go in here


}
