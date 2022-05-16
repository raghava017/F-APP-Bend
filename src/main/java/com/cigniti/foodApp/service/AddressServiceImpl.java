package com.cigniti.foodApp.service;


import com.cigniti.foodApp.entity.Address;
import com.cigniti.foodApp.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository addressRepo;

    @Override
    public List<Address> getAllAddress() {
        List<Address> addressList = addressRepo.findAll();
        return addressList;
    }

    @Override
    public Address saveAddress(Address address) {
        addressRepo.save(address);
        return address;
    }

    @Override
    public Address findByAddressId(int id) {
        Optional<Address> result = addressRepo.findById(id);
        Address address = null;

        if (result.isPresent()) {
            address = result.get();
        } else {
            throw new RuntimeException("Could not find by Id:" + id);
        }
        return address;
    }

    @Override
    public void deleteByAddressId(int id) {
        addressRepo.deleteById(id);

    }

}

