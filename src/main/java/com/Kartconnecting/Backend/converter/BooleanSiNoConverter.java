package com.Kartconnecting.Backend.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = false)
public class BooleanSiNoConverter implements AttributeConverter<Boolean, String> {

    @Override
    public String convertToDatabaseColumn(Boolean value) {
        if (value == null) return "N";
        return value ? "S" : "N";
    }

    @Override
    public Boolean convertToEntityAttribute(String dbValue) {
        return "S".equals(dbValue);
    }
}

