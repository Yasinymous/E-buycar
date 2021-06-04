package com.yasinymous.ecarbuy.car.repository.mongo;

import com.yasinymous.ecarbuy.car.entity.CarPrice;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CarPriceRepository extends ReactiveMongoRepository<CarPrice, String> {
}
