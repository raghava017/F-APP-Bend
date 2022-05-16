
package com.cigniti.foodApp.controller;

import com.cigniti.foodApp.entity.Genie;
import com.cigniti.foodApp.service.GenieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "https://20.235.64.55:3000")
@RestController

@RequestMapping("/genie")

public class GenieController {

    @Autowired
    GenieService genieService;

    /*@GetMapping("/list")
    public List<Genie> getAllUsers() {
        List<Genie> genie = genieService.findAll();
        return genie;

    }*/

    @PostMapping("/save")
    public Genie saveGenie(@RequestBody Genie genie) {
       /* genie.setPickupAddress("");
        genie.setDropAddress("");
        genie.setPhoneNumber("");
        genie.setTaskDetails("");
        genie.setDescription("");
        */


       genieService.save(genie);

        return genie;
    }

    /*@PutMapping("/edit")
    public Genie updateGenie(@RequestBody User user) {
        genieService.save(genie);

        return genie;
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {

        Genie user = genieService.findByUserId(id);
        if (genie == null) {
            throw new RuntimeException("genieId not found " + id);
        }

      genieService.deleteByUserId(id);
        return "Deleted genieId :" + id;

    }*/
}