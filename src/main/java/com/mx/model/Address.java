package com.mx.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@Embeddable
@NoArgsConstructor
public class Address implements Serializable {

    private String street;
    private String suite;
    private String city;
    private String zipcode;

    @Embedded
    private Geo geo;

}