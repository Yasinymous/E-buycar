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


            for (int i=0;i<6;i++) {
                String imgid = UUID.randomUUID().toString();
                byte[] file = null;
                switch (i) {
                    case 0:
                        try {
                            file = Files.readAllBytes(ResourceUtils.getFile("classpath:car-images/test.jpeg").toPath());
                        } catch (Exception e) {
                            log.error("File Read error : ", e);
                        }
                        fileStoreService.saveImage(imgid, new ByteArrayInputStream(file));

                        carService.save(
                                CarSaveRequest.builder()
                                        .id(randomUUID().toString())
                                        .status(Boolean.TRUE)
                                        .image(List.of(imgid))
                                        .code("")
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


                        break;
                    case 1:
                        try {
                            file = Files.readAllBytes(ResourceUtils.getFile("classpath:car-images/test1.jpg").toPath());
                        }catch(Exception e){
                            log.error("File Read error : ",e);
                        }
                        fileStoreService.saveImage(imgid, new ByteArrayInputStream(file));

                        carService.save(
                                CarSaveRequest.builder()
                                        .id(randomUUID().toString())
                                        .status(Boolean.TRUE)
                                        .image(List.of(imgid))
                                        .code("")
                                        .brand("Citroen")
                                        .model("C-Elysee")
                                        .motor(1.5)
                                        .customName("Bluehdi Feel")
                                        .hp(100)
                                        .modelYear(2020)
                                        .type("Otomobil")
                                        .caseType("Sedan")
                                        .fuel("Dizel")
                                        .gear("Manuel")
                                        .km(27.796)
                                        .price(162.500)
                                        .build());
                        break;
                    case 2:
                        try {
                            file = Files.readAllBytes(ResourceUtils.getFile("classpath:car-images/test2.jpg").toPath());
                        }catch(Exception e){
                            log.error("File Read error : ",e);
                        }
                        fileStoreService.saveImage(imgid, new ByteArrayInputStream(file));

                        carService.save(
                                CarSaveRequest.builder()
                                        .id(randomUUID().toString())
                                        .status(Boolean.TRUE)
                                        .image(List.of(imgid))
                                        .code("Facelift")
                                        .brand("Honda")
                                        .model("Civic")
                                        .motor(1.6)
                                        .customName("i-VTEC Eco Elegance")
                                        .hp(125)
                                        .modelYear(2021)
                                        .type("Otomobil")
                                        .caseType("Sedan")
                                        .fuel("Benzin")
                                        .gear("Otomatik")
                                        .km(11)
                                        .price(283.300)
                                        .build());
                        break;
                    case 3:
                        try {
                            file = Files.readAllBytes(ResourceUtils.getFile("classpath:car-images/test3.jpg").toPath());
                        }catch(Exception e){
                            log.error("File Read error : ",e);
                        }
                        fileStoreService.saveImage(imgid, new ByteArrayInputStream(file));

                        carService.save(
                                CarSaveRequest.builder()
                                        .id(randomUUID().toString())
                                        .status(Boolean.TRUE)
                                        .image(List.of(imgid))
                                        .code("")
                                        .brand("Dacia")
                                        .model("Duster")
                                        .motor(1.5)
                                        .customName("4x2 Laureate")
                                        .hp(90)
                                        .modelYear(2021)
                                        .type("Otomobil")
                                        .caseType("SUV")
                                        .fuel("Dizel")
                                        .gear("Manuel")
                                        .km(143.662)
                                        .price(146.950)
                                        .build());
                        break;
                    case 4:
                        try {
                            file = Files.readAllBytes(ResourceUtils.getFile("classpath:car-images/test4.jpg").toPath());
                        }catch(Exception e){
                            log.error("File Read error : ",e);
                        }
                        fileStoreService.saveImage(imgid, new ByteArrayInputStream(file));

                        carService.save(
                                CarSaveRequest.builder()
                                        .id(randomUUID().toString())
                                        .status(Boolean.TRUE)
                                        .image(List.of(imgid))
                                        .code("")
                                        .brand("Volkswagen")
                                        .model("Jetta")
                                        .motor(1.6)
                                        .customName("Tdi Comfortline Dsg")
                                        .hp(105)
                                        .modelYear(2013)
                                        .type("Otomobil")
                                        .caseType("Sedan")
                                        .fuel("Dizel")
                                        .gear("Otomatik")
                                        .km(90.390)
                                        .price(160.100)
                                        .build());
                        break;
                    case 5:
                        try {
                            file = Files.readAllBytes(ResourceUtils.getFile("classpath:car-images/test5.jpeg").toPath());
                        }catch(Exception e){
                            log.error("File Read error : ",e);
                        }
                        fileStoreService.saveImage(imgid, new ByteArrayInputStream(file));

                        carService.save(
                                CarSaveRequest.builder()
                                        .id(randomUUID().toString())
                                        .status(Boolean.TRUE)
                                        .image(List.of(imgid))
                                        .code("")
                                        .brand("Renault")
                                        .model("Clio")
                                        .motor(1.0)
                                        .customName("Sce Joy")
                                        .hp(72)
                                        .modelYear(2020)
                                        .type("Otomobil")
                                        .caseType("Hatchback")
                                        .fuel("Benzin")
                                        .gear("Manuel")
                                        .km(5)
                                        .price(155.100)
                                        .build());
                        break;

                    default:
                        // code block
                }


            }
        }

    }


}
