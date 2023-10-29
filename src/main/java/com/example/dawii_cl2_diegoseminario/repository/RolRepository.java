package com.example.dawii_cl2_diegoseminario.repository;

import com.example.dawii_cl2_diegoseminario.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {

    Rol findByNomrol(String nombrerol);
}
