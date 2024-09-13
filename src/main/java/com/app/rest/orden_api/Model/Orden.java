package com.app.rest.orden_api.Model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Ordenes")
public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;

    @Column(name = "hora_creacion")
    private LocalTime horaCreacion;

    @Column(name = "total")
    private int total;

    @OneToMany(mappedBy = "orden", cascade = CascadeType.ALL , fetch = FetchType.LAZY, orphanRemoval = true  )
    private List<DetalleOrden> detalleOrden;

    


    
}
