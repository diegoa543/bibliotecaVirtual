package com.example.BibliotecaG45.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.BibliotecaG45.models.UserModels;

@Repository
public interface UserRepository extends CrudRepository<UserModels, Long> {
    public abstract ArrayList<UserModels> findByTelefono(String telefono);

    public abstract ArrayList<UserModels> findByCedula(Long cedula);

}
