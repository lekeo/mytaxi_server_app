package com.mytaxi.facade.impl;

import com.mytaxi.dto.CarData;
import com.mytaxi.entity.Car;
import com.mytaxi.exception.EntityNotFoundException;
import com.mytaxi.facade.CarFacade;
import com.mytaxi.populator.CarPopulator;
import com.mytaxi.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultCarFacade implements CarFacade
{

    @Autowired
    private CarService carService;


    @Override
    public CarData findCarById(Long carId) throws EntityNotFoundException
    {
        return CarPopulator.populate(carService.findCarById(carId));
    }


    @Override
    public List<CarData> findAllCars()
    {
        return CarPopulator.populate(carService.findAllCars());
    }


    @Override
    public CarData create(CarData carData) throws EntityNotFoundException
    {
        Car car = CarPopulator.convert(carData);
        return CarPopulator.populate(carService.create(car));
    }


    @Override
    public void update(final CarData carData) throws EntityNotFoundException
    {
        Car car = CarPopulator.convert(carData);
        car.setId(carData.getId());
        carService.update(car);
    }


    @Override
    public void delete(Long carId) throws EntityNotFoundException
    {
        carService.delete(carId);
    }
}
