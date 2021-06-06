package com.yasinymous.ecarbuy.car.entity;


import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collation = "car")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Builder
public class Car {

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
    private List<CarImage> image;


/*
 {
          'image': 'https://garaj11.akamaized.net/a1/310_174/garaj11prod/listing/1797d929-d40a-40f1-b85d-d4b659512ca3/0c96463e-6fae-4540-98c7-1493bc99b0d9.png',
          'brand': 'Ford',
          'model': 'Focus',
          'model_year': '2017',

          'car_type': 'Sedan',
          'motor_cc': '1.6',
          'custom_name': 'Tdci Style',
          'hp': '115HP',

          'fuel_type': 'Dizel',
          'gear': 'Manuel',
          'km': '42.594 KM',

          'price': '181.000 TL',
          'detail_url': '',
        },
 */

}
