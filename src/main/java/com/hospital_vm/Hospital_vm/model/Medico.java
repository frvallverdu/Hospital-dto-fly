package com.hospital_vm.Hospital_vm.model;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "medico")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 10,nullable=false)
    @NotNull(message = "El RUN del medico no puede ser nulo")
    private String run_medico;

  
    @Column(nullable=false)
    @NotNull(message = "El nombre no puede ser nulo")
    private String nombre_completo;

    @Column(length = 100, nullable=true)
    private String especialidad;

    @Column(nullable=false)
    @NotNull(message = "El jefe no puede ser nulo")
    private Character jefe_turno;

    @OneToMany(mappedBy = "medico")
    private List<atencion> atenciones;
}

