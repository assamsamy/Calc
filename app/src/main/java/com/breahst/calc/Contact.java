package com.breahst.calc;

public class Contact {
    private int id;
    private String nom, numero;

    public Contact(int id, String nom, String numero) {
        this.id = id;
        this.nom = nom;
        this.numero = numero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }
    public String toString(){
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
