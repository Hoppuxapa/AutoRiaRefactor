package com.kravchuk.web;

import com.kravchuk.domain.User;
import com.kravchuk.repository.UserRepository;
import com.kravchuk.repository.UserService;
import com.kravchuk.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("users")
public class UserController {

    UserRepository userRepository;
    UserService userService;

    @Autowired
    public UserController(UserService userService, UserRepository userRepository) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

/*
    @GetMapping("/{id}")
    public String show(@PathVariable long id, Model model){
        model.addAttribute("user",userRepository.findById(id));
        return "userEdit";
    }


    @GetMapping("{user}")
    public String userEdit(@PathVariable User user, Model model) {
        model.addAttribute("user", user);
        return "userEdit";
    }*/

    @RequestMapping("/userList")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "userList";
    }
/*
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