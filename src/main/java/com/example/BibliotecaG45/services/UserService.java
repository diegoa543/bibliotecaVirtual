package com.example.BibliotecaG45.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BibliotecaG45.models.UserModels;
import com.example.BibliotecaG45.repositories.UserRepository;

@Service
public class UserService {

    public UserService() {
    }

    @Autowired
    UserRepository userRepository;

    public ArrayList<UserModels> obtenerusuarios() {
        return (ArrayList<UserModels>) userRepository.findAll();
    }

    public UserModels guardardatos(UserModels usuario) {
        return userRepository.save(usuario);
    }

    public boolean eliminarusuario(long id) {
        try {
            this.userRepository.deleteById(id);
            return true;
        } catch (Exception er) {
            return false;
        }

    }

    public Optional<UserModels> obtenerporId(Long id) {
        return this.userRepository.findById(id);

    }

    public ArrayList<UserModels> obtenerporTelefono(String telefono) {
        return this.userRepository.findByTelefono(telefono);

    }

    public ArrayList<UserModels> obtenerporCedula(long cedula) {
        return this.userRepository.findByCedula(cedula);

    }

}
