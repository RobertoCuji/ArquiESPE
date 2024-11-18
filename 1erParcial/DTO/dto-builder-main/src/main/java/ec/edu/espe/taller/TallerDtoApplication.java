package ec.edu.espe.taller;

import ec.edu.espe.taller.entidades.Departamento;
import ec.edu.espe.taller.entidades.Empleado;
import ec.edu.espe.taller.repositorios.DepartamentoRepository;
import ec.edu.espe.taller.repositorios.EmpleadoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TallerDtoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TallerDtoApplication.class, args);
    }


    @Bean
    CommandLineRunner initData(DepartamentoRepository departamentoRepository,
                               EmpleadoRepository empleadoRepository) {
        return args -> {
            // Crear Departamentos
            Departamento dpto1 = departamentoRepository.save(Departamento.builder()
                    .nombre("Recursos Humanos")
                    .ubicacion("Edificio A")
                    .build());
            Departamento dpto2 = departamentoRepository.save(Departamento.builder()
                    .nombre("Tecnología")
                    .ubicacion("Edificio B")
                    .build());
            Departamento dpto3 = departamentoRepository.save(Departamento.builder()
                    .nombre("Finanzas")
                    .ubicacion("Edificio C")
                    .build());
            Departamento dpto4 = departamentoRepository.save(Departamento.builder()
                    .nombre("Marketing")
                    .ubicacion("Edificio D")
                    .build());
            Departamento dpto5 = departamentoRepository.save(Departamento.builder()
                    .nombre("Operaciones")
                    .ubicacion("Edificio E")
                    .build());

            // Crear Empleados
            empleadoRepository.save(Empleado.builder()
                    .nombre("Juan")
                    .apellido("Pérez")
                    .correo("juan.perez@example.com")
                    .salario(3000.0)
                    .departamento(dpto1)
                    .build());
            empleadoRepository.save(Empleado.builder()
                    .nombre("María")
                    .apellido("Gómez")
                    .correo("maria.gomez@example.com")
                    .salario(3500.0)
                    .departamento(dpto2)
                    .build());
            empleadoRepository.save(Empleado.builder()
                    .nombre("Carlos")
                    .apellido("Ramírez")
                    .correo("carlos.ramirez@example.com")
                    .salario(4000.0)
                    .departamento(dpto3)
                    .build());
            empleadoRepository.save(
                    Empleado.builder()
                    .nombre("Lucía")
                    .apellido("Fernández")
                    .correo("lucia.fernandez@example.com")
                    .salario(3800.0)
                    .departamento(dpto4)
                    .build()
            );
            empleadoRepository.save(Empleado.builder()
                    .nombre("Ana")
                    .apellido("Martínez")
                    .correo("ana.martinez@example.com")
                    .salario(3200.0)
                    .departamento(dpto5)
                    .build());
        };
    }
}
