package com.yasinymous.ecarbuy.car.repository.mongo;

import com.yasinymous.ecarbuy.car.entity.Car;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CarRepository extends ReactiveMongoRepository<Car, String> {
}
