package com.Kartconnecting.Backend.converter;

import com.Kartconnecting.Backend.model.NivelCompetitivo;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = false)
public class NivelCompetitivoConverter implements AttributeConverter<NivelCompetitivo, String> {

    @Override
    public String convertToDatabaseColumn(NivelCompetitivo nivel) {
        return switch (nivel) {
            case AMATEUR -> "Amateur";
            case SEMI_PRO -> "Semi-Pro";
            case PRO -> "Pro";
        };
    }

    @Override
    public NivelCompetitivo convertToEntityAttribute(String dbValue) {
        return switch (dbValue) {
            case "Amateur" -> NivelCompetitivo.AMATEUR;
            case "Semi-Pro" -> NivelCompetitivo.SEMI_PRO;
            case "Pro" -> NivelCompetitivo.PRO;
            default -> null;
        };
    }
}
