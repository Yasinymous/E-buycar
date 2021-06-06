package com.yasinymous.ecarbuy.car.api;

import com.yasinymous.ecarbuy.car.entity.Car;
import com.yasinymous.ecarbuy.car.model.CarResponse;
import com.yasinymous.ecarbuy.car.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CarApi {

    private final CarService carService;

    @GetMapping
    public Flux<CarResponse> getAllCar(){
        return carService.getAll();
    }

}
