package com.lili.feed.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lili.feed.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findOneByEmail(String email);
}
