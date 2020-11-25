package com.mx.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@ToString @AllArgsConstructor
public class AuthenticationResponse implements Serializable {

    private static final long serialVersionUID = 5284854376053912589L;

    @Getter @Setter
    private String jwt;


}