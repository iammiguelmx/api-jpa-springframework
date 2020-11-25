package com.mx.model;

import lombok.*;

import javax.persistence.Embeddable;

@Data
@AllArgsConstructor
@Embeddable
@NoArgsConstructor
public class Geo {

    @Getter @Setter
    private String lat;

    @Getter @Setter
    private String lng;

}

