package com.mygaienko.model.dto;

import com.mygaienko.model.Request;
import com.mygaienko.model.RequestStatus;
import com.mygaienko.model.RequestType;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by enda1n on 12.11.2016.
 */
@Data
public class RequestDescription {

    private final long id;
    private final String client;
    private final RequestType type;
    private final RequestStatus status;
    private final String productDescription;
    private final BigDecimal price;
    private final boolean paid;

    public RequestDescription(Request request, BigDecimal price) {
        id = request.getId();
        client = request.getClient().getFirstName() + " " + request.getClient().getSurname();
        type = request.getType();
        status = request.getStatus();
        productDescription = request.getMakerName() + " " + request.getProductName();
        this.price = price;
        paid = request.isPaid();
    }

}
