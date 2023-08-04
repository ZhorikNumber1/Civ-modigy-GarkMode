package com.example.api.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Users")
public class User {
    public  User(){

    }
    public User(String first_name, String last_Name, String nickname, String nmberPhone) {
        super();
        First_name = first_name;
        Last_Name = last_Name;
        Nickname = nickname;
        NmberPhone = nmberPhone;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "First_name")
    private String First_name;
    @Column(name = "Last_Name")
    private String Last_Name;
    @Column(name = "Nickname")
    private String Nickname;
    @Column(name = "NmberPhone")
    private String NmberPhone;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return First_name;
    }

    public void setFirst_name(String first_name) {
        First_name = first_name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public void setLast_Name(String last_Name) {
        Last_Name = last_Name;
    }

    public String getNickname() {
        return Nickname;
    }

    public void setNickname(String nickname) {
        Nickname = nickname;
    }

    public String getNmberPhone() {
        return NmberPhone;
    }

    public void setNmberPhone(String nmberPhone) {
        NmberPhone = nmberPhone;
    }
}
