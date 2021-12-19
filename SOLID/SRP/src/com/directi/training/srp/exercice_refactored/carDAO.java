package com.directi.training.srp.exercise_refactored;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarDAO
{
    private List<Car> _carsDb = Arrays
        .asList(new Car("1", "Golf III", "Volkswagen"), new Car("2", "Multipla", "Fiat"),
            new Car("3", "Megane", "Renault"));

    public Car getById(String carId)
    {
        for (Car car : _carsDb) {
            if (car.getId().equals(carId)) {
                return car;
            }
        }
        return null;
    }

    public List<Car> getAll()
    {
        return new ArrayList<>(_carsDb);
    }

}