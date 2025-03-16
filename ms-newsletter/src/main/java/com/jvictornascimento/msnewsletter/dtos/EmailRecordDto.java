package com.jvictornascimento.msnewsletter.dtos;

import java.util.Objects;

public class EmailRecordDto{
        private Long userId;
        private String emailTo;
        private String subject;
        private String text;
    public EmailRecordDto(){

    }

    public EmailRecordDto(Long userId, String emailTo, String subject, String text) {
        this.userId = userId;
        this.emailTo = emailTo;
        this.subject = subject;
        this.text = text;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmailTo() {
        return emailTo;
    }

    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailRecordDto that = (EmailRecordDto) o;
        return Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

    public void setText(String text) {
        this.text = text;
    }


    @Override
    public String toString() {
        return "EmailRecordDto{" +
                "userId=" + userId +
                ", emailTo='" + emailTo + '\'' +
                ", subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}