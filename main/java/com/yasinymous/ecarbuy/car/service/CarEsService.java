package com.yasinymous.ecarbuy.car.service;

import com.yasinymous.ecarbuy.car.entity.Car;
import com.yasinymous.ecarbuy.car.entity.es.CarEs;
import com.yasinymous.ecarbuy.car.repository.es.CarEsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CarEsService {

    private final CarEsRepository carEsRepository;

    public Mono<CarEs> saveNewCar(Car car){
       return carEsRepository.save(
               CarEs.builder()
                    .status(Boolean.TRUE)
                    .code("x")
                    .brand(car.getBrand())
                    .model(car.getModel())
                    .motor(car.getMotor())
                    .modelYear(car.getModelYear())
                    .type(car.getType())
                    .hp(car.getHp())
                    .customName(car.getCustomName())
                    .caseType(car.getCaseType())
                    .fuel(car.getFuel())
                    .gear(car.getGear())
                    .km(car.getKm())
                    .price(car.getPrice())
                    .id(car.getId())
                    .build());
    }

    public Flux<CarEs> findAll(){
        return carEsRepository.findAll();
    }

}
