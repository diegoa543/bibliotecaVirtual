package com.example.BibliotecaG45.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BibliotecaG45.models.UserModels;
import com.example.BibliotecaG45.services.UserService;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    public UserController() {

    }

    @Autowired
    UserService userService;

    @GetMapping
    public ArrayList<UserModels> obtenerusuarios() {
        return userService.obtenerusuarios();
    }

    @PostMapping
    public UserModels guardardatos(@RequestBody UserModels usuario) {
        return this.userService.guardardatos(usuario);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminardatoid(@PathVariable("id") Long id) {
        boolean ok = this.userService.eliminarusuario(id);
        if (ok) {
            return "Se elimino con exito";
        } else {
            return "No se elimino por fallas o no se encontro el registro";
        }
    }

}
