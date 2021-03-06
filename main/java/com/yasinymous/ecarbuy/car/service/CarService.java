package com.yasinymous.ecarbuy.car.service;

import com.yasinymous.ecarbuy.car.entity.Car;
import com.yasinymous.ecarbuy.car.entity.CarDetails;
import com.yasinymous.ecarbuy.car.entity.CarImage;
import com.yasinymous.ecarbuy.car.entity.es.CarEs;
import com.yasinymous.ecarbuy.car.model.CarDetailResponse;
import com.yasinymous.ecarbuy.car.model.CarResponse;
import com.yasinymous.ecarbuy.car.model.CarSaveRequest;
import com.yasinymous.ecarbuy.car.repository.es.CarEsRepository;
import com.yasinymous.ecarbuy.car.repository.mongo.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

import static com.yasinymous.ecarbuy.car.entity.CarImage.ImageType.MAIN;
import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarEsRepository carEsRepository;
    private final CarRepository carRepository;
    private final CarPriceService carPriceService;

    private final CarEsService carEsService;

    public Flux<CarResponse> getAll(){
        return carEsRepository.findAll().map(this::mapToDto);
    }

    public CarResponse save(CarSaveRequest r){
       Car car = Car.builder()
                .status(Boolean.TRUE)
                .code(r.getCode())
                .brand(r.getBrand())
                .model(r.getModel())
                .motor(r.getMotor())
                .modelYear(r.getModelYear())
                .customName(r.getCustomName())
                .hp(r.getHp())
                .type(r.getType())
                .caseType(r.getCaseType())
                .fuel(r.getFuel())
                .gear(r.getGear())
                .km(r.getKm())
                .price(r.getPrice())
                .id(r.getId())
                .carImage(r.getImage().stream().map(item-> new CarImage(MAIN,item)).collect(toList()))
                .build();
       car = carRepository.save(car).block();
       //carEsService.saveNewCar(car);
       return this.mapToDto(carEsService.saveNewCar(car).block());
    }

    private CarResponse mapToDto(CarEs item) {
        if (item == null){
            return null;
        }
       return CarResponse.builder()
                .price(carPriceService.getByMoney(item.getId(),item.getPrice()).getPrice())
                .id(item.getId())
                .brand(item.getBrand())
                .model(item.getModel())
                .modelYear(item.getModelYear())
                .customName(item.getCustomName())
                .type(item.getType())
                .caseType(item.getCaseType())
                .motor(item.getMotor())
                .hp(item.getHp())
                .fuel(item.getFuel())
                .km(item.getKm())
                .gear(item.getGear())
                .status(item.getStatus())
                .image(item.getImages().get(0))
                .build();
    }

    public Mono<Long> count() {
       return carRepository.count();
    }

    public Mono<CarDetailResponse> getCarDetail(String id) {
        return this.mapToDto(carEsService.findById(id));
    }

    private Mono<CarDetailResponse> mapToDto(Mono<CarEs> car) {
        return car.map( item-> CarDetailResponse.builder()
                .price(carPriceService.getByMoney(item.getId(),item.getPrice()).getPrice())
                .id(item.getId())
                .brand(item.getBrand())
                .model(item.getModel())
                .modelYear(item.getModelYear())
                .customName(item.getCustomName())
                .type(item.getType())
                .caseType(item.getCaseType())
                .motor(item.getMotor())
                .hp(item.getHp())
                .fuel(item.getFuel())
                .km(item.getKm())
                .gear(item.getGear())
                .status(item.getStatus())
                .images(item.getImages())
                .build());
    }

}
