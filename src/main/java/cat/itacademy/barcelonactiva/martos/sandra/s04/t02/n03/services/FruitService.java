package cat.itacademy.barcelonactiva.martos.sandra.s04.t02.n03.services;

import cat.itacademy.barcelonactiva.martos.sandra.s04.t02.n03.domain.Fruit;

import java.util.List;

public interface FruitService {
    public void addFruit(Fruit fruit);
    public void updateFruit(Fruit fruit);
    public void deleteFruit(String id);
    public Fruit getOneFruit(String id);
    public List<Fruit> getAllFruit();

}
