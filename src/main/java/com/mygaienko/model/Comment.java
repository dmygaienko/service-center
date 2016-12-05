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
public class Comment {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User by;

    @ManyToOne
    @JoinColumn(name="request_id")
    private Request request;

    private String content;

}
