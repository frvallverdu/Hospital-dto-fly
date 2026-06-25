package com.hospital_vm.Hospital_vm.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.time.LocalDate;
import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name = "paciente")
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique=true, length = 13, nullable = false)
    @NotBlank(message = "El RUN no puede ser nulo")
    private String run;

    @Column(nullable = false)
    @NotBlank(message = "El nombre no puede ser nulo")
    private String nombres;

    @Column(nullable = false)
    @NotBlank(message = "El apellido no puede ser nulo")
    private String apellidos;

    @Column(nullable=true)
    private LocalDate fechaNacimiento;

    @Column(nullable=false)
    @NotBlank(message = "El correo no puede ser nulo")
    private String correo;

    @ManyToOne
    @JoinColumn(name = "id_tipo",nullable = false)
    private tipo_usuario id_tipo;

    @OneToOne(mappedBy = "paciente")
    private ficha_paciente ficha_paciente;

    @OneToMany(mappedBy = "paciente")
    private List<atencion> atenciones;


}
