package com.yasinymous.ecarbuy.car.entity.es;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "car")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class CarEs {
    private String id;
    private BrandEs Brand;
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
    private CategoryEs Categoryid;

}
