package com.kravchuk.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "users")
@Data
public class User implements Serializable {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name="user_name")
    private String username;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private Integer age;

    @Column(name = "login")
    private String login;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "register_time")
    private LocalDate registerTime;

    @Column(name = "user_status")
    private String userStatus;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
    private UserRole userRole;
}
