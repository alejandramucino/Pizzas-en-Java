package mx.unam.aragon.tsp.anmh.pizzas.controllers;

import java.util.List;

import mx.unam.aragon.tsp.anmh.pizzas.dtos.IdDto;
import mx.unam.aragon.tsp.anmh.pizzas.models.Pizza;
import mx.unam.aragon.tsp.anmh.pizzas.services.PizzaService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping ("/api/v1/pizzas")
public class PizzaController {

    private final PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping
    public List<Pizza> obtenerPizzas() {
        return pizzaService.obtenerPizzas();
    }

    @GetMapping("/{id}")
    @ResponseStatus (HttpStatus.OK)
    public Pizza obtenerPizzaPorId(@PathVariable String id) {
        return pizzaService.obtenerPizzaPorId(id);
    }

    @PostMapping
    public Pizza guardarPizza(@RequestBody Pizza pizza) {
        return pizzaService.guardarPizza(pizza);
    }

    @PutMapping("/{id}")
    public Pizza actualizarPizza(@PathVariable String id, @RequestBody Pizza pizza){
        return pizzaService.actualizarPizza(id, pizza);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> eliminarPizza(@PathVariable String id) {
        boolean eliminada = pizzaService.eliminarPizza(id);

        if (eliminada) {
            return ResponseEntity.noContent().build();
        }
            return ResponseEntity.notFound().build();

    }

}
