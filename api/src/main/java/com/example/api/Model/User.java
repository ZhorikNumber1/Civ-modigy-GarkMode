package com.example.api.Model;

import jakarta.persistence.*;
import org.springframework.http.HttpStatus;

@Entity
@Table(name = "Users")
public class User {
    public  User(){

    }
    public User(String first_name, String last_Name, String nickname, String nmberPhone, String password) {
        super();
        First_name = first_name;
        Last_Name = last_Name;
        Nickname = nickname;
        NmberPhone = nmberPhone;
        Password = password;
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
    @Column(name = "Password")
    private String Password;


    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }


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
