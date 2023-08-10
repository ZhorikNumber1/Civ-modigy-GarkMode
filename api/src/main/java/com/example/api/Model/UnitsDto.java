package com.example.api.Model;

public class UnitsDto {
    private String name;
    private String namePhoto;
    public UnitsDto(String name, String namePhoto) {
        this.name = name;
        this.namePhoto = namePhoto;
    }

    public String getNamePhoto() {
        return namePhoto;
    }

    public void setNamePhoto(String namePhoto) {
        this.namePhoto = namePhoto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
