package com.Kartconnecting.Backend.converter;

import com.Kartconnecting.Backend.model.DificultadPista;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = false)
public class DificultadPistaConverter implements AttributeConverter<DificultadPista, String> {

    @Override
    public String convertToDatabaseColumn(DificultadPista dificultad) {
        if (dificultad == null) return null;

        return switch (dificultad) {
            case FACIL -> "Fácil";
            case MEDIA -> "Media";
            case DIFICIL -> "Difícil";
        };
    }

    @Override
    public DificultadPista convertToEntityAttribute(String dbValue) {
        if (dbValue == null) return null;

        return switch (dbValue) {
            case "Fácil" -> DificultadPista.FACIL;
            case "Media" -> DificultadPista.MEDIA;
            case "Difícil" -> DificultadPista.DIFICIL;
            default -> null;
        };
    }
}

