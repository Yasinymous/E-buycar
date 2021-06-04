package com.yasinymous.ecarbuy.car.entity;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "car_price")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class CarPrice {
    private String id;
    private String carId;
    private String price;

}
