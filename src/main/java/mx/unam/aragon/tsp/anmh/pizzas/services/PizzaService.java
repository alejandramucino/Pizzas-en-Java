package mx.unam.aragon.tsp.anmh.pizzas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import mx.unam.aragon.tsp.anmh.pizzas.models.Pizza;
import mx.unam.aragon.tsp.anmh.pizzas.repositories.PizzaRepository;

@Service
public class PizzaService {
    private final PizzaRepository pizzaRepository;

    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public Pizza guardarPizza(Pizza pizza) {
        return pizzaRepository.save(pizza);
    }

    public List<Pizza> obtenerPizzas() {
        return pizzaRepository.findAll();
    }

    public Pizza obtenerPizzaPorId(String id) {
        return pizzaRepository.findById(id).orElse(null);

    }

    public Pizza actualizarPizza(String id, Pizza datosActualizados) {

        return pizzaRepository.findById(id)
                .map(pizza -> {
                    pizza.setNombre(datosActualizados.getNombre());
                    pizza.setDescripcion(datosActualizados.getDescripcion());
                    pizza.setPrecio(datosActualizados.getPrecio());
                    return pizzaRepository.save(pizza);
                })
                .orElse(null);
    }

    public boolean eliminarPizza(String id) {

        if (pizzaRepository.existsById(id)) {
            pizzaRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }



}
