package com.example.api.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Unit")
public class Unit {
    public Unit() {

    }

    public Unit(String name, String combat, String basemoves, String cost, String prereqTech) {
        super();
        Name = name;
        Combat = combat;
        BaseMoves = basemoves;
        Cost = cost;
        PrereqTech = prereqTech;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "Name")
    private String Name;
    @Column(name = "Melee_Damage")
    private String Combat;
    @Column(name = "BaseMoves")
    private String BaseMoves;
    @Column(name = "Cost")
    private String Cost;
    @Column(name = "Unit_Type")
    private String UnitType;
    @Column(name = "Prereq_Tech")
    private String PrereqTech;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCombat() {
        return Combat;
    }

    public void setCombat(String combat) {
        Combat = combat;
    }

    public String getBaseMoves() {
        return BaseMoves;
    }

    public void setBaseMoves(String baseMoves) {
        BaseMoves = baseMoves;
    }

    public String getCost() {
        return Cost;
    }

    public void setCost(String cost) {
        Cost = cost;
    }

    public String getUnitType() {
        return UnitType;
    }

    public void setUnitType(String unitType) {
        UnitType = unitType;
    }

    public String getPrereqTech() {
        return PrereqTech;
    }

    public void setPrereqTech(String prereqTech) {
        PrereqTech = prereqTech;
    }
}

