package com.yasinymous.ecarbuy.car.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarImage {
    private ImageType imageType;
    private String url;

    public enum ImageType {
        MAIN, DETAIL
    }
}
