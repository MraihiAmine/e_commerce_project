package com.ecommerce.ecommerce.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "sale")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private int anne;
    private int number;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT")
    private Date date_mvt;
    private String name;
    private String address;
    private String town;
    private String code_p;
    private String phone;
    private String phone_1;
    private double totht;
    private double tottva;
    private double totttc;
    private String modreg;
    private String card_number;
    @JsonManagedReference
    @JsonIgnore
    @OneToMany(mappedBy = "sale", fetch = FetchType.EAGER)
    private List<LSale> lSales = new ArrayList<>();
}
