package cat.itacademy.barcelonactiva.martos.sandra.s04.t02.n03.repository;

import cat.itacademy.barcelonactiva.martos.sandra.s04.t02.n03.domain.Fruit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FruitRepository extends MongoRepository<Fruit, Long>{
}
