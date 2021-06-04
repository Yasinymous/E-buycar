package com.yasinymous.ecarbuy.car.entity;

public class CarImage {
    private ImageType imageType;
    private String url;

    enum ImageType {
        MAIN, DETAIL
    }
}
