package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

//public class HelloMessageService implements MessageService {

@SpringBootTest
public class HelloMessageService {

    @PreAuthorize("authenticated")
    public String getMessage() {
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();

        return "Hello " + authentication;
    }

    @Test
    void testGetMessage() {
        System.out.println(getMessage());
    }
}