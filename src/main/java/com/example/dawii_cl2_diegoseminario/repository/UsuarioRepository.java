package com.example.dawii_cl2_diegoseminario.repository;

import com.example.dawii_cl2_diegoseminario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends
        JpaRepository<Usuario, Integer> {
    Usuario findByEmail(String email);
    Usuario findByNomusuario(String nomusuario);
}
