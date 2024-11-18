package ec.edu.espe.taller.Controladores;

import ec.edu.espe.taller.Servicios.DepartamentoService;
import ec.edu.espe.taller.dto.DepartamentoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamento/")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping
    public List<DepartamentoDTO> obtenerTodosLosDepartamentos() {
        return departamentoService.obtenerTodosLosDepartamentos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartamentoDTO> obtenerDepartamentoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(departamentoService.obtenerDepartamentoPorId(id));
    }

    @PostMapping
    public ResponseEntity<DepartamentoDTO> crearDepartamento(@RequestBody DepartamentoDTO dto) {
        return ResponseEntity.ok(departamentoService.crearDepartamento(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartamentoDTO> actualizarDepartamento(@PathVariable Long id, @RequestBody DepartamentoDTO dto) {
        return ResponseEntity.ok(departamentoService.actualizarDepartamento(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDepartamento(@PathVariable Long id) {
        departamentoService.eliminarDepartamento(id);
        return ResponseEntity.noContent().build();
    }
}
