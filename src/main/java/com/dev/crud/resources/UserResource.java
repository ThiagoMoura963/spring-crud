package com.dev.crud.resources;

import com.dev.crud.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @GetMapping
    public ResponseEntity<User> findAll() {
        User user = new User(1L, "Thiago", "thiago@gmai.com", "13955401252", "123456");
        return ResponseEntity.ok().body(user);
    }
}
