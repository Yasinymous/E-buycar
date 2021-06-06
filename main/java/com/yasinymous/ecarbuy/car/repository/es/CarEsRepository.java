package com.yasinymous.ecarbuy.car.repository.es;

import com.yasinymous.ecarbuy.car.entity.Car;
import com.yasinymous.ecarbuy.car.entity.es.CarEs;
import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository;

public interface CarEsRepository extends ReactiveElasticsearchRepository<CarEs, String> {
}
