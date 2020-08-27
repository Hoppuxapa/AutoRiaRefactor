package com.kravchuk.web;

import com.kravchuk.domain.User;
import com.kravchuk.repository.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("users")
public class UserController {

    UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @ModelAttribute("user")
    public User user(){return new User();}


 /*   @GetMapping("/users")
    public String getAllUsers(Model model){
        model.addAttribute("users", userServiceImpl.findAllUsers());
        return "user";
    }

    @PostMapping("/users")
    public String addNewUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/add_user")
    public String createUserPage(Model model){
        model.addAttribute("roles", UserRole.values());
        return "add-user";
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Long> deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }*/



}