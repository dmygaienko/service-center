package com.mygaienko.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * Created by enda1n on 09.11.2016.
 */
@Data
@Entity(name = "request")
@EqualsAndHashCode(of = "id")
public class Request implements Serializable {

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
    private Set<Comment> comments;

    @OneToMany(mappedBy = "request")
    private Set<Image> images;

    @OneToMany(mappedBy = "request")
    private Set<Component> components;

    @OneToMany(mappedBy = "request")
    private Set<Work> works;

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
