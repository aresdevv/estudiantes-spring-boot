package com.backend.estudiantes.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "usuario")
@Data
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role rol;

    @Column(nullable = false, columnDefinition = "boolean default true")
    private Boolean activo = true;

    @OneToOne
    private Estudiante estudiante;


    public Usuario(String nombre, String apellido, String email, String password, Role rol) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.rol = rol;
    }

    public Usuario() {

    }

    //Devolver los permisos del usuario basado en roles.
    //ESTUDIANTE - INSTRUCTOR - ADMIN}
    //ROLE_ESTUDIANTE
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    //email -> username ( para que spring security puedae entender)
    @Override
    public String getUsername() {
        return "";
    }

    //dando sello que esto no a expirado.
    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    //esta no estas bloqueada
    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    //las credenciales no expiradas
    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    //cuenta activa
    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
