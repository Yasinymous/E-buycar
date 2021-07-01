package com.yasinymous.ecarbuy.car.startup;


import com.yasinymous.ecarbuy.car.model.CarResponse;
import com.yasinymous.ecarbuy.car.model.CarSaveRequest;
import com.yasinymous.ecarbuy.car.repository.es.CarEsRepository;
import com.yasinymous.ecarbuy.car.service.CarService;
import com.yasinymous.ecarbuy.filestore.service.FileStoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;


import static java.util.UUID.randomUUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class CarDemo {

    private final CarService carService;
    private final CarEsRepository carEsRepository;
    private final FileStoreService fileStoreService;

    @EventListener(ApplicationReadyEvent.class)
    public void migrate() {

        Long countOfData = carService.count().block();
        assert countOfData != null;
        if (countOfData.equals(0L)){

            carEsRepository.deleteAll().block();

            IntStream.range(0, 6).forEach(car->{

                String imgid = UUID.randomUUID().toString();
                // TODO rame yukleme arastir inputstream olarak yukleme
                byte[] file = null;
                try {
                    file = Files.readAllBytes(ResourceUtils.getFile("classpath:car-images/test.jpeg").toPath());
                }catch(Exception e){
                    log.error("File Read error : ",e);
                }
                fileStoreService.saveImage(imgid, new ByteArrayInputStream(file));

                carService.save(
                    CarSaveRequest.builder()
                            .id(randomUUID().toString())
                            .status(Boolean.TRUE)
                            .image(List.of(imgid))
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
