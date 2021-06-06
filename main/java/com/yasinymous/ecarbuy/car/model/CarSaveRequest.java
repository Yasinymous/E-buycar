package com.yasinymous.ecarbuy.car.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class CarSaveRequest {

    private String id;
    private String brand;
    private List<String> image;
    private String model;
    private int modelYear;
    private String type;
    private String caseType;
    private double motor;
    private String customName;
    private double hp;

    private String fuel;
    private String gear;
    private double km;

    private double price;
    private Boolean status;
    private String code;

}

/*
{
          'image': 'https://garaj11.akamaized.net/a1/310_174/garaj11prod/listing/d43016ed-ead7-429b-96df-f599d26d8aa7/b9f8644b-3661-4eb9-a448-670e2b8a08bd.png',
          'brand': 'Opel',
          'model': 'Corsa',
          'model_year': '2020',

          'car_type': 'Hatchback',
          'motor_cc': '1.2',
          'custom_name': 'Edition Ozel Seri',
          'hp': '75HP',

          'fuel_type': 'Benzin',
          'gear': 'Manuel',
          'km': '18.472 KM',

          'price': '155.250 TL',
          'detail_url': '',
        }
 */
