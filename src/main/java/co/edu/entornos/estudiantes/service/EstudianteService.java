package co.edu.entornos.estudiantes.service;

import co.edu.entornos.estudiantes.exception.ResourceNotFoundException;
import co.edu.entornos.estudiantes.model.Estudiante;
import co.edu.entornos.estudiantes.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public Estudiante findById(Integer idEstudiante) {
        return estudianteRepository.findById(idEstudiante)
                .orElseThrow(() -> new ResourceNotFoundException("Estudiante con ID: " + idEstudiante + " no encontrado."));
    }

    @Override
    public Estudiante create(Estudiante estudiante) {
        estudiante.setNombre(estudiante.getNombre().trim().replaceAll("\\s+", " "));

        estudiante.setApellido(estudiante.getApellido().trim().replaceAll("\\s+", " "));

        if (estudiante.getDireccion() != null) {
            estudiante.setDireccion(estudiante.getDireccion().trim().replaceAll("\\s+", " "));
        }

        estudiante.setCarrera(estudiante.getCarrera().trim().replaceAll("\\s+", " "));

        return estudianteRepository.save(estudiante);
    }

    @Override
    public Estudiante update(Estudiante estudiante) {
        Estudiante existingEstudiante = estudianteRepository.findById(estudiante.getIdEstudiante())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Estudiante con ID: " + estudiante.getIdEstudiante() + " no encontrado."));

        existingEstudiante.setNumDocumento(estudiante.getNumDocumento());

        existingEstudiante.setNombre(estudiante.getNombre().trim().replaceAll("\\s+", " "));

        existingEstudiante.setApellido(estudiante.getApellido().trim().replaceAll("\\s+", " "));

        existingEstudiante.setEmail(estudiante.getEmail());

        if (estudiante.getDireccion() != null) {
            existingEstudiante.setDireccion(estudiante.getDireccion().trim().replaceAll("\\s+", " "));
        }

        existingEstudiante.setCarrera(estudiante.getCarrera().trim().replaceAll("\\s+", " "));

        existingEstudiante.setPromedio(estudiante.getPromedio());

        return estudianteRepository.save(existingEstudiante);
    }

    @Override
    public Estudiante deleteById(Integer idEstudiante) {
        Estudiante existingEstudiante = estudianteRepository.findById(idEstudiante)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Estudiante con ID: " + idEstudiante + " no encontrado."));

        estudianteRepository.deleteById(idEstudiante);

        return existingEstudiante;
    }
}
