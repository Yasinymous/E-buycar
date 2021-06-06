package com.yasinymous.ecarbuy.car.service;

import com.yasinymous.ecarbuy.car.repository.mongo.CarPriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarPriceService {

    public final CarPriceRepository carPriceRepository;

    public double getByMoney(String id){
        return 10;
    }

}
