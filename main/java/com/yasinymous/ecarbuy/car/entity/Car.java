package com.yasinymous.ecarbuy.car.entity;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "car")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Car {

    private String id;
    private String Brandid;
    private String Model;
    private String Model_year;
    private String VehicleType;
    private String CaseType;
    private String Customname;
    private double Motor;
    private double Hp;
    private String Fuel;
    private String Gear;
    private String Km;
    private double Price;
    private String Code;
    private Boolean status;
    private List<CarImage> carImage;


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
