package com.kravchuk.service;

import com.kravchuk.domain.User;
import com.kravchuk.domain.UserRole;
import com.kravchuk.repository.UserRepository;
import com.kravchuk.repository.UserService;
import com.kravchuk.service.dto.UserRegistrationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }


    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    public User register(UserRegistrationDTO registration) {
        User user = new User();
        user.setEmail(registration.getEmail());
        user.setPassword(registration.getPassword());
        user.setUsername(registration.getUsername());
        user.setAge(registration.getAge());
        user.setFirstName(registration.getFirstName());
        user.setLastName(registration.getLastName());
        user.setUserRole(UserRole.ROLE_USER);

        return userRepository.save(user);
    }
}

