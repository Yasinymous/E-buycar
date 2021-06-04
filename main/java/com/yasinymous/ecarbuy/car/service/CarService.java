package com.yasinymous.ecarbuy.car.service;

import com.yasinymous.ecarbuy.car.entity.Car;
import com.yasinymous.ecarbuy.car.model.CarResponse;
import com.yasinymous.ecarbuy.car.model.CarSaveRequest;
import com.yasinymous.ecarbuy.car.repository.es.CarEsRepository;
import com.yasinymous.ecarbuy.car.repository.mongo.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarEsRepository carEsRepository;
    private final CarRepository carRepository;

    List<CarResponse> getByPaging(Pageable pageable){
       //
        return null;
    }

    CarResponse save(CarSaveRequest carSaveRequest){
        return null;
    }

}
