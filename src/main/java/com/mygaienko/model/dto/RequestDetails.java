package com.mygaienko.model.dto;

import com.mygaienko.model.Request;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by enda1n on 03.12.2016.
 */
@Data
public class RequestDetails extends RequestDescription {

    private List<ImageDto> images;

    public RequestDetails(Request request) {
        super(request);

        images = request.getImages().stream().map((image) -> new ImageDto(image)).collect(Collectors.toList());
    }

}
