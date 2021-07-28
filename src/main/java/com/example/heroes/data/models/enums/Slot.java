package com.example.heroes.data.models.enums;

public enum Slot {
    WEAPON("Weapon"),
    HELMET("Helmet"),
    PAULDRON("Pauldron"),
    PADS("Pads"),
    GAUNTLETS("Gauntlets");


    private String code;
    private Slot(String code)
    {
        this.code = code;
    }

    public String getCode(){
        return this.code;
    }
}
