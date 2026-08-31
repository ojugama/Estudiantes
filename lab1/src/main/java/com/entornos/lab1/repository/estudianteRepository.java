package com.entornos.lab1.repository;

import  com.entornos.lab1.entity.estudiante;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface estudianteRepository extends JpaRepository<estudiante,Long>{
    
    public List<estudiante> findByNombre(String nombre);
}
