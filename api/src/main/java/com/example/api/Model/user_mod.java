package com.example.api.Model;

import jakarta.persistence.*;

@Table(name = "users_mod")
public class user_mod {
    public user_mod(long id, String mod_id, String route_to_mod) {
        this.id = id;
        this.mod_id = mod_id;
        this.route_to_mod = route_to_mod;
    }

    public user_mod() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "mod_id")
    private String mod_id;
    @Column(name = "route_to_mod")
    private String route_to_mod;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMod_id() {
        return mod_id;
    }

    public void setMod_id(String mod_id) {
        this.mod_id = mod_id;
    }

    public String getRoute_to_mod() {
        return route_to_mod;
    }

    public void setRoute_to_mod(String route_to_mod) {
        this.route_to_mod = route_to_mod;
    }
}
