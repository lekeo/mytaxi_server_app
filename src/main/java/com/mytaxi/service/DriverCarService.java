package com.mytaxi.service;

import com.mytaxi.dto.CarData;
import com.mytaxi.entity.DriverCar;

import java.util.List;

/**
 * Created by vinodjagwani on 7/15/17.
 */
public interface DriverCarService
{

    void delete(DriverCar driverCar);

    DriverCar  save(DriverCar driverCar);

    DriverCar findByDriverIdAndCarId(final Long driverId, final Long carId);

    List<Object[]> findDriverByCarAttributes(final CarData carData);

}
