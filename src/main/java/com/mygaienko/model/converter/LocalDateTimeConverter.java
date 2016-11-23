package com.mygaienko.model.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by enda1n on 23.11.2016.
 */
@Converter(autoApply = true)
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Date> {

    public static final String DEFAULT_TIMEZONE = "UTC";

    @Override
    public Date convertToDatabaseColumn(LocalDateTime date) {
        if (date == null) return null;

        return Date.from(Instant.from(date.atZone(ZoneId.of(DEFAULT_TIMEZONE))));
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Date value) {
        if (value == null) return null;

        return LocalDateTime.from(value.toInstant().atZone(ZoneId.of(DEFAULT_TIMEZONE)));
    }
}
