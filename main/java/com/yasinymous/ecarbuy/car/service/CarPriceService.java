package com.yasinymous.ecarbuy.car.service;

import com.yasinymous.ecarbuy.car.entity.CarPrice;
import com.yasinymous.ecarbuy.car.repository.mongo.CarPriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarPriceService {

    public final CarPriceRepository carPriceRepository;

    public CarPrice getByMoney(String id, double price){
        CarPrice carPrice = CarPrice.builder()
                .carId(id)
                .id("")
                .price(price)
                .build();
        carPriceRepository.save(carPrice);
        return carPrice;
    }

}
