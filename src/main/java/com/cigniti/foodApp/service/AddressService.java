package com.cigniti.foodApp.service;


import com.cigniti.foodApp.entity.Address;

import java.util.List;


public interface AddressService {
    public List<Address> getAllAddress();

    public Address saveAddress(Address address);

    public Address findByAddressId(int id);

    public void deleteByAddressId(int id);


}

