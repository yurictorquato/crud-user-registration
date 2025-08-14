package com.yuritorquato.crud_user_registration.controller;


import com.yuritorquato.crud_user_registration.business.UserService;
import com.yuritorquato.crud_user_registration.infrastructure.entitys.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<Void> saveUser(@RequestBody User user) {
        userService.saveUser(user);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<User> findUserByEmail(@RequestParam String email) {
        return ResponseEntity.ok(userService.findUserByEmail(email));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUserByEmail(@RequestParam String email) {
        userService.deleteUserByEmail(email);

        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> UpdateUserById(@RequestParam Integer id,
                                               @RequestBody User user) {
        userService.updateUserById(id, user);

        return ResponseEntity.ok().build();
    }
}
