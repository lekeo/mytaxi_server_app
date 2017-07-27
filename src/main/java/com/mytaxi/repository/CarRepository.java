package com.mytaxi.repository;

import com.mytaxi.entity.Car;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by vinodjagwani on 7/15/17.
 */
public interface CarRepository extends CrudRepository<Car, Long>
{
}
