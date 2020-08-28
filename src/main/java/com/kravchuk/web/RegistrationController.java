package com.kravchuk.web;

import com.kravchuk.domain.User;
import com.kravchuk.repository.UserService;
import com.kravchuk.service.dto.UserRegistrationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityNotFoundException;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public UserRegistrationDTO userRegistrationDto() {
        return new UserRegistrationDTO();
    }


    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserRegistrationDTO userDto,
                                      BindingResult result) throws EntityNotFoundException {
        User existing = userService.findByEmail(userDto.getEmail());
        if (existing != null) {
            result.rejectValue("username", null, "There is already an account registered with that username");
        }
        if (result.hasErrors()) {
            return "registration";
        }
        userService.register(userDto);
        return "redirect:/registration/success";
    }

}

