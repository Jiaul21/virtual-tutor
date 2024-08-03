package com.jiaul.virtualtutor.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserCredentialRepository extends JpaRepository<UserCredential, Integer> {
    Optional<UserCredential> findByEmail(String email);
    @Modifying
    @Transactional
    @Query("UPDATE UserCredential u SET u.enabled = :enabled WHERE u.email = :email")
    int updateEnabledByEmail(@Param("enabled") boolean enabled, @Param("email") String email);
}
