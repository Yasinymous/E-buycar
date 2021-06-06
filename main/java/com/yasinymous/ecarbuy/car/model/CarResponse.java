package com.yasinymous.ecarbuy.car.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarResponse {

    private String id;
    private String image;
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
    private String km;
    private double price;
    private String code;
    private Boolean status;


}
