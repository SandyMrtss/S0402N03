package cat.itacademy.barcelonactiva.martos.sandra.s04.t02.n03.model.services;

import cat.itacademy.barcelonactiva.martos.sandra.s04.t02.n03.model.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

public interface FruitService {
    public boolean addFruit(Fruit fruit);
    public boolean updateFruit(Fruit fruit);
    public boolean deleteFruit(long id);
    public Fruit getOneFruit(long id);
    public List<Fruit> getAllFruit();

}
