package com.mygaienko.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by enda1n on 12.11.2016.
 */
@Data
@Entity
@EqualsAndHashCode(of = "id")
public class Component {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private ComponentStatus status;

    @ManyToOne
    @JoinColumn
    private Request request;
}
