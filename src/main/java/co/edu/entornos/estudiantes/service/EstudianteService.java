package co.edu.entornos.estudiantes.service;

import co.edu.entornos.estudiantes.model.Estudiante;
import co.edu.entornos.estudiantes.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EstudianteService implements IEstudianteService {
    @Autowired
    EstudianteRepository estudianteRepository;

    @Override
    public List<Estudiante> findAll() {
        return estudianteRepository.findAll();
    }

    @Override
    public Optional<Estudiante> findById(Integer idEstudiante) {
        return estudianteRepository.findById(idEstudiante);
    }

    @Override
    public Estudiante create(Estudiante estudiante) {
        if (estudiante.getNombre() != null) {
            estudiante.setNombre(estudiante.getNombre().trim().replaceAll("\\s+", " "));
        }

        if (estudiante.getApellido() != null) {
            estudiante.setApellido(estudiante.getApellido().trim().replaceAll("\\s+", " "));
        }

        if (estudiante.getDireccion() != null) {
            estudiante.setDireccion(estudiante.getDireccion().trim().replaceAll("\\s+", " "));
        }

        if (estudiante.getCarrera() != null) {
            estudiante.setCarrera(estudiante.getCarrera().trim().replaceAll("\\s+", " "));
        }

        return estudianteRepository.save(estudiante);
    }

    @Override
    public Estudiante update(Estudiante estudiante) {
        if (estudiante.getNombre() != null) {
            estudiante.setNombre(estudiante.getNombre().trim().replaceAll("\\s+", " "));
        }

        if (estudiante.getApellido() != null) {
            estudiante.setApellido(estudiante.getApellido().trim().replaceAll("\\s+", " "));
        }

        if (estudiante.getEmail() != null) {
            estudiante.setEmail(estudiante.getEmail().trim().replaceAll("\\s+", ""));
        }

        if (estudiante.getDireccion() != null) {
            estudiante.setDireccion(estudiante.getDireccion().trim().replaceAll("\\s+", " "));
        }

        if (estudiante.getCarrera() != null) {
            estudiante.setCarrera(estudiante.getCarrera().trim().replaceAll("\\s+", " "));
        }

        return estudianteRepository.save(estudiante);
    }

    @Override
    public void deleteById(Integer idEstudiante) {
        estudianteRepository.deleteById(idEstudiante);
    }
}
