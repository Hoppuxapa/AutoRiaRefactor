package com.kravchuk.repository;

import com.kravchuk.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    @Modifying
    @Transactional
    @Query(value = "update users\n" +
            "set user_role = 'ADMINISTRATOR'\n" +
            "where id = :id",
            nativeQuery = true
    )
    public void changeUserRoleToAdministrator(Long id);

    @Modifying
    @Transactional
    @Query(value = "update users\n" +
            "set user_role = 'USER'\n" +
            "where id = :id",
            nativeQuery = true
    )
    public void changeUserRoleToUser(Long id);
}
