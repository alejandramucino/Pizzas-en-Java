package mx.unam.aragon.tsp.anmh.pizzas.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import mx.unam.aragon.tsp.anmh.pizzas.models.Bebida;

public interface BebidaRepository extends MongoRepository<Bebida, String> {



}