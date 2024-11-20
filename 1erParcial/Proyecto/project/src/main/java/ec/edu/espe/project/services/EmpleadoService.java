package ec.edu.espe.taller.services;

import ec.edu.espe.taller.Mapeadores.EmpleadoMapper;
import ec.edu.espe.taller.dto.EmpleadoDTO;
import ec.edu.espe.taller.entities.Empleado;
import ec.edu.espe.taller.repositories.EmpleadoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<EmpleadoDTO> obtenerTodosLosEmpleados() {
        return empleadoRepository.findAll().stream()
                .map(EmpleadoMapper::aDTO)
                .collect(Collectors.toList());
    }

    public EmpleadoDTO obtenerEmpleadoPorId(Long id) {
        Empleado empleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado con ID: " + id));
        return EmpleadoMapper.aDTO(empleado);
    }

    public EmpleadoDTO crearEmpleado(EmpleadoDTO dto) {
        Empleado empleado = empleadoRepository.save(EmpleadoMapper.aEntidad(dto));
        return EmpleadoMapper.aDTO(empleado);
    }

    public EmpleadoDTO actualizarEmpleado(Long id, EmpleadoDTO dto) {
        Empleado empleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado con ID: " + id));
        empleado.setNombre(dto.getNombre());
        empleado.setApellido(dto.getApellido());
        empleado.setCorreo(dto.getCorreo());
        empleado.setSalario(dto.getSalario());
        empleado.setDepartamento(EmpleadoMapper.aEntidad(dto).getDepartamento());
        return EmpleadoMapper.aDTO(empleadoRepository.save(empleado));
    }

    public void eliminarEmpleado(Long id) {
        empleadoRepository.deleteById(id);
    }
}
