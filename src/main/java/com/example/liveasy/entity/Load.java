package com.example.liveasy.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "load")
public class Load {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loadId;

    private String loadingPoint;

    private String unloadingPoint;

    private String productType;

    private String truckType;

    private Long noOfTrucks;

    private Long weight;

    private String comment;

    private String shipperId;

    private Date date;

}
