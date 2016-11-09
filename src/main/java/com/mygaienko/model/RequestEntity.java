package com.mygaienko.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by enda1n on 09.11.2016.
 */
@Data
@Entity
public class RequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private UserEntity client;

    @Enumerated(EnumType.STRING)
    private RequestType type;

    @Enumerated(EnumType.STRING)
    private RequestStatus status;

    @Column
    private boolean paid = false;

}
