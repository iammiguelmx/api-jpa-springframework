package com.mx.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
public class Mail implements Serializable {

    private static final long serialVersionUID = -8174581587647900376L;

    @Getter @Setter
    private String from;

    @Getter @Setter
    private String mailTo;

    @Getter @Setter
    private String subject;

    @Getter @Setter
    private List<Object> attachments;

    @Getter @Setter
    private Map<String, Object> props;

}