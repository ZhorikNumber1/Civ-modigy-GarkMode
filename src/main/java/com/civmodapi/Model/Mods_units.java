package com.civmodapi.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "mods_units")
public class Mods_units {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "unit_type", columnDefinition = "VARCHAR(255) DEFAULT '-1'")
    private String UnitType;
    @Column(name = "name_photo", columnDefinition = "VARCHAR(255) DEFAULT '-1'")
    private String NamePhoto;
    @Column(name = "cost", columnDefinition = "int default -1")
    private int cost;
    @Column(name = "base_moves", columnDefinition = "int default -1")
    private int baseMoves;
    @Column(name = "maintenance", columnDefinition = "int default -1")
    private int maintenance;
    @Column(name = "Name", columnDefinition = "VARCHAR(255) DEFAULT '-1'")
    private String name;
    @Column(name = "description", columnDefinition = "VARCHAR(255) DEFAULT '-1'")
    private String description;
    @Column(name = "prereq_tech", columnDefinition = "VARCHAR(255) DEFAULT '-1'")
    private String PrereqTech;
    @Column(name = "name_mod")
    private String NameMod;
    @Column(name = "author")
    private String Author;
    private int combat;

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getNameMod() {
        return NameMod;
    }

    public void setNameMod(String nameMod) {
        NameMod = nameMod;
    }

    public Mods_units() {
    }

    public Mods_units(Long id, String unitType, String namePhoto, int cost, int baseMoves, int maintenance, String name, String description, String prereqTech, String NameMod, String Author, int combat) {
        this.id = id;
        UnitType = unitType;
        NamePhoto = namePhoto;
        this.cost = cost;
        this.baseMoves = baseMoves;
        this.maintenance = maintenance;
        this.name = name;
        this.description = description;
        PrereqTech = prereqTech;
        this.NameMod = NameMod;
        this.Author = Author;
        this.combat = combat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUnitType() {
        return UnitType;
    }

    public void setUnitType(String unitType) {
        UnitType = unitType;
    }

    public String getNamePhoto() {
        return NamePhoto;
    }

    public void setNamePhoto(String namePhoto) {
        NamePhoto = namePhoto;
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

    public int getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(int maintenance) {
        this.maintenance = maintenance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrereqTech() {
        return PrereqTech;
    }

    public void setPrereqTech(String prereqTech) {
        PrereqTech = prereqTech;
    }

    public int getCombat() {
        return combat;
    }

    public void setCombat(int combat) {
        this.combat = combat;
    }
}
