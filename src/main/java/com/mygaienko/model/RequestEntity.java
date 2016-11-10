package com.mygaienko.model;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;

/**
 * Created by enda1n on 09.11.2016.
 */
@Data
@Entity(name = "request")
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

    @OneToOne
    private ProductEntity product;

    private boolean paid = false;

    public String getProductName() {
        return product == null ? StringUtils.EMPTY : product.getName();
    }

    public String getMakerName() {
        return (product == null || product.getMaker() == null) ? StringUtils.EMPTY : product.getMaker().getName();
    }

}
