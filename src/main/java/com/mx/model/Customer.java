package com.mx.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity @ToString @AllArgsConstructor @NoArgsConstructor
public class Customer implements Serializable {

    @Id @Getter @Setter
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Getter @Setter
    @NotBlank(message = "firstName is mandatory")
    private String firstName;

    @Getter @Setter
    @NotBlank(message = "lastName is mandatory")
    private String lastName;

}