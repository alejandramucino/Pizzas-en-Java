
package mx.unam.aragon.tsp.anmh.pizzas.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import mx.unam.aragon.tsp.anmh.pizzas.models.Bebida;
import mx.unam.aragon.tsp.anmh.pizzas.services.BebidaService;

@RestController
@RequestMapping("/api/v1/bebidas")
public class BebidaController {

    private final BebidaService bebidaService;

    public BebidaController(BebidaService bebidaService) {
        this.bebidaService = bebidaService;
    }

    @GetMapping
    public List<Bebida> obtenerBebidas() {
        return bebidaService.obtenerBebidas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bebida> obtenerBebidaPorId(@PathVariable String id) {
        Bebida bebida = bebidaService.obtenerBebidaPorId(id);

        if (bebida != null) {
            return ResponseEntity.ok(bebida);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Bebida guardarBebida(@RequestBody Bebida bebida) {
        return bebidaService.guardarBebida(bebida);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bebida> actualizarBebida(
            @PathVariable String id,
            @RequestBody Bebida bebida) {

        Bebida actualizada = bebidaService.actualizarBebida(id, bebida);

        if (actualizada != null) {
            return ResponseEntity.ok(actualizada);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarBebida(@PathVariable String id) {

        boolean eliminada = bebidaService.eliminarBebida(id);

        if (eliminada) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
