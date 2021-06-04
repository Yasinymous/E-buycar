package com.yasinymous.ecarbuy.car.repository.es;

import com.yasinymous.ecarbuy.car.entity.Car;
import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository;


public interface CarEsRepository extends ReactiveElasticsearchRepository<Car, String> {
}
