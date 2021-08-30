package th.ac.ku.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import th.ac.ku.restaurant.model.Restaurant;
import th.ac.ku.restaurant.repository.RestaurantRepository;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository repository;

    public List<Restaurant> getAll() {
        return repository.findAll();
    }

    public Restaurant create(Restaurant restaurant) {
        repository.save(restaurant);
        return restaurant;
    }

    //wrapper => Get by id
    public Restaurant getRestaurant(int id) {
        return repository.findById(id).get();
    }

    //PUT => Update record
    public Restaurant update(int id, Restaurant requestBody) {
        //Get record
        Restaurant record = repository.findById(id).get();

        //set record in each attribute
        //we can make if-else or check in model
        if (requestBody.getName() != null) {
            record.setName(requestBody.getName());
        }
        if (requestBody.getAddress() != null) {
            record.setAddress(requestBody.getAddress());
        }
        if (requestBody.getPhone() != null) {
            record.setPhone(requestBody.getPhone());
        }
        if (requestBody.getNumSeats() > 0) {
            record.setNumSeats(requestBody.getNumSeats());
        }

        //update
        repository.save(record);
        //repository.saveAndFlush(record);//save into disk

        //verify only => Don't have to return
        return record;
    }


    public Restaurant delete(int id) {
        Restaurant record = repository.findById(id).get();
        repository.deleteById(id);
        return record;
    }




}

