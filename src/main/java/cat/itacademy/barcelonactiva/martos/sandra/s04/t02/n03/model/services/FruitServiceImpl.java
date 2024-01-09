package cat.itacademy.barcelonactiva.martos.sandra.s04.t02.n03.model.services;

import cat.itacademy.barcelonactiva.martos.sandra.s04.t02.n03.model.domain.Fruit;
import cat.itacademy.barcelonactiva.martos.sandra.s04.t02.n03.model.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class FruitServiceImpl implements FruitService{
    @Autowired
    private FruitRepository fruitRepository;

    @Override
    public boolean addFruit(Fruit fruit) {
        try{
            fruitRepository.save(fruit);
            return true;
        }
        catch (Exception ex){
            return false;
        }
    }

    @Override
    public boolean updateFruit(Fruit fruit) {
        try{
            fruitRepository.save(fruit);
            return true;
        }
        catch (Exception ex){
            return false;
        }
    }

    @Override
    public boolean deleteFruit(long id) {
        try{
            fruitRepository.deleteById(id);
            return true;
        }
        catch (Exception ex){
            return false;
        }
    }

    @Override
    public Fruit getOneFruit(long id) throws NoSuchElementException {
        Optional<Fruit> fruit = fruitRepository.findById(id);
        return fruit.orElse(null);
    }

    @Override
    public List<Fruit> getAllFruit() {
        try{
            return fruitRepository.findAll();
        }
        catch (Exception ex){
            return new ArrayList<>();
        }
    }
}
