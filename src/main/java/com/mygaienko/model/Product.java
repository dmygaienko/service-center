package com.mygaienko.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.h2.result.SearchRow;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by enda1n on 10.11.2016.
 */
@Data
@Entity(name = "product")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn
    private Maker maker;

    private String name;

    @OneToMany(mappedBy = "product")
    private Set<Manual> manuals;
}
