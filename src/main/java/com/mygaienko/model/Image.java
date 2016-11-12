package com.mygaienko.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by enda1n on 12.11.2016.
 */
@Data
@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Lob
    private byte[] content;

    private Date created;

    private String description;

    @ManyToOne
    @JoinColumn
    private Request request;
}
