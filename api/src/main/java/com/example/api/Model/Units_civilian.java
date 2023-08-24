package com.example.api.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Units_civilian")
public class Units_civilian {
    public Units_civilian() {

    }

    public Units_civilian(long id, String unitType, String namePhoto, int cost, int maintenance, int baseMoves, int combat, int baseSightRange, String advisorType, int rangedCombat, int range, String name, String description, int purchaseYield, String pseudoYieldType, String prereqTech) {
        this.id = id;
        UnitType = unitType;
        NamePhoto = namePhoto;
        this.cost = cost;
        this.maintenance = maintenance;
        this.baseMoves = baseMoves;
        this.name = name;
        this.description = description;
        PrereqTech = prereqTech;
        this.Combat = combat;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "unit_type", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT '-1'")
    private String UnitType;
    @Column(name = "name_photo", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT '-1'")
    private String NamePhoto;
    @Column(name = "cost", nullable = false, columnDefinition = "int default -1")
    private int cost;
    @Column(name = "base_moves", columnDefinition = "int default -1")
    private int baseMoves;
    @Column(name = "maintenance", columnDefinition = "int default -1")
    private int maintenance;
    @Column(name = "Name", columnDefinition = "VARCHAR(255) DEFAULT '-1'")
    private String name;
    @Column(name = "description", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT '-1'")
    private String description;
    @Column(name = "prereq_tech", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT '-1'")
    private String PrereqTech;
    @Column(name = "combat", columnDefinition = "int default -1")
    private int Combat;



    public int getCombat() {
        return Combat;
    }

    public void setCombat(int combat) {
        Combat = combat;
    }

    public String getUnitType() {
        return UnitType;
    }

    public void setUnitType(String unitType) {
        UnitType = unitType;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(int maintenance) {
        this.maintenance = maintenance;
    }

    public int getBaseMoves() {
        return baseMoves;
    }

    public void setBaseMoves(int baseMoves) {
        this.baseMoves = baseMoves;
    }


    public String getPrereqTech() {
        return PrereqTech;
    }

    public void setPrereqTech(String prereqTech) {
        PrereqTech = prereqTech;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNamePhoto() {
        return NamePhoto;
    }

    public void setNamePhoto(String namePhoto) {
        NamePhoto = namePhoto;
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

}