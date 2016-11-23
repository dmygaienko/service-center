package com.mygaienko.model;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by enda1n on 09.11.2016.
 */
@Data
@Entity(name = "request")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private User client;

    @Enumerated(EnumType.STRING)
    private RequestType type;

    @Enumerated(EnumType.STRING)
    private RequestStatus status;

    @OneToOne
    private Product product;

    @OneToMany(mappedBy = "request")
    private List<Comment> comments;

    @OneToMany(mappedBy = "request")
    private List<Image> images;

    @OneToMany(mappedBy = "request")
    private List<Component> components;

    private LocalDateTime datetime;

    private BigDecimal price;

    private boolean paid = false;

    public String getProductName() {
        return product == null ? StringUtils.EMPTY : product.getName();
    }

    public String getMakerName() {
        return (product == null || product.getMaker() == null) ? StringUtils.EMPTY : product.getMaker().getName();
    }

}
