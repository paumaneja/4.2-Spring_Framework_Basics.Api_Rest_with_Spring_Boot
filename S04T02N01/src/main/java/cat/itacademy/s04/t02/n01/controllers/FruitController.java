package cat.itacademy.s04.t02.n01.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FruitController {

    @GetMapping("/fruit/add")
    public void add()
}
