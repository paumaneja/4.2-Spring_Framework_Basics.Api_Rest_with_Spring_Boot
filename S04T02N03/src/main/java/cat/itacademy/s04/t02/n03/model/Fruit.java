package cat.itacademy.s04.t02.n03.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Fruit")
public class Fruit {

    @Id
    private int id;

    @Field(name = "name")
    private String name;

    @Field(name = "qty_Kg")
    private double qty_Kg;

}
