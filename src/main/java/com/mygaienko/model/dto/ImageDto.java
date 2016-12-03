package com.mygaienko.model.dto;

import com.mygaienko.model.Image;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by enda1n on 03.12.2016.
 */
@Data
public class ImageDto {

    private Long id;
    private byte[] content;
    private LocalDateTime created;
    private String description;

    public ImageDto(Image image) {
        id = image.getId();
        content = image.getContent();
        created = image.getCreated();
        description = image.getDescription();
    }
}
