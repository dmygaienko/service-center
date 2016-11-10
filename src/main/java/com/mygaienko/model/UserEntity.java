package com.mygaienko.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by enda1n on 09.11.2016.
 */
@Data
@Entity(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue
    private long id;

    private String firstName;

    private String surname;

    private String contactNumber;

    private String address;
}
