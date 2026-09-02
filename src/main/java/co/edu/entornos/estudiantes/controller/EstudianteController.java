package co.edu.entornos.estudiantes.controller;

import co.edu.entornos.estudiantes.model.Estudiante;
import co.edu.entornos.estudiantes.service.EstudianteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/estudiantes")
@Tag(
        name = "Estudiantes",
        description = "Controlador para gestionar estudiantes."
)
public class EstudianteController {
    @Autowired
    EstudianteService estudianteService;

    @GetMapping
    @Operation(
            summary = "Obtener todos los estudiantes.",
            description = "Devuelve una lista de todos los estudiantes registrados en el sistema."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Estudiantes encontrados exitosamente.",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Estudiante.class)
                            )
                    )
            ),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor.")
    })
    public List<Estudiante> findAll() {
        return estudianteService.findAll();
    }

    @GetMapping("/{idEstudiante}")
    @Operation(
            summary = "Obtener un estudiante por su ID.",
            description = "Devuelve un estudiante específico según su ID."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Estudiante encontrado exitosamente.",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Estudiante.class
                            )
                    )
            ),
            @ApiResponse(responseCode = "404", description = "Estudiante no encontrado."),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor.")
    })
    public ResponseEntity<Estudiante> findById(
            @Parameter(description = "ID del estudiante a buscar.")
            @PathVariable Integer idEstudiante) {
        return ResponseEntity.ok(estudianteService.findById(idEstudiante));
    }

    @PostMapping
    @Operation(
            summary = "Crear un nuevo estudiante.",
            description = "Registra un estudiante validando todos los campos enviados."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Estudiante creado exitosamente.",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Estudiante.class
                            )
                    )
            ),
            @ApiResponse(responseCode = "400", description = "Error(es) de validación."),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor.")
    })
    public ResponseEntity<Estudiante> create(@Valid @RequestBody Estudiante estudiante) {
        return ResponseEntity.status(HttpStatus.CREATED).body(estudianteService.create(estudiante));
    }

    @PutMapping
    @Operation(
            summary = "Editar un estudiante existente.",
            description = "Actualiza un estudiante validando todos los campos enviados."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Estudiante encontrado exitosamente.",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Estudiante.class
                            )
                    )
            ),
            @ApiResponse(responseCode = "400", description = "Error(es) de validación."),
            @ApiResponse(responseCode = "404", description = "Estudiante no encontrado."),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor.")
    })
    public ResponseEntity<Estudiante> update(@Valid @RequestBody Estudiante estudiante) {
        return ResponseEntity.ok(estudianteService.update(estudiante));
    }

    @DeleteMapping("/{idEstudiante}")
    @Operation(
            summary = "Eliminar un estudiante por su ID.",
            description = "Elimina un estudiante específico según su ID."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Estudiante encontrado exitosamente.",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Estudiante.class
                            )
                    )
            ),
            @ApiResponse(responseCode = "404", description = "Estudiante no encontrado."),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor.")
    })
    public ResponseEntity<Estudiante> deleteById(
            @Parameter(description = "ID del estudiante a eliminar.")
            @PathVariable Integer idEstudiante) {
        return ResponseEntity.ok(estudianteService.deleteById(idEstudiante));
    }
}
