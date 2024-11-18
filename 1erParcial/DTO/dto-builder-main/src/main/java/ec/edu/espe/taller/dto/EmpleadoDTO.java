package ec.edu.espe.taller.dto;

import lombok.Data;

@Data
public class EmpleadoDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String correo;
    private Double salario;
    private DepartamentoDTO departamento;
}
