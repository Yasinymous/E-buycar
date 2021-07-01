package com.yasinymous.ecarbuy.car.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CarDetailResponse {

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
