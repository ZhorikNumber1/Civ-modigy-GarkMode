package com.example.api.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Units")
public class Units {
    public Units() {

    }

    public Units(long id, String  namePhoto,String unitType, int cost, int baseMoves, int baseSightRange, boolean zoneOfControl, String domain, String formationClass, boolean foundCity, int populationCost, int prereqPopulation, String advisorType, String name, String description, boolean canCapture, String costProgressionModel, double costProgressionParam1, int purchaseYield, String pseudoYieldType) {
        this.id = id;
        UnitType = unitType;
        this.NamePhoto = namePhoto;
/*        this.cost = cost;
        this.baseMoves = baseMoves;
        this.baseSightRange = baseSightRange;
        this.zoneOfControl = zoneOfControl;
        this.domain = domain;
        this.formationClass = formationClass;
        this.foundCity = foundCity;
        this.populationCost = populationCost;
        this.prereqPopulation = prereqPopulation;
        this.advisorType = advisorType;*/
        this.name = name;
        this.description = description;
/*        this.canCapture = canCapture;
        this.costProgressionModel = costProgressionModel;
        this.costProgressionParam1 = costProgressionParam1;
        this.purchaseYield = purchaseYield;
        this.pseudoYieldType = pseudoYieldType;*/
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "unit_type", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT 'default_value'")
    private String UnitType;
    @Column(name = "name_photo", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT 'no_photo'")
    private String NamePhoto;
  /*  @Column(name = "cost")
    private int cost;

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
*/
    @Column(name = "Name")
    private String name;


    @Column(name = "Description", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT 'no_description'")
    private String description;
/*
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

    public String getNamePhoto() {
        return NamePhoto;
    }

    public void setNamePhoto(String namePhoto) {
        NamePhoto = namePhoto;
    }

    /* public long getId() {
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

        public int getBaseMoves() {
            return baseMoves;
        }

        public void setBaseMoves(int baseMoves) {
            this.baseMoves = baseMoves;
        }

        public int getBaseSightRange() {
            return baseSightRange;
        }

        public void setBaseSightRange(int baseSightRange) {
            this.baseSightRange = baseSightRange;
        }

        public boolean isZoneOfControl() {
            return zoneOfControl;
        }

        public void setZoneOfControl(boolean zoneOfControl) {
            this.zoneOfControl = zoneOfControl;
        }

        public String getDomain() {
            return domain;
        }

        public void setDomain(String domain) {
            this.domain = domain;
        }

        public String getFormationClass() {
            return formationClass;
        }

        public void setFormationClass(String formationClass) {
            this.formationClass = formationClass;
        }

        public boolean isFoundCity() {
            return foundCity;
        }

        public void setFoundCity(boolean foundCity) {
            this.foundCity = foundCity;
        }

        public int getPopulationCost() {
            return populationCost;
        }

        public void setPopulationCost(int populationCost) {
            this.populationCost = populationCost;
        }

        public int getPrereqPopulation() {
            return prereqPopulation;
        }

        public void setPrereqPopulation(int prereqPopulation) {
            this.prereqPopulation = prereqPopulation;
        }

        public String getAdvisorType() {
            return advisorType;
        }

        public void setAdvisorType(String advisorType) {
            this.advisorType = advisorType;
        }
    */
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
/*
    public boolean isCanCapture() {
        return canCapture;
    }

    public void setCanCapture(boolean canCapture) {
        this.canCapture = canCapture;
    }

    public String getCostProgressionModel() {
        return costProgressionModel;
    }

    public void setCostProgressionModel(String costProgressionModel) {
        this.costProgressionModel = costProgressionModel;
    }

    public double getCostProgressionParam1() {
        return costProgressionParam1;
    }

    public void setCostProgressionParam1(double costProgressionParam1) {
        this.costProgressionParam1 = costProgressionParam1;
    }

    public int getPurchaseYield() {
        return purchaseYield;
    }

    public void setPurchaseYield(int purchaseYield) {
        this.purchaseYield = purchaseYield;
    }

    public String getPseudoYieldType() {
        return pseudoYieldType;
    }

    public void setPseudoYieldType(String pseudoYieldType) {
        this.pseudoYieldType = pseudoYieldType;
    }*/
}