package com.cigniti.foodApp.controller;


import com.cigniti.foodApp.entity.Address;
import com.cigniti.foodApp.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http:20.219.35.173:3000")
@RestController

@RequestMapping("/address")

public class AddressController {



    @Autowired
    AddressService addressService;

    @GetMapping("/list")
    public List<Address> getAlladdress() {

        List<Address> addressList = addressService.getAllAddress();
        return addressList;

    }

    @PostMapping("/save")
    public Address saveAddress(@RequestBody Address Address) {
        addressService.saveAddress(Address);

        return Address;

    }

    @PutMapping("/edit")
    public Address updateAddress(@RequestBody Address address) {
        addressService.saveAddress(address);

        return address;
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {

        Address address = addressService.findByAddressId(id);
        if (address == null) {
            throw new RuntimeException("address not found with id" + id);
        }

        addressService.deleteByAddressId(id);
        return "Deleted address with id :" + id;
    }



}
