package com.mytaxi.service.impl;

import com.mytaxi.repository.DriverRepository;
import com.mytaxi.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by vinodjagwani on 7/15/17.
 */
@Service("userDetailsService")
public class DefaultUserService implements UserDetailsService
{

    @Autowired
    private DriverRepository driverRepository;


    @Override public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        return driverRepository.findByUsername(username);
    }
}
