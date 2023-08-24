package com.example.api.Model.UnitsDTO;

public class UnitsDTO {
    String name;
    byte[] photoURL;
    String unit_type;

    public UnitsDTO() {
    }

    public UnitsDTO(String name, byte[] photoURL, String unit_type) {
        this.name = name;
        this.photoURL = photoURL;
        this.unit_type = unit_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(byte[] photoURL) {
        this.photoURL = photoURL;
    }

    public String getUnit_type() {
        return unit_type;
    }

    public void setUnit_type(String unit_type) {
        this.unit_type = unit_type;
    }
}
