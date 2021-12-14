package dev.gokhana.pollj.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

// @TODO: make it record
@Table
public class Poll {
    @Id
    private Long id;

    private String question;

    private Instant expirationDateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Instant getExpirationDateTime() {
        return expirationDateTime;
    }

    public void setExpirationDateTime(Instant expirationDateTime) {
        this.expirationDateTime = expirationDateTime;
    }

}