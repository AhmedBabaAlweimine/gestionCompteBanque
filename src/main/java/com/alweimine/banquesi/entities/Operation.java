package com.alweimine.banquesi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype",
        discriminatorType = DiscriminatorType.STRING,length = 1)
@JsonTypeInfo(use= JsonTypeInfo.Id.NAME,include = JsonTypeInfo.As.PROPERTY,property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(name = "V",value = Versement.class),
        @JsonSubTypes.Type(name = "R",value = Retrait.class)
})
public class Operation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numeroOperation;
    private Date dateOperation;
    private double montanat;
    @ManyToOne
    @JoinColumn(name="CODE_CPTE")
    private Compte compte;
    @ManyToOne
    @JoinColumn(name="CODE_EMP")
    private Employe employe;

    public Operation(Date dateOperation, double montanat) {
        this.dateOperation = dateOperation;
        this.montanat = montanat;
    }

    public Operation(){
        super();
    }

    public Long getNumeroOperation() {
        return numeroOperation;
    }

    public void setNumeroOperation(Long numeroOperation) {
        this.numeroOperation = numeroOperation;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }

    public double getMontanat() {
        return montanat;
    }

    public void setMontanat(double montanat) {
        this.montanat = montanat;
    }
    @JsonIgnore
    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }
    @JsonIgnore
    public Employe getEmploye() {
        return employe;
    }
    @JsonSetter /*c'est pour dire au cas ou on veut l'ors de la creation de
               loperation si un object emloye existe il faut le prendre en consideration
               Mais ici on a pas besoin car au momment de créattion de l'operation on donne que le ID de l'employé et non pas l'object Employer*/
    public void setEmploye(Employe employe) {
        this.employe = employe;
    }
}
