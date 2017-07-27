package com.mytaxi.service;

import com.mytaxi.AbstractTest;
import com.mytaxi.entity.Driver;
import com.mytaxi.entity.OnlineStatus;
import com.mytaxi.exception.ConstraintsViolationException;
import com.mytaxi.exception.EntityNotFoundException;
import com.mytaxi.repository.DriverRepository;
import com.mytaxi.service.impl.DefaultDriverService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created by vinodjagwani on 7/15/17.
 */
public class DriverServiceTest extends AbstractTest
{

    @Mock
    private DriverRepository driverRepository;

    @InjectMocks
    private DefaultDriverService driverService;


    @BeforeClass
    public static void setUp()
    {
        MockitoAnnotations.initMocks(DefaultDriverService.class);
    }


    @Test
    public void testFindByDriverId()throws EntityNotFoundException
    {
        Driver driver = getDriver();
        when(driverRepository.findOne(any(Long.class))).thenReturn(driver);
        driverService.findByDriverId(any(Long.class));
        verify(driverRepository, times(1)).findOne(any(Long.class));
    }


    @Test
    public void testCreate() throws ConstraintsViolationException
    {
        Driver driver = getDriver();
        when(driverRepository.save(any(Driver.class))).thenReturn(driver);
        driverService.create(any(Driver.class));
        verify(driverRepository, times(1)).save(any(Driver.class));
    }


    @Test
    public void testDelete() throws EntityNotFoundException
    {
        Driver driver = getDriver();
        when(driverRepository.findOne(any(Long.class))).thenReturn(driver);
        driverService.delete(any(Long.class));
        verify(driverRepository, times(1)).findOne(any(Long.class));
    }


    @Test
    public void testUpdateLocation() throws EntityNotFoundException
    {
        Driver driver = getDriver();
        when(driverRepository.findOne(any(Long.class))).thenReturn(driver);
        driverService.updateLocation(1L, 90.0, 90.0);
        verify(driverRepository, times(1)).findOne(any(Long.class));
    }


    @Test
    public void testFindByOnlineStatus()
    {
        List<Driver> drivers = Collections.singletonList(getDriver());
        when(driverRepository.findByOnlineStatus(any(OnlineStatus.class))).thenReturn(drivers);
        driverService.findByOnlineStatus(OnlineStatus.ONLINE);
        verify(driverRepository, times(1)).findByOnlineStatus(any(OnlineStatus.class));
    }


}
