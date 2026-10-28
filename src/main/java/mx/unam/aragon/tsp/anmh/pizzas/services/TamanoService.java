
package mx.unam.aragon.tsp.anmh.pizzas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import mx.unam.aragon.tsp.anmh.pizzas.models.Tamano;
import mx.unam.aragon.tsp.anmh.pizzas.repositories.TamanoRepository;

@Service
public class TamanoService {

    private final TamanoRepository tamanoRepository;

    public TamanoService(TamanoRepository tamanoRepository) {
        this.tamanoRepository = tamanoRepository;
    }

    public Tamano guardarTamano(Tamano tamano) {
        return tamanoRepository.save(tamano);
    }

    public List<Tamano> obtenerTamanos() {
        return tamanoRepository.findAll();
    }

    public Tamano obtenerTamanoPorId(String id) {
        return tamanoRepository.findById(id).orElse(null);
    }

    public Tamano actualizarTamano(String id, Tamano datosActualizados) {
        return tamanoRepository.findById(id)
            .map(tamano -> {
                tamano.setNombre(datosActualizados.getNombre());
                tamano.setDiametro(datosActualizados.getDiametro());
                tamano.setPrecioExtra(datosActualizados.getPrecioExtra());

                return tamanoRepository.save(tamano);
            })
            .orElse(null);
    }

    public boolean eliminarTamano(String id) {
        if (tamanoRepository.existsById(id)) {
            tamanoRepository.deleteById(id);
            return true;
        }

        return false;
    }
}
