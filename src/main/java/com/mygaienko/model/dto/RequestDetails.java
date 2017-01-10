package com.mygaienko.model.dto;

import com.mygaienko.model.Request;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by enda1n on 03.12.2016.
 */
@Data
public class RequestDetails extends RequestDescription {

    private List<ImageDto> images;
    private List<ComponentDto> components;
    private List<WorkDto> works;
    private List<CommentDto> comments;

    public RequestDetails(Request request, BigDecimal price) {
        super(request, price);

        images = request.getImages().stream().map(
                (image) -> new ImageDto(image)
        ).collect(Collectors.toList());

        components = request.getComponents().stream().map(
                (component) -> new ComponentDto(component)
        ).collect(Collectors.toList());

        works = request.getWorks().stream().map(
                (work) -> new WorkDto(work)
        ).collect(Collectors.toList());

        comments = request.getComments().stream().map(
                (comment) -> new CommentDto(comment)
        ).collect(Collectors.toList());
    }

}
