package com.entornos.lab1.controller;

import com.entornos.lab1.entity.estudiante;
import com.entornos.lab1.service.estudianteService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import java.util.List;


@RestController
@RequestMapping("/api/estudiante")
@RequiredArgsConstructor
public class estudianteController {

    private final estudianteService estudianteService;
    @GetMapping
    public List<estudiante> listarEstudiantes(){
        return estudianteService.listarEstudiantes();
    }

    @GetMapping("/{Cedula}")
    public ResponseEntity<estudiante> buscarEstudianteID(@PathVariable Long Cedula){
        return estudianteService.buscarEstudianteID(Cedula).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> guardarEstudiante(@RequestBody estudiante estudiante){
        estudianteService.guardarEstudiante(estudiante);
        return ResponseEntity.ok().build();
    }
    
    @DeleteMapping("/{Cedula}")
    public ResponseEntity<Void> eliminarEstudiante(@PathVariable Long Cedula){
        estudianteService.eliminarEstudiante(Cedula);
        return ResponseEntity.ok().build();
    }
    
}
