
package mx.unam.aragon.tsp.anmh.pizzas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import mx.unam.aragon.tsp.anmh.pizzas.models.Cliente;
import mx.unam.aragon.tsp.anmh.pizzas.repositories.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> obtenerClientes() {
        return clienteRepository.findAll();
    }

    public Cliente obtenerClientePorId(String id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public Cliente actualizarCliente(String id, Cliente datosActualizados) {
        return clienteRepository.findById(id)
            .map(cliente -> {
                cliente.setNombre(datosActualizados.getNombre());
                cliente.setApellido(datosActualizados.getApellido());
                cliente.setTelefono(datosActualizados.getTelefono());
                cliente.setCorreo(datosActualizados.getCorreo());
                cliente.setDireccion(datosActualizados.getDireccion());

                return clienteRepository.save(cliente);
            })
            .orElse(null);
    }

    public boolean eliminarCliente(String id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        }

        return false;
    }
}
