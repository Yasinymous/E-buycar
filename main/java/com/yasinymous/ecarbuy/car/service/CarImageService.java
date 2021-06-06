package com.yasinymous.ecarbuy.car.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarImageService {

    public String getCarMainImage(String carId){
        return "https://garaj11.akamaized.net/a1/310_174/garaj11prod/listing/1797d929-d40a-40f1-b85d-d4b659512ca3/0c96463e-6fae-4540-98c7-1493bc99b0d9.png";
    }
}
