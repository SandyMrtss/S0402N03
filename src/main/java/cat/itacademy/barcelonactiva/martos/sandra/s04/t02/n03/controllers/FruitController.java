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
        boolean created = fruitService.addFruit(fruit);
        if(created){
            return new ResponseEntity<>("Fruit successfully created", HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>("Something went wrong with the database server", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateFruit(@PathVariable("id") String id, @Valid @RequestBody Fruit fruit){
        Fruit _fruit = fruitService.getOneFruit(id);
        _fruit.setName(fruit.getName());
        _fruit.setAmountKg(fruit.getAmountKg());
        if(fruitService.updateFruit(_fruit)){
            return new ResponseEntity<>("Fruit successfully updated", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Something went wrong with the database server", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFruit(@PathVariable("id") String id){
        boolean deleted = fruitService.deleteFruit(id);
        if(deleted){
            return new ResponseEntity<>("Fruit successfully deleted", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Something went wrong with the database server", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruit> getOne(@PathVariable("id") String id){
        Fruit fruit = fruitService.getOneFruit(id);
        return new ResponseEntity<>(fruit, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruit>> getAll(){
        try{
            List<Fruit> fruits = fruitService.getAllFruit();
            if(fruits.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(fruits, HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
