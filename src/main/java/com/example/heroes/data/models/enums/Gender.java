package com.example.heroes.data.models.enums;

public enum Gender {
    MALE('M'),
    FEMALE('F');

    private Character code;

    private Gender(Character character){
        this.code = character;
    }

    public Character getCode(){
        return this.code;
    }
}
