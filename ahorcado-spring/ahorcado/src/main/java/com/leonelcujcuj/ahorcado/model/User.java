package com.leonelcujcuj.ahorcado.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "usuarios")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_usuario")
    private Integer codigoUsuario;

    @Column(name = "nombre_usuario")
    private String nombreUsuario;

    @Column(name = "correo")
    private String correo;

    @Column(name = "fecha_registro")
    private Timestamp fechaRegistro;

    @Column(name = "password")
    private String password;


    public User() {
    }


    public User(Integer codigoUsuario, String nombreUsuario, String correo, Timestamp fechaRegistro, String password) {
        this.codigoUsuario = codigoUsuario;
        this.nombreUsuario = nombreUsuario;
        this.correo = correo;
        this.fechaRegistro = fechaRegistro;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Timestamp getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Timestamp fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

}
