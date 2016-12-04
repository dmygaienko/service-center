package com.mygaienko.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by enda1n on 12.11.2016.
 */
@Data
@Entity
public class Work {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;

    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private WorkStatus status;

    @ManyToOne
    @JoinColumn(name="request_id")
    private Request request;

    @ManyToOne
    @JoinColumn(name = "master_id")
    private User master;
}
