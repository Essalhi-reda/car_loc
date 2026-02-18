package com.example.demo.controllers;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.demo.classes.Car;
import com.example.demo.repository.CarRepository;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @PostMapping
    public Car addCar(@RequestBody Car car) {
        return carRepository.save(car);
    }

    @GetMapping
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

}
