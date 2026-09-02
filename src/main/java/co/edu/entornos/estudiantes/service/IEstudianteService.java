package co.edu.entornos.estudiantes.service;

import co.edu.entornos.estudiantes.model.Estudiante;

import java.util.List;
import java.util.Optional;

public interface IEstudianteService {
    List<Estudiante> findAll();

    Estudiante findById(Integer idEstudiante);

    Estudiante create(Estudiante estudiante);

    Estudiante update(Estudiante estudiante);

    Estudiante deleteById(Integer idEstudiante);
}
