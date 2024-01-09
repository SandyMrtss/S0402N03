package cat.itacademy.barcelonactiva.martos.sandra.s04.t02.n03.model.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FruitRepository<Fruit, Long> extends MongoRepository<Fruit, Long>{

}
