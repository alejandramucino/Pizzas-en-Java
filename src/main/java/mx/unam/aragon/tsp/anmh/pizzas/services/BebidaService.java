
package mx.unam.aragon.tsp.anmh.pizzas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import mx.unam.aragon.tsp.anmh.pizzas.models.Bebida;
import mx.unam.aragon.tsp.anmh.pizzas.repositories.BebidaRepository;

@Service
public class BebidaService {

    private final BebidaRepository bebidaRepository;

    public BebidaService(BebidaRepository bebidaRepository) {
        this.bebidaRepository = bebidaRepository;
    }

    public Bebida guardarBebida(Bebida bebida) {
        return bebidaRepository.save(bebida);
    }

    public List<Bebida> obtenerBebidas() {
        return bebidaRepository.findAll();
    }

    public Bebida obtenerBebidaPorId(String id) {
        return bebidaRepository.findById(id).orElse(null);
    }

    public Bebida actualizarBebida(String id, Bebida datosActualizados) {
        return bebidaRepository.findById(id)
            .map(bebida -> {
                bebida.setNombre(datosActualizados.getNombre());
                bebida.setPresentacion(datosActualizados.getPresentacion());
                bebida.setContenidoMl(datosActualizados.getContenidoMl());
                bebida.setPrecio(datosActualizados.getPrecio());

                return bebidaRepository.save(bebida);
            })
            .orElse(null);
    }

    public boolean eliminarBebida(String id) {
        if (bebidaRepository.existsById(id)) {
            bebidaRepository.deleteById(id);
            return true;
        }

        return false;
    }
}
