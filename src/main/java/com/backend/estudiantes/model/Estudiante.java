package com.backend.estudiantes.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "estudiante")
@Data
public class Estudiante {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private  Long id;

   @OneToOne
   @JoinColumn(name = "usuario_id", nullable = false)
   private Usuario usuario;

   @Column(name="codigo_estudiantil" ,nullable = false, unique = true, length = 10)
   private String codigoEstudiantil;

   @Column(name = "horas_acumuladas", nullable = false)
   private Integer horasAcumuladas;

   @Column(nullable = false, length = 100)
   private String programaAcademico;

   @Column(nullable = false)
   private Integer semestre;

   @Column(nullable = false)
   @Enumerated(EnumType.STRING)
   private EstadoEstudiante estado = EstadoEstudiante.ACTIVO;

//   private String getNombreCompleto(){
//      return usuario.getNombre();
//   }

}
