package com.yasinymous.ecarbuy.car.startup;


import com.yasinymous.ecarbuy.car.model.CarSaveRequest;
import com.yasinymous.ecarbuy.car.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
public class CarDemo {

    private final CarService carService;


    @EventListener(ApplicationReadyEvent.class)
    public void migrate(){
        Long countOfData = carService.count().block();
        assert countOfData != null;
        if (countOfData.equals(0L)){
            IntStream.range(0, 12).forEach(car->{
                carService.save(
                    CarSaveRequest.builder()
                            .id("")
                            .status(Boolean.TRUE)
                            .image(List.of("https://garaj11.akamaized.net/a1/310_174/garaj11prod/listing/1797d929-d40a-40f1-b85d-d4b659512ca3/0c96463e-6fae-4540-98c7-1493bc99b0d9.png"))
                            .code("x")
                            .brand("Opel")
                            .model("Corsa")
                            .motor(1.2)
                            .customName("Edition Ozel Seri")
                            .hp(75)
                            .modelYear(2020)
                            .type("Otomobil")
                            .caseType("Sedan")
                            .fuel("Benzin")
                            .gear("Manuel")
                            .km(18.472)
                            .price(155.250)
                            .build());
                });
        }

    }
}
