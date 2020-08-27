package com.kravchuk.repository;

import com.kravchuk.domain.User;
import com.kravchuk.service.dto.UserRegistrationDTO;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User findByEmail(String email);

    User register(UserRegistrationDTO registration);
}
