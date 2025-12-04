package com.Kartconnecting.Backend.converter;

import com.Kartconnecting.Backend.model.EstadoBusqueda;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = false)
public class EstadoBusquedaConverter implements AttributeConverter<EstadoBusqueda, String> {

    @Override
    public String convertToDatabaseColumn(EstadoBusqueda estado) {
        if (estado == null) return null;

        return switch (estado) {
            case ABIERTA -> "Abierta";
            case CERRADA -> "Cerrada";
        };
    }

    @Override
    public EstadoBusqueda convertToEntityAttribute(String dbValue) {
        if (dbValue == null) return null;

        return switch (dbValue) {
            case "Abierta" -> EstadoBusqueda.ABIERTA;
            case "Cerrada" -> EstadoBusqueda.CERRADA;
            default -> null;
        };
    }
}

