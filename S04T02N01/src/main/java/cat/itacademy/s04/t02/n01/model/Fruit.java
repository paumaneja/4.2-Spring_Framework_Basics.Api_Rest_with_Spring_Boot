package cat.itacademy.s04.t02.n01.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "fruitsdb")
public class Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fruit_name", nullable = false, unique = true)
    private String name;

    @PositiveOrZero
    @Column(name = "qtyKg", nullable = false)
    private double qtyKg;
}
