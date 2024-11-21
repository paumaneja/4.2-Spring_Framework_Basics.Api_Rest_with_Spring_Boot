package cat.itacademy.s04.t02.n01.repository;

import cat.itacademy.s04.t02.n01.model.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface FruitRepository extends JpaRepository<Fruit, Integer> {
    boolean existsByName(String name);
    Optional<Fruit> findByName(String name);
}
