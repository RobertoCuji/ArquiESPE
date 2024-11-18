package ec.edu.espe.taller.Mapeadores;

import ec.edu.espe.taller.dto.EmpleadoDTO;
import ec.edu.espe.taller.entidades.Empleado;

public class EmpleadoMapper {

    public static EmpleadoDTO aDTO(Empleado empleado) {
        EmpleadoDTO dto = new EmpleadoDTO();
        dto.setId(empleado.getId());
        dto.setNombre(empleado.getNombre());
        dto.setApellido(empleado.getApellido());
        dto.setCorreo(empleado.getCorreo());
        dto.setSalario(empleado.getSalario());
        dto.setDepartamento(DepartamentoMapper.aDTO(empleado.getDepartamento()));
        return dto;
    }

    public static Empleado aEntidad(EmpleadoDTO dto) {
        return Empleado.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .apellido(dto.getApellido())
                .correo(dto.getCorreo())
                .salario(dto.getSalario())
                .departamento(DepartamentoMapper.aEntidad(dto.getDepartamento()))
                .build();
    }
}
