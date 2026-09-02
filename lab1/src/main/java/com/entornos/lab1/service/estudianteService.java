package com.entornos.lab1.service;

import com.entornos.lab1.entity.estudiante;
import com.entornos.lab1.repository.estudianteRepository;

import org.springframework.transaction.annotation.TransactionAnnotationParser;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor  //genera constructor de lombok,incluye atributos final y no nulos
public class estudianteService {

    private final estudianteRepository estudianteRepository;

    public List<estudiante> listarEstudiantes(){
        return estudianteRepository.findAll();
    }

    public Optional<estudiante> buscarEstudianteID(String Cedula){
        return estudianteRepository.findById(Cedula);
    }

    public void guardarEstudiante(estudiante estudiante){
        estudianteRepository.save(estudiante);
    }

    public void eliminarEstudiante(String Cedula){
        estudianteRepository.deleteById(Cedula);
    }

}
