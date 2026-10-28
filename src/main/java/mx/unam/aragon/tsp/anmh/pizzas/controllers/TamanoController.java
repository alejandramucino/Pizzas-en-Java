
package mx.unam.aragon.tsp.anmh.pizzas.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import mx.unam.aragon.tsp.anmh.pizzas.models.Tamano;
import mx.unam.aragon.tsp.anmh.pizzas.services.TamanoService;

@RestController
@RequestMapping("/api/v1/tamanos")
public class TamanoController {

    private final TamanoService tamanoService;

    public TamanoController(TamanoService tamanoService) {
        this.tamanoService = tamanoService;
    }

    @GetMapping
    public List<Tamano> obtenerTamanos() {
        return tamanoService.obtenerTamanos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tamano> obtenerTamanoPorId(@PathVariable String id) {
        Tamano tamano = tamanoService.obtenerTamanoPorId(id);

        if (tamano != null) {
            return ResponseEntity.ok(tamano);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Tamano guardarTamano(@RequestBody Tamano tamano) {
        return tamanoService.guardarTamano(tamano);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tamano> actualizarTamano(
            @PathVariable String id,
            @RequestBody Tamano tamano) {

        Tamano actualizado = tamanoService.actualizarTamano(id, tamano);

        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTamano(@PathVariable String id) {

        boolean eliminado = tamanoService.eliminarTamano(id);

        if (eliminado) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
