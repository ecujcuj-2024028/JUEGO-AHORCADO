package com.leonelcujcuj.ahorcado.model;

import jakarta.persistence.*;

@Entity
@Table(name = "palabras")
public class Palabra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_palabra")
    private Integer codigoPalabra;

    @Column(name = "nombre")
    private String nombre;

    @Column(name= "pista_1")
    private String pista1;

    @Column(name= "pista_2")
    private String pista2;

    @Column(name= "pista_3")
    private String pista3;

    @Column(name = "imagen")
    private String imagen;

    public Palabra(Integer codigoPalabra, String nombre, String pista1, String pista2, String pista3, String imagen) {
        this.codigoPalabra = codigoPalabra;
        this.nombre = nombre;
        this.pista1 = pista1;
        this.pista2 = pista2;
        this.pista3 = pista3;
        this.imagen = imagen;
    }

    public Palabra() {}

    public Integer getCodigoPalabra() {
        return codigoPalabra;
    }

    public void setCodigoPalabra(Integer codigoPalabra) {
        this.codigoPalabra = codigoPalabra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPista1() {
        return pista1;
    }

    public void setPista1(String pista1) {
        this.pista1 = pista1;
    }

    public String getPista2() {
        return pista2;
    }

    public void setPista2(String pista2) {
        this.pista2 = pista2;
    }

    public String getPista3() {
        return pista3;
    }

    public void setPista3(String pista3) {
        this.pista3 = pista3;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
