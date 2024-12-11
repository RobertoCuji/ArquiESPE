package com.biblioteca.user_service.controller;

import com.biblioteca.user_service.dto.LoginRequest;
import com.biblioteca.user_service.entity.User;
import com.biblioteca.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Obtener todos los usuarios
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Obtener usuario por ID institucional
    @GetMapping("/{idInstitucional}")
    public ResponseEntity<User> getUserByIdInstitucional(@PathVariable String idInstitucional) {
        return userService.getUserByIdInstitucional(idInstitucional)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        boolean isAuthenticated = userService.authenticateUser(loginRequest.getUsername(), loginRequest.getPassword());
        if (isAuthenticated) {
            return ResponseEntity.ok("Usuario autenticado con éxito");
        } else {
            return ResponseEntity.status(401).body("Credenciales incorrectas");
        }
    }

    // Crear un nuevo usuario
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @PutMapping("/{idInstitucional}/suspend")
    public ResponseEntity<Void> suspendUser(@PathVariable String idInstitucional) {
        userService.suspendUserByIdInstitucional(idInstitucional);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{idInstitucional}")
    public ResponseEntity<User> updateUser(@PathVariable String idInstitucional, @RequestBody User updatedUser) {
        User user = userService.updateUserByIdInstitucional(idInstitucional, updatedUser);
        return ResponseEntity.ok(user);
    }
    
    
    @PutMapping("/{idInstitucional}/activate")
    public ResponseEntity<Void> activateUser(@PathVariable String idInstitucional) {
        userService.activateUserByIdInstitucional(idInstitucional);
        return ResponseEntity.ok().build();
    }
    
}

