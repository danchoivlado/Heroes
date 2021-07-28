package com.example.heroes.data.models.convertors;

import com.example.heroes.data.models.enums.Slot;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class SlotConvertor  implements AttributeConverter<Slot, String> {
    @Override
    public String convertToDatabaseColumn(Slot slot) {
        if (slot == null){
            return null;
        }

        return slot.getCode();
    }

    @Override
    public Slot convertToEntityAttribute(String code) {
        if (code == null){
            return null;
        }

        return Stream.of(Slot.values()).filter(s -> s.getCode() == code)
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }
}
