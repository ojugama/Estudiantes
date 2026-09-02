package com.entornos.lab1.controller;

import com.entornos.lab1.entity.estudiante;
import com.entornos.lab1.exception.EstudianteNoEncontradoException;
import com.entornos.lab1.service.estudianteService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import java.util.List;


@RestController
@RequestMapping("/api/estudiante")
@Tag(name="Controlador de Estudiantes")
@RequiredArgsConstructor
public class estudianteController {

    private final estudianteService estudianteService;
    
    //-- Listar estudiantes
    @Operation(
        summary = "Obtener lista completa de estudiantes",
        description = "Retorna una lista con todos los estudiantes registrados en el sistema."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Consulta realizada con éxito")
    })
    @GetMapping
    public List<estudiante> listarEstudiantes(){
        return estudianteService.listarEstudiantes();
    }
    //-- buscar est con cedula
    @Operation(
        summary = " Obtener estudiante usando su Cedula",
        description = "Busca y retorna estudiante en el sistema."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Consulta realizada con éxito"),
        @ApiResponse(responseCode = "404" , description = "Solicitud invalidada")
    })
    @GetMapping("/{Cedula}")
    public ResponseEntity<estudiante> buscarEstudianteID(@PathVariable String Cedula){
        estudiante est = estudianteService.buscarEstudianteID(Cedula).orElseThrow(() -> new EstudianteNoEncontradoException("Estudiante no encontrado: " + Cedula));
                return ResponseEntity.ok(est);
    }
    //-- registrar, editar est
    @Operation(
        summary = "Registrar un nuevo estudiante o editar informacion de estudiante existente",
        description = "Crea un registro de estudiante en la base de datos validando los datos requeridos."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Estudiante creado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Solicitud inválida: Ocurre por fallos en las reglas de validación de los datos enviados")
    })
    
    @PostMapping
    public ResponseEntity<Void> guardarEstudiante(@Valid @RequestBody estudiante estudiante){
        estudianteService.guardarEstudiante(estudiante);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    //-- eliminar est
    @Operation(
        summary = "Eliminar estudiante existente del sistema",
        description = "Busca y elimina estudiante del sistema"
    )
    @ApiResponses( value={
        @ApiResponse(responseCode = "200",description = "Estudiante eliminado correctamente"),   
        @ApiResponse(responseCode = "404",description = "Solicitud cancelada: Estudiante no encontrado")
    })
    @DeleteMapping("/{Cedula}")
    public ResponseEntity<Void> eliminarEstudiante(@PathVariable String Cedula){
        estudianteService.eliminarEstudiante(Cedula);
        return ResponseEntity.ok().build();
    }
    
}
