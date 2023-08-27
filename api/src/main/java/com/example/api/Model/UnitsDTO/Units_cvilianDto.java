package com.example.api.Model.UnitsDTO;

public class Units_cvilianDto {
    private String name;
    private String namePhoto;
    private byte[] photoURL;
    private String nameMod;
    private String description;
    private String author;
    private Long id;
    private int cost;
    private int baseMoves;
    private String Unit_Type;
    private int maintenance;
    private String prereqTech;
    private int Combat;
    public Units_cvilianDto(String name, int baseMoves, int cost, int maintenance, byte[] urlPhoto, String prereqTech, int combat, long id, String unit_Type) {
        this.name = name;
        this.cost = cost;
        this.baseMoves = baseMoves;
        this.maintenance = maintenance;
        this.photoURL = urlPhoto;
        this.prereqTech = prereqTech;
        this.Combat = combat;
        this.id = id;
        this.Unit_Type = unit_Type;
    }

    public int getCombat() {
        return Combat;
    }

    public void setCombat(int combat) {
        Combat = combat;
    }

    public int getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(int maintenance) {
        this.maintenance = maintenance;
    }

    public String getPrereqTech() {
        return prereqTech;
    }

    public void setPrereqTech(String prereqTech) {
        this.prereqTech = prereqTech;
    }

    public String getUnit_Type() {
        return Unit_Type;
    }

    public void setUnit_Type(String unit_Type) {
        Unit_Type = unit_Type;
    }

    public Units_cvilianDto() {
    }

    public Units_cvilianDto(String name, String namePhoto, String nameMod, String description, String author, Long id, int cost, int baseMoves, String unit_type, byte[] photoURL) {
        this.name = name;
        this.namePhoto = namePhoto;
        this.nameMod = nameMod;
        this.description = description;
        this.author = author;
        this.Unit_Type = unit_type;
        this.id = id;
        this.cost = cost;
        this.baseMoves = baseMoves;
        this.photoURL = photoURL;
    }

    public byte[] getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(byte[] photoURL) {
        this.photoURL = photoURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNamePhoto() {
        return namePhoto;
    }

    public void setNamePhoto(String namePhoto) {
        this.namePhoto = namePhoto;
    }

    public String getNameMod() {
        return nameMod;
    }

    public void setNameMod(String nameMod) {
        this.nameMod = nameMod;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getBaseMoves() {
        return baseMoves;
    }

    public void setBaseMoves(int baseMoves) {
        this.baseMoves = baseMoves;
    }
}
