package com.entornos.lab1.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Estudiantes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class estudiante {

    @Id
    @NotBlank(message = "La cédula no puede estar vacía")
    @Size(min = 8, max = 11, message = "La cédula debe tener entre 8 y 11 caracteres")
    @Pattern(regexp = "^[0-9]+$", message = "La cédula debe contener solo números")
    private String cedula;

    @Column(nullable = false)
    @NotBlank(message = "El nombre es obligatorio")
    @Pattern(regexp = "^\\S.*\\S$", message = "No debe tener espacios al inicio ni al final")
    private String nombre;

    @Column(nullable = false)
    @NotBlank(message = "Los apellidos son obligatorios")
    @Pattern(regexp = "^\\S.*\\S$", message = "No debe tener espacios al inicio ni al final")
    private String apellidos;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "Debe proporcionar un formato de correo válido")
    private String correoElectronico;

    private String direccion; // Campo opcional

    @Column(nullable = false)
    @NotBlank(message = "La carrera es obligatoria")
    private String carrera;

    @Column(nullable = false)
    @NotNull(message = "La nota promedio es obligatoria")
    @Min(value = 0, message = "La nota promedio debe ser como mínimo 0.0")
    @Max(value = 5, message = "La nota promedio debe ser como máximo 5.0")
    private Double notaPromedio;
}