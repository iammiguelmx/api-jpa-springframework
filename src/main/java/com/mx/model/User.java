package com.mx.model;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Entity @ToString @AllArgsConstructor @NoArgsConstructor
@Table(name = "users")
public class User implements Serializable {


    @Id @Getter @Setter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Getter @Setter
    private String username;

    @Getter @Setter
    private String password;

    @Getter @Setter
    private String role;

    @Getter @Setter
    private boolean enabled;

}
