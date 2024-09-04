package com.bookmanager.bookmanager.Entity;

import org.springframework.http.HttpStatus;

import lombok.*;

@Builder
@Getter
@Setter
public class APIResponse {
    private String message;
    private HttpStatus status;
}
