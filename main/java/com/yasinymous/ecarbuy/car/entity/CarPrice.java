package com.yasinymous.ecarbuy.car.entity;


import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "car_price")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Builder
public class CarPrice {
    private String id;
    private String carId;
    private double price;

}
