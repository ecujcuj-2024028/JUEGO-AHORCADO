package com.leonelcujcuj.ahorcado.service;

import com.leonelcujcuj.ahorcado.model.User;
import com.leonelcujcuj.ahorcado.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        if (userRepository.findAll().isEmpty()){
            throw new IllegalArgumentException("No hay registros para mostrar");
        }
        return userRepository.findAll();
    }

    @Override
    public User getUserByid(Integer id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("El id debe ser mayor a 0");
        }
        if (userRepository.findById(id).isEmpty()){
            throw new IllegalArgumentException("No se encontro usuario con el id: "+ id);
        }
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User saveUser(User user) {
        if (userRepository.findByCorreo(user.getCorreo()).isPresent()){
            throw new IllegalArgumentException("El correo ya esta registrado");
        }
        if (userRepository.findByNombreUsuario(user.getNombreUsuario()).isPresent()){
            throw new IllegalArgumentException("El nombre ya esta registrado");
        }
        if (user.getFechaRegistro() == null) {
            user.setFechaRegistro(new java.sql.Timestamp(System.currentTimeMillis()));
        }

        return userRepository.save(user);
    }

    @Override
    public User updateUser(Integer id, User user) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("El id debe ser mayor a 0");
        }
        if (userRepository.findByCorreo(user.getCorreo()).isPresent()){
            throw new IllegalArgumentException("El correo ya esta registrado");
        }
        if (userRepository.findByNombreUsuario(user.getNombreUsuario()).isPresent()){
            throw new IllegalArgumentException("El nombre ya esta registrado");
        }
        if (userRepository.findById(id).isEmpty()){
            throw new IllegalArgumentException("No se encontro usuario con el id: "+ id);
        }
        if (user.getFechaRegistro() == null) {
            user.setFechaRegistro(new java.sql.Timestamp(System.currentTimeMillis()));
        }
        User existente = userRepository.findById(id).orElse(null);
            if (existente != null){
                existente.setNombreUsuario(user.getNombreUsuario());
                existente.setCorreo(user.getCorreo());
                existente.setFechaRegistro(user.getFechaRegistro());
                existente.setPassword(user.getPassword());
                return userRepository.save(existente);
            }
        return null;
    }

    @Override
    public void deleteUser(Integer id) {
        if (userRepository.findById(id).isEmpty()) {
            throw new IllegalArgumentException("No se encontro usuario con el id: " + id);
        }
        userRepository.deleteById(id);

    }
}
