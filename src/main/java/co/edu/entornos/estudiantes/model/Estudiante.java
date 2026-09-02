package co.edu.entornos.estudiantes.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "estudiantes")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idEstudiante;

    @NotBlank(message = "El número de documento es requerido.")
    @Size(min = 8, max = 11, message = "El número de documento debe tener entre 8 y 11 caracteres.")
    @Pattern(regexp = "^\\d*$", message = "El número de documento solo puede contener dígitos.")
    @Column(name = "numero_documento", nullable = false, length = 11)
    private String numDocumento;

    @NotBlank(message = "El nombre es requerido.")
    @Size(max = 50, message = "El nombre debe tener máximo 50 caracteres.")
    @Pattern(regexp = "^(?!\\s)(?!.*\\s$)[A-Za-zÁÉÍÓÚáéíóúñÑ'\\- ]+$", message = "El nombre solo puede contener letras, espacios intermedios, apóstrofes y guiones.")
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @NotBlank(message = "El apellido es requerido.")
    @Size(max = 50, message = "El apellido debe tener máximo 50 caracteres.")
    @Pattern(regexp = "^(?!\\s)(?!.*\\s$)[A-Za-zÁÉÍÓÚáéíóúñÑ'\\- ]+$", message = "El apellido solo puede contener letras, espacios intermedios, apóstrofes y guiones.")
    @Column(name = "apellido", nullable = false, length = 50)
    private String apellido;

    @NotBlank(message = "El email es requerido.")
    @Size(max = 50, message = "El email debe tener máximo 50 caracteres.")
    @Email(message = "El email debe tener un formato válido.")
    @Column(name = "email", nullable = true, length = 50)
    private String email;

    @Size(max = 100, message = "La dirección debe tener máximo 100 caracteres.")
    @Column(name = "direccion", nullable = true, length = 100)
    private String direccion;

    @NotBlank(message = "La carrera es requerida.")
    @Size(max = 50, message = "La carrera debe tener máximo 50 caracteres.")
    @Pattern(regexp = "^(?!\\s)(?!.*\\s$)[A-Za-zÁÉÍÓÚáéíóúñÑ ]+$", message = "La carrera solo puede contener letras y espacios intermedios.")
    @Column(name = "carrera", nullable = false, length = 50)
    private String carrera;

    @NotNull(message = "El promedio no puede ser nulo.")
    @PositiveOrZero(message = "El promedio debe ser un número positivo o cero.")
    @Max(value = 5, message = "El promedio no puede ser mayor a 5.")
    @Digits(integer = 1, fraction = 2, message = "El promedio solo puede tener hasta 2 decimales.")
    @Column(name = "promedio", nullable = false, length = 4)
    private Double promedio;

    public Estudiante() {
    }

    public Integer getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public Double getPromedio() {
        return promedio;
    }

    public void setPromedio(Double promedio) {
        this.promedio = promedio;
    }
}
