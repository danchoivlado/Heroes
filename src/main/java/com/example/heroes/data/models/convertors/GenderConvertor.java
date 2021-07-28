package com.example.heroes.data.models.convertors;

import com.example.heroes.data.models.enums.Gender;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class GenderConvertor implements AttributeConverter<Gender,Character> {

    @Override
    public Character convertToDatabaseColumn(Gender gender) {
        if (gender == null){
            return null;
        }

        return gender.getCode();
    }

    @Override
    public Gender convertToEntityAttribute(Character code) {
        if (code == null){
            return null;
        }

        return Stream.of(Gender.values())
                .filter(g -> g.getCode() == code)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
