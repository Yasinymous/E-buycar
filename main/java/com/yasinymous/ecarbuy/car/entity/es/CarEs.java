package com.yasinymous.ecarbuy.car.entity.es;

import com.yasinymous.ecarbuy.car.entity.CarImage;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.List;

@Document(indexName = "car")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Builder
public class CarEs {
    private String id;
    private String brand;
    private String model;
    private int modelYear;
    private String type;
    private String caseType;
    private String customName;
    private double motor;
    private double hp;
    private String fuel;
    private String gear;
    private double km;
    private double price;
    private String code;
    private Boolean status;
    private List<String> images;
}
