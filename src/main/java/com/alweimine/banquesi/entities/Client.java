package com.alweimine.banquesi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
/*this class is for every cilent*/
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codeClient;
    private String nomClient;
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private Collection<Compte> comptes;

    public Client(String nomClient) {
        this.nomClient = nomClient;
    }

    public Client() {
        super();
    }

    public Long getCodeClient() {
        return codeClient;
    }

    public void setCodeClient(Long codeClient) {
        this.codeClient = codeClient;
    }


    @JsonIgnore
    public Collection<Compte> getComptes() {
        return comptes;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public void setComptes(Collection<Compte> comptes) {
        this.comptes = comptes;
    }
    //this section is for git practice
    private Long test;  //c'est pour git learning
    private String ahmed ;
}
