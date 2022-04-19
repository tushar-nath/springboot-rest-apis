package com.example.liveasy.dto;

import lombok.Data;

@Data
public class LoadDto {

    private Long loadId;

    private String loadingPoint;

    private String unloadingPoint;

    private String productType;

    private String truckType;

    private Long noOfTrucks;

    private Long weight;

    private String comment;

    private String shipperId;

    private String date;
}
