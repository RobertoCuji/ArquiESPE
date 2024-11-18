package ec.edu.espe.taller.Mapeadores;

import ec.edu.espe.taller.dto.DepartamentoDTO;
import ec.edu.espe.taller.entidades.Departamento;

public class DepartamentoMapper {

    public static DepartamentoDTO aDTO(Departamento departamento) {
        DepartamentoDTO dto = new DepartamentoDTO();
        dto.setId(departamento.getId());
        dto.setNombre(departamento.getNombre());
        dto.setUbicacion(departamento.getUbicacion());
        return dto;
    }

    public static Departamento aEntidad(DepartamentoDTO dto) {
        return Departamento.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .ubicacion(dto.getUbicacion())
                .build();
    }
}
