package com.example.dawii_cl2_diegoseminario.service;


import com.example.dawii_cl2_diegoseminario.model.Rol;
import com.example.dawii_cl2_diegoseminario.model.Usuario;
import com.example.dawii_cl2_diegoseminario.repository.RolRepository;
import com.example.dawii_cl2_diegoseminario.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
@AllArgsConstructor
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    private RolRepository rolRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder=
            new BCryptPasswordEncoder();

    public Usuario findUserByEmail(String email){
        return usuarioRepository.findByEmail(email);
    }

    public Usuario findUserByUserName(String username){
        return usuarioRepository.findByNomusuario(username);
    }

    public Usuario saveUser(Usuario usuario){
        usuario.setPassword(bCryptPasswordEncoder.encode(
                usuario.getPassword()));
        usuario.setActivo(true);
        Rol usuarioRol = rolRepository.findByNomrol("ADMIN");
        usuario.setRoles(new HashSet<>(Arrays.asList(usuarioRol)));
        return usuarioRepository.save(usuario);
    }
}