package com.mygaienko.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * Created by enda1n on 12.11.2016.
 */
@Data
@Entity
@EqualsAndHashCode(of = "id")
public class Manual {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Lob
    private byte[] content;

    private String name;

    @ManyToOne
    @JoinColumn
    private Product product;
}
