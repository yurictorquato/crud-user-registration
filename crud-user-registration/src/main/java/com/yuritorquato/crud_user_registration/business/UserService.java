package com.yuritorquato.crud_user_registration.business;

import com.yuritorquato.crud_user_registration.infrastructure.entitys.User;
import com.yuritorquato.crud_user_registration.infrastructure.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void saveUser(User user) {
        user.setId(null);
        repository.saveAndFlush(user);
    }

    public User findUserByEmail(String email) {
        return repository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Email not found")
        );
    }

    public void deleteUserByEmail(String email) {
        repository.deleteByEmail(email);
    }

    public void updateUserById(Integer id, User user) {
        User userEntity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (user.getEmail() != null) {
            userEntity.setEmail(user.getEmail());
        }

        if (user.getName() != null) {
            userEntity.setName(user.getName());
        }

//        User userUpdate = User.builder()
//                .email(user.getEmail() != null ?
//                        user.getEmail() : userEntity.getEmail())
//                .name(user.getName() != null ?
//                        user.getName() : userEntity.getName())
//                .id(userEntity.getId())
//                .build();

        repository.saveAndFlush(userEntity);
    }
}
