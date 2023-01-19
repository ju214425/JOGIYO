package com.example.JOGIYO.Restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping()
public class RestaurantController {
    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping(value = "/restaurants")
    public ResponseEntity<List<RestaurantDomain>> selectAll() {
        List<RestaurantDomain> restaurantDomainList = this.restaurantService.getRestaurantDomains();
        return new ResponseEntity<>(restaurantDomainList, HttpStatus.OK);
    }

    @GetMapping(value = "/restaurants/{id}")
    public ResponseEntity<RestaurantDomain> select(@PathVariable(name = "id") Long rCode) {
        RestaurantDomain restaurantDomain = this.restaurantService.getRestaurantDomain(rCode);
        return new ResponseEntity<>(restaurantDomain, HttpStatus.OK);
    }

    
}
