package com.yasinymous.ecarbuy.car.service;

import com.yasinymous.ecarbuy.car.entity.Car;
import com.yasinymous.ecarbuy.car.entity.CarImage;
import com.yasinymous.ecarbuy.car.entity.es.CarEs;
import com.yasinymous.ecarbuy.car.repository.es.CarEsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarEsService {

    private final CarEsRepository carEsRepository;

    public Mono<CarEs> saveNewCar(Car car){
       return carEsRepository.save(
               CarEs.builder()
                    .status(Boolean.TRUE)
                    .code(car.getCode())
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
                    .images(car.getCarImage().stream()
                               .map(CarImage::getUrl)
                               .collect(Collectors.toList()))
                    .price(car.getPrice())
                    .id(car.getId())
                    .build());
    }

    public Flux<CarEs> findAll(){
        return carEsRepository.findAll();
    }

    public Mono<CarEs> findById(String id) {
        return carEsRepository.findById(id);
    }

}
