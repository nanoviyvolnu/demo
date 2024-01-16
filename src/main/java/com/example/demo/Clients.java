package com.example.demo;

import jakarta.persistence.*;

@Entity
@Table(name = "clients")
public class Clients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name_client")
    private String nameClient;

    @Column(name = "surname_client")
    private String surnameClient;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public String getSurnameClient() {
        return surnameClient;
    }

    public void setSurnameClient(String surnameClient) {
        this.surnameClient = surnameClient;
    }
}
