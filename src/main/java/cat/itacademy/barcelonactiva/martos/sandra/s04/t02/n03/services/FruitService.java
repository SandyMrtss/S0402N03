package cat.itacademy.barcelonactiva.martos.sandra.s04.t02.n03.services;

import cat.itacademy.barcelonactiva.martos.sandra.s04.t02.n03.domain.Fruit;

import java.util.List;

public interface FruitService {
    public boolean addFruit(Fruit fruit);
    public boolean updateFruit(Fruit fruit);
    public boolean deleteFruit(String id);
    public Fruit getOneFruit(String id);
    public List<Fruit> getAllFruit();

}
