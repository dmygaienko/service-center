package com.mygaienko.model.dto;

import com.mygaienko.model.Component;
import com.mygaienko.model.ComponentStatus;
import com.mygaienko.model.Image;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by enda1n on 03.12.2016.
 */
@Data
public class ComponentDto {

    private Long id;
    private String name;
    private BigDecimal price;
    private ComponentStatus status;

    public ComponentDto(Component component) {
        id = component.getId();
        name = component.getName();
        price = component.getPrice();
        status = component.getStatus();
    }
}
