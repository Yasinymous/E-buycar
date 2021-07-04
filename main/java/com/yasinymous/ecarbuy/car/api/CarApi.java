package com.yasinymous.ecarbuy.car.api;

import com.yasinymous.ecarbuy.car.model.CarDetailResponse;
import com.yasinymous.ecarbuy.car.model.CarResponse;
import com.yasinymous.ecarbuy.car.service.CarEsService;
import com.yasinymous.ecarbuy.car.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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


    @GetMapping("/{id}")
    public Mono<CarDetailResponse> getCarDetail(@PathVariable("id") String id) {
        return carService.getCarDetail(id);
    }

}
