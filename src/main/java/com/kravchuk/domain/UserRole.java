package com.kravchuk.domain;

import org.springframework.security.core.GrantedAuthority;

import java.util.Arrays;
import java.util.Optional;

public enum UserRole implements GrantedAuthority {
    ROLE_ADMIN("ADMINISTRATOR"),
    ROLE_USER("USER");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public static Optional<UserRole> getUserRole(String status) {
        return Arrays.stream(UserRole.values())
                .filter(enumValue -> enumValue.getRole().equals(status))
                .findAny();
    }

    @Override
    public String getAuthority() {
        return name();
    }
}
