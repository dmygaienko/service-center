package com.mygaienko.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by enda1n on 10.11.2016.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "maker")
@EqualsAndHashCode(of = "id")
public class Maker implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
}
