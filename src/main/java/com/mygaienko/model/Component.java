package com.mygaienko.model;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by enda1n on 12.11.2016.
 */
public class Component {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    private BigDecimal price;

    @ManyToOne
    @JoinColumn
    private Request request;
}
