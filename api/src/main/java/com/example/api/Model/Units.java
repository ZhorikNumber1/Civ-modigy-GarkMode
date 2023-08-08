package com.example.api.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Units")
public class Units {
    public Units() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public Units(String unitType, int cost) {
        UnitType = unitType;
        this.cost = cost;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @Column(name = "unit_type")
    private String UnitType;

    @Column(name = "cost")
    private int cost;
/*

    @Column(name = "BaseMoves")
    private int baseMoves;

    @Column(name = "BaseSightRange")
    private int baseSightRange;

    @Column(name = "ZoneOfControl")
    private boolean zoneOfControl;

    @Column(name = "Domain")
    private String domain;

    @Column(name = "FormationClass")
    private String formationClass;

    @Column(name = "FoundCity")
    private boolean foundCity;

    @Column(name = "PopulationCost")
    private int populationCost;

    @Column(name = "PrereqPopulation")
    private int prereqPopulation;

    @Column(name = "AdvisorType")
    private String advisorType;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;

    @Column(name = "CanCapture")
    private boolean canCapture;

    @Column(name = "CostProgressionModel")
    private String costProgressionModel;

    @Column(name = "CostProgressionParam1")
    private double costProgressionParam1;

    @Column(name = "PurchaseYield")
    private int purchaseYield;

    @Column(name = "PseudoYieldType")
    private String pseudoYieldType;
*/



}