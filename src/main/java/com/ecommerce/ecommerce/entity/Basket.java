package com.ecommerce.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "basket")
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private int year;
    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd", timezone = "GMT")
    private Date date_mvt;
    private String name;
    private String address;
    private String saddress;
    private String town;
    private String p_code;
    private String phone_number;
    private String phone_number_2;
    private String totht;
    private String tottva;
    private String totttc;
    private String modreg;
    private String card_number;
}
