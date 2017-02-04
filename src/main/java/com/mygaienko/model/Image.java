package com.mygaienko.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by enda1n on 12.11.2016.
 */
@Data
@Entity
@EqualsAndHashCode(of = "id")
public class Image  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Lob
    private byte[] content;

    private LocalDateTime created;

    private String description;

    @ManyToOne
    @JoinColumn
    private Request request;


    public Image(byte[] content) {
        this.content = content;
    }

    public Image() {
    }
}
