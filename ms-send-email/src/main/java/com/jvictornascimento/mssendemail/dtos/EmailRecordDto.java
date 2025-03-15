package com.jvictornascimento.mssendemail.dtos;

public record EmailRecordDto(
        Long userId,
        String emailTo,
        String subject,
        String text) {
}