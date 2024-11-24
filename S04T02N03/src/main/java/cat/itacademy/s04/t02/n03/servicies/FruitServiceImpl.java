package cat.itacademy.s04.t02.n03.servicies;

import cat.itacademy.s04.t02.n03.exception.FruitAlreadyExistsException;
import cat.itacademy.s04.t02.n03.exception.FruitNotFoundException;
import cat.itacademy.s04.t02.n03.exception.NoDataFoundException;
import cat.itacademy.s04.t02.n03.model.Fruit;
import cat.itacademy.s04.t02.n03.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FruitServiceImpl implements FruitService{

    @Autowired
    private FruitRepository fruitRepository;

    @Override
    public Fruit addFruit(Fruit fruit) {
        if (fruitRepository.existsByName(fruit.getName())) {
            throw new FruitAlreadyExistsException("Fruits already exist.");
        }
        return fruitRepository.save(fruit);
    }

    @Override
    public Fruit updateFruit(Fruit fruit) {
        Fruit oldFruit = fruitRepository.findByName(fruit.getName())
                .orElseThrow(() -> new FruitNotFoundException("Fruit " + fruit.getName() + " not found."));
        fruit.setId(oldFruit.getId());
        return fruitRepository.save(fruit);
    }

    @Override
    public void deleteFruit(int id) {
        fruitRepository.findById(id)
                .orElseThrow(() -> new FruitNotFoundException("Fruit whit id " + id + " not found."));
        fruitRepository.deleteById(id);
    }

    @Override
    public Fruit getFruitById(int id) {
        return fruitRepository.findById(id)
                .orElseThrow(() -> new FruitNotFoundException("Fruit whit id " + id + " not found."));
    }

    @Override
    public List<Fruit> getAllFruits() {
        List<Fruit> fruits = fruitRepository.findAll();
        if (fruits.isEmpty()){
            throw new NoDataFoundException("The DB is empty.");
        }
        return fruits;
    }
}
