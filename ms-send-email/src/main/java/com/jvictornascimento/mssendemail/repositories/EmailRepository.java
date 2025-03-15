package com.jvictornascimento.mssendemail.repositories;

import com.jvictornascimento.mssendemail.models.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<EmailModel, Long> {
}
