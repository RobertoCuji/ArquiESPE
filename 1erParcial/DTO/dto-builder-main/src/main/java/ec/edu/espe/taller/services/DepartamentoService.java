package ec.edu.espe.taller.services;

import ec.edu.espe.taller.Mapeadores.DepartamentoMapper;
import ec.edu.espe.taller.dto.DepartamentoDTO;
import ec.edu.espe.taller.entities.Departamento;
import ec.edu.espe.taller.repositories.DepartamentoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public List<DepartamentoDTO> obtenerTodosLosDepartamentos() {
        return departamentoRepository.findAll().stream()
                .map(DepartamentoMapper::aDTO)
                .collect(Collectors.toList());
    }

    public DepartamentoDTO obtenerDepartamentoPorId(Long id) {
        Departamento departamento = departamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Departamento no encontrado con ID: " + id));
        return DepartamentoMapper.aDTO(departamento);
    }

    public DepartamentoDTO crearDepartamento(DepartamentoDTO dto) {
        Departamento departamento = departamentoRepository.save(DepartamentoMapper.aEntidad(dto));
        return DepartamentoMapper.aDTO(departamento);
    }

    public DepartamentoDTO actualizarDepartamento(Long id, DepartamentoDTO dto) {
        Departamento departamento = departamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Departamento no encontrado con ID: " + id));
        departamento.setNombre(dto.getNombre());
        departamento.setUbicacion(dto.getUbicacion());
        return DepartamentoMapper.aDTO(departamentoRepository.save(departamento));
    }

    public void eliminarDepartamento(Long id) {
        departamentoRepository.deleteById(id);
    }
}
