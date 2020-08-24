package com.kravchuk.web;

import com.kravchuk.domain.User;
import com.kravchuk.domain.UserRole;
import com.kravchuk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public User user(){return new User();}

    @GetMapping("/users")
    public String getAllUsers(Model model){
        model.addAttribute("users", userService.findAllUsers());
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
    }

    @PostMapping("/change_user_role_admin/{id}")
    public ResponseEntity<Long> changeUserRoleToAdmin(@PathVariable("id") Long id){
        userService.changeUserRoleToAdministrator(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PostMapping("/change_user_role_user/{id}")
    public ResponseEntity<Long> changeUserRoleToUser(@PathVariable("id") Long id){
        userService.changeUserRoleToUser(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}