package co.edu.entornos.estudiantes.controller;

import co.edu.entornos.estudiantes.model.Estudiante;
import co.edu.entornos.estudiantes.service.EstudianteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/estudiantes")
public class EstudianteController {
    @Autowired
    EstudianteService estudianteService;

    @GetMapping
    @Operation(summary = "Obtiene todos los estudiantes.")
    public List<Estudiante> findAll() {
        return estudianteService.findAll();
    }

    @GetMapping("/{idEstudiante}")
    @Operation(summary = "Obtiene un estudiante por su ID.")
    public ResponseEntity<Estudiante> findById(
            @Parameter(description = "ID del estudiante a buscar.")
            @PathVariable Integer idEstudiante) {
        return ResponseEntity.ok(estudianteService.findById(idEstudiante));
    }

    @PostMapping
    @Operation(summary = "Crea un nuevo estudiante.")
    public ResponseEntity<Estudiante> create(@Valid @RequestBody Estudiante estudiante) {
        return ResponseEntity.status(HttpStatus.CREATED).body(estudianteService.create(estudiante));
    }

    @PutMapping
    @Operation(summary = "Actualiza un estudiante existente.")
    public ResponseEntity<Estudiante> update(@Valid @RequestBody Estudiante estudiante) {
        return ResponseEntity.ok(estudianteService.update(estudiante));
    }

    @DeleteMapping("/{idEstudiante}")
    @Operation(summary = "Elimina un estudiante por su ID.")
    public ResponseEntity<Estudiante> deleteById(
            @Parameter(description = "ID del estudiante a eliminar.")
            @PathVariable Integer idEstudiante) {
        return ResponseEntity.ok(estudianteService.deleteById(idEstudiante));
    }
}
