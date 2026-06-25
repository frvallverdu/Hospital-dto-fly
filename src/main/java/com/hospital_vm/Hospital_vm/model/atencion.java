package com.hospital_vm.Hospital_vm.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.time.LocalTime;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "atencion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class atencion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable=false)
    @NotNull(message = "La hora no puede ser nula")
    private LocalDate fechaAtencion;

  
    @Column(nullable=false)
    @NotNull(message = "La hora no puede ser nula")
    private LocalTime horaAtencion;

    @Column(precision = 10, scale = 2, nullable=false)
    @NotNull(message = "El costo no puede ser nulo")
    private BigDecimal costo;

    @ManyToOne
    @JoinColumn(name = "id_paciente",nullable=false)
    @NotNull(message = "El paciente es obligatorio")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "id_medico",nullable=false)
    @NotNull(message = "El medico es obligatorio")
    private Medico medico;


    @Column(length = 300,nullable=true)
    private String comentario;
    
}
