package com.mygaienko.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by enda1n on 09.11.2016.
 */
@Data
@Entity(name = "user")
/*@Table(name = "user")*/
public class UserEntity {

    @Id
    @GeneratedValue
    private long id;
    @Column
    private String firstName;
    @Column
    private String surname;
    @Column
    private String contactNumber;
    @Column
    private String address;
}
