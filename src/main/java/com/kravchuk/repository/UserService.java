package com.kravchuk.repository;

import com.kravchuk.domain.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
