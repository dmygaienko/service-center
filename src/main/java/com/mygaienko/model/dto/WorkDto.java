package com.mygaienko.model.dto;

import com.mygaienko.model.Work;
import com.mygaienko.model.WorkStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Created by enda1n on 03.12.2016.
 */
@Data
@NoArgsConstructor
public class WorkDto {

    private Long id;
    private String description;
    private BigDecimal price;
    private WorkStatus status;
    private UserInfo master;

    public WorkDto(Work work) {
        id = work.getId();
        description = work.getDescription();
        price = work.getPrice();
        status = work.getStatus();
        master = new UserInfo(work.getMaster());
    }

}
