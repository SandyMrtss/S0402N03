package cat.itacademy.barcelonactiva.martos.sandra.s04.t02.n03.controllers;

import cat.itacademy.barcelonactiva.martos.sandra.s04.t02.n03.domain.Fruit;
import cat.itacademy.barcelonactiva.martos.sandra.s04.t02.n03.services.FruitService;

import jakarta.validation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class FruitController {
    @Autowired
    private FruitService fruitService;

    @PostMapping("/add")
    public ResponseEntity<String> createFruit(@Valid @RequestBody Fruit fruit){
        fruitService.addFruit(fruit);
        return new ResponseEntity<>("Fruit successfully created", HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateFruit(@PathVariable("id") String id, @RequestBody Fruit fruit){
        Fruit _fruit = fruitService.getOneFruit(id);
        boolean updated = false;

        if (fruit.getName() != null && !_fruit.getName().equals(fruit.getName())){
            _fruit.setName(fruit.getName());
            updated = true;
        }
        if(fruit.getAmountKg() != null && !_fruit.getAmountKg().equals(fruit.getAmountKg())){
            _fruit.setAmountKg(fruit.getAmountKg());
            updated = true;
        }
        fruitService.updateFruit(_fruit);
        if(updated){
            return new ResponseEntity<>("Fruit successfully updated", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("No changes were made", HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFruit(@PathVariable("id") String id){
        fruitService.deleteFruit(id);
        return new ResponseEntity<>("Fruit successfully deleted", HttpStatus.OK);
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruit> getOne(@PathVariable("id") String id){
        Fruit fruit = fruitService.getOneFruit(id);
        return new ResponseEntity<>(fruit, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruit>> getAll(){
        List<Fruit> fruits = fruitService.getAllFruit();
        if(fruits.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(fruits, HttpStatus.OK);
    }
}
