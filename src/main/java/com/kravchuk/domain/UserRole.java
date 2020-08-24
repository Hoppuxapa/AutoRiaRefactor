package com.kravchuk.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_role")
@Data
public class UserRole implements Serializable {

    @Id
    @Column
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @Enumerated(EnumType.STRING)
    @Column(name = "user_role")
    private DatabaseUserRole userRole;
}
