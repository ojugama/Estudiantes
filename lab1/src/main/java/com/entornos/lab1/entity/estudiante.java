package com.entornos.lab1.entity;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.*; // mapear tabla (tabla,id)  
import jakarta.validation.constraints.*; // reglas de validacion caracteristicas (columnas)

//lombok automatizar generacion de codigo
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
@Entity
@Table(name="Estudiantes")
public class estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotBlank
    @Size(min=8,max=11,message="entre 8 a 11 caracteres")
    public Long Cedula;

    @Column(nullable= false)
    @NotBlank  /// no vacio 
    @Pattern(regexp = "^\\S.*\\S$") /// impide estructura(no vacio al inicio ni final en la expresion puntual)
    public String Nombre;
    @Column(nullable= false)
    @NotBlank  /// no vacio 
    @Pattern(regexp = "^\\S.*\\S$") 
    public String Apellidos;
    @Email
    public String Correo_electronico;
    @Column(nullable= false)
    @NotBlank  /// no vacio 
    @Pattern(regexp = "^\\S.*\\S$") 
    public String Carrera;
    @NotNull
    @Min(value = 0, message="nota >= 0")
    @Max(value = 5 ,message="nota <=5")
    public Double NotaPromedio;
    
    public Long getCedula() {
        return Cedula;
    }
    public void setCedula(Long cedula) {
        Cedula = cedula;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public String getApellidos() {
        return Apellidos;
    }
    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }
    public String getCorreo_electronico() {
        return Correo_electronico;
    }
    public void setCorreo_electronico(String correo_electronico) {
        Correo_electronico = correo_electronico;
    }
    public String getCarrera() {
        return Carrera;
    }
    public void setCarrera(String carrera) {
        Carrera = carrera;
    }
    public Double getNotaPromedio() {
        return NotaPromedio;
    }
    public void setNotaPromedio(Double notaPromedio) {
        NotaPromedio = notaPromedio;
    }

    


}
