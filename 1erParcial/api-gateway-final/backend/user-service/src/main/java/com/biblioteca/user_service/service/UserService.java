package com.biblioteca.user_service.service;

import com.biblioteca.user_service.entity.User;
import com.biblioteca.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Registrar un usuario
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Obtener un usuario por ID institucional
    public Optional<User> getUserByIdInstitucional(String idInstitucional) {
        return userRepository.findByIdInstitucional(idInstitucional);
    }

    // Obtener todos los usuarios
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Obtener usuarios por rol
    public List<User> getUsersByRole(Integer role) {
        return userRepository.findByRole(role);
    }

    // Suspender un usuario
    public void suspendUser(Long id) {
        userRepository.findById(id).ifPresent(user -> {
            user.setStatus(false);
            userRepository.save(user);
        });
    }

    // Activar un usuario
    public void activateUser(Long id) {
        userRepository.findById(id).ifPresent(user -> {
            user.setStatus(true);
            userRepository.save(user);
        });
    }
}