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
            IntStream.range(0, 6).forEach(car->{
                carService.save(
                    CarSaveRequest.builder()
                            .id("")
                            .status(Boolean.TRUE)
                            .image(List.of("https://garaj11.akamaized.net/a1/310_174/garaj11prod/listing/d43016ed-ead7-429b-96df-f599d26d8aa7/b9f8644b-3661-4eb9-a448-670e2b8a08bd.png"))
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
