package com.example.JOGIYO.Restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Transactional
@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public List<RestaurantDomain> getRestaurantDomains() {
        return restaurantRepository.findAll();
    }

    public RestaurantDomain getRestaurantDomain(Long rCode) {
        return restaurantRepository.findById(rCode)
                .orElseThrow(() -> new NoSuchElementException("No such Data!"));
    }

    public RestaurantDomain saveRestaurantDomain(RestaurantDomain restaurantDomain) {
        return restaurantRepository.save(restaurantDomain);
    }

    public RestaurantDomain updateRestaurantDomain(RestaurantDomain restaurantDomain) {
        RestaurantDomain updatedRestaurantDomain = null;

        try {
            RestaurantDomain existedRestaurantDomain = getRestaurantDomain(restaurantDomain.getRCode());
            if(!ObjectUtils.isEmpty(existedRestaurantDomain)) {
                updatedRestaurantDomain = restaurantRepository.save(restaurantDomain);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return updatedRestaurantDomain;
    }

    public void deleteRestaurantDomain(Long rCode) {
        restaurantRepository.deleteById(rCode);
    }
}
