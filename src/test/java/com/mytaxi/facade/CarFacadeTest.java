package com.mytaxi.facade;

import com.mytaxi.AbstractTest;
import com.mytaxi.dto.CarData;
import com.mytaxi.entity.Car;
import com.mytaxi.exception.EntityNotFoundException;
import com.mytaxi.facade.impl.DefaultCarFacade;
import com.mytaxi.service.CarService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import java.util.Collections;

/**
 * Created by vinodjagwani on 7/15/17.
 */
public class CarFacadeTest extends AbstractTest
{

    @Mock
    private CarService carService;

    @InjectMocks
    private DefaultCarFacade carFacade;


    @BeforeClass
    public static void setUp()
    {
        MockitoAnnotations.initMocks(DefaultCarFacade.class);
    }


    @Test
    public void testFindCarById() throws EntityNotFoundException
    {
        Car car = getCar();
        when(carService.findCarById(any(Long.class))).thenReturn(car);
        carFacade.findCarById(any(Long.class));
        verify(carService, times(1)).findCarById(any(Long.class));
    }


    @Test
    public void testFindAllCars()
    {
        Iterable<Car> cars = Collections.singletonList(getCar());
        when(carService.findAllCars()).thenReturn(cars);
        carFacade.findAllCars();
        verify(carService, times(1)).findAllCars();
    }


    @Test
    public void testCreate() throws EntityNotFoundException
    {
        Car car = getCar();
        CarData carData = getCarData();
        when(carService.create(any(Car.class))).thenReturn(car);
        carFacade.create(carData);
        verify(carService, times(1)).create(any(Car.class));
    }


    @Test
    public void testUpdate() throws EntityNotFoundException
    {
        CarData carData = getCarData();
        doNothing().when(carService).update(any(Car.class));
        carFacade.update(carData);
        verify(carService, times(1)).update(any(Car.class));
    }


    @Test
    public void testDelete() throws EntityNotFoundException
    {
        doNothing().when(carService).delete(any(Long.class));
        carFacade.delete(any(Long.class));
        verify(carService, times(1)).delete(any(Long.class));
    }
}
