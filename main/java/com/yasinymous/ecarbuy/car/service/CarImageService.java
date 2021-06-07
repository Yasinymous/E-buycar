package com.yasinymous.ecarbuy.car.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarImageService {

    public String getCarMainImage(String carId){
        return "https://garaj11.akamaized.net/a1/310_174/garaj11prod/listing/d43016ed-ead7-429b-96df-f599d26d8aa7/b9f8644b-3661-4eb9-a448-670e2b8a08bd.png";
    }
}
