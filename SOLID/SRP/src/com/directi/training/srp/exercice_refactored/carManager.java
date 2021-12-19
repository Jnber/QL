package com.directi.training.srp.exercise_refactored;

public class CarManager
{
    private final CarDAO _carDAO;
    private final CarFormater _carFormater;
    private final CarRanker _carRanker;

    public CarManager(CarDAO carDAO, CarFormater carFormater, CarRanker CarRanker)
    {
        _carDAO = carDAO;
        _carFormater = carFormater;
        _carRanker = CarRanker;
    }

    public Car getCarById(final String carId)
    {
        return _carDAO.getById(carId);
    }

    public String getCarsNames()
    {
        return _carFormater.getCarsNames(_carDAO.getAll());
    }

    public Car getBestCar()
    {
        return _carRanker.getBestCar(_carDAO.getAll());
    }
}