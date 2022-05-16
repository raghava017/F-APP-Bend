
package com.cigniti.foodApp.service;

import com.cigniti.foodApp.entity.Genie;
import com.cigniti.foodApp.repository.GenieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenieServiceImpl implements GenieService {

    @Autowired
    GenieRepository genieRepo;
/*

    @Override
    public List<Genie> findAll() {
        List<Genie> genies= genieRepoRepo.findAll();
        return genies;
    }
*/

    @Override
    public void save(Genie genie) {
        genieRepo.save(genie);

    }

    /*@Override
    public Genie findByGenieId(int id) {
        Optional<Genie> result = genieRepo.findById(id);
        Genie genie = null;

        if (result.isPresent()) {
            genie = result.get();
        } else {
            throw new RuntimeException("Could not find by Id:" + id);
        }
        return genie;
    }

    @Override
    public void deleteByGenieId(int id) {
        genieRepo.deleteGenie(id);

    }*/
}



