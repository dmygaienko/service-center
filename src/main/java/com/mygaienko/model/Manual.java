package com.mygaienko.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by enda1n on 12.11.2016.
 */
@Data
@Entity
public class Manual {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Lob
    private byte[] content;

    private String description;

    @OneToOne
    @JoinColumn
    private Product product;
}
