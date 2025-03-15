package com.jvictornascimento.msuser.repositories;

import com.jvictornascimento.msuser.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    UserModel findByEmail(String email);
    boolean existsByEmail(String email);
}
