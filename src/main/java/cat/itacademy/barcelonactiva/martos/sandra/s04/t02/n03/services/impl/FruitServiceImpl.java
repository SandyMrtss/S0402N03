package cat.itacademy.barcelonactiva.martos.sandra.s04.t02.n03.services.impl;

import cat.itacademy.barcelonactiva.martos.sandra.s04.t02.n03.domain.Fruit;
import cat.itacademy.barcelonactiva.martos.sandra.s04.t02.n03.repository.FruitRepository;
import cat.itacademy.barcelonactiva.martos.sandra.s04.t02.n03.services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FruitServiceImpl implements FruitService {
    @Autowired
    private FruitRepository fruitRepository;

    @Override
    public boolean addFruit(Fruit fruit) {
        fruitRepository.save(fruit);
        return true;
    }

    @Override
    public boolean updateFruit(Fruit fruit) {
        fruitRepository.save(fruit);
        return true;
    }

    @Override
    public boolean deleteFruit(String id) {
        Fruit fruit = getOneFruit(id);
        fruitRepository.delete(fruit);
        return true;
    }

    @Override
    public Fruit getOneFruit(String id) throws NoSuchElementException {
        Optional<Fruit> fruit = fruitRepository.findAll().stream().filter(f-> f.get_id().equals(id)).findAny();
        if(fruit.isPresent()){
            return fruit.get();
        }
        else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public List<Fruit> getAllFruit() {
        return fruitRepository.findAll();
    }
}
