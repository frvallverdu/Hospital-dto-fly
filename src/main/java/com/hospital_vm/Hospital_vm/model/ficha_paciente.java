package com.hospital_vm.Hospital_vm.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;
@Entity
@Table(name = "ficha_paciente")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ficha_paciente {
    @Id
    private Integer id;

    @OneToOne
    @MapsId
    @JoinColumn(name="id_paciente")
    private Paciente paciente;

    @Column(length = 100,nullable=false)
    @NotBlank(message = "El dato no puede ser nulo")
    private String datos_personales_1;

    @Column(length = 100,nullable=false)
    @NotBlank(message = "El dato no puede ser nulo")
    private String datos_personales_2;

    @Column(length = 100,nullable=false)
    @NotBlank(message = "El dato no puede ser nulo")
    private String datos_personales_3;

    @Column(length = 100,nullable=false)
    @NotBlank(message = "El dato no puede ser nulo")
    private String datos_personales_4;

    @Column(length = 100,nullable=false)
    @NotBlank(message = "El dato no puede ser nulo")
    private String datos_personales_5;
}
