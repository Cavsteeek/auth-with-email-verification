package com.cavsteek.auth_with_email_verification.repository;

import com.cavsteek.auth_with_email_verification.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.OptionalInt;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByEmail (String email);
    Optional<User> findByVerificationCode(String verificationCode);
}
