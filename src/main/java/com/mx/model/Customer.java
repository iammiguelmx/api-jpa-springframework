package com.mx.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity @ToString @AllArgsConstructor
public class Customer implements Serializable {

    @Id @Getter @Setter
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Getter @Setter
    private String firstName;

    @Getter @Setter
    private String lastName;

    protected Customer() {}

}