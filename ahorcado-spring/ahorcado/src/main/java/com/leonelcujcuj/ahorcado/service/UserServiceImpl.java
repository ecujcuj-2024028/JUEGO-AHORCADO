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
        return userRepository.findAll();
    }

    @Override
    public User getUserByid(Integer id) {
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

        return userRepository.save(user);
    }

    @Override
    public User updateUser(Integer id, User user) {
        if (userRepository.findByCorreo(user.getCorreo()).isPresent()){
            throw new IllegalArgumentException("El correo ya esta registrado");
        }
        if (userRepository.findByNombreUsuario(user.getNombreUsuario()).isPresent()){
            throw new IllegalArgumentException("El nombre ya esta registrado");
        }
        if (userRepository.findById(id).isEmpty()){
            throw new IllegalArgumentException("El usuario no existe");
        }
        User existente = userRepository.findById(id).orElse(null);
            if (existente != null){
                existente.setNombreUsuario(user.getNombreUsuario());
                existente.setCorreo(user.getCorreo());
                existente.setFechaRegistro(user.getFechaRegistro());
                existente.setPassword(user.getPassword());
            }
        return null ;
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
        if (userRepository.findById(id).isEmpty())
            throw new IllegalArgumentException("El usuario no existe");
    }
}
