package com.mytaxi.repository;

import com.mytaxi.entity.Manufacturer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by vinodjagwani on 7/15/17.
 */
public interface ManufacturerRepository extends CrudRepository<Manufacturer, Long>
{

    Manufacturer findByName(final String name);
}
