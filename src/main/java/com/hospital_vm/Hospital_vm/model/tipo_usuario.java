package com.hospital_vm.Hospital_vm.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "tipo_usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class tipo_usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 40,nullable = false)
    @NotBlank(message = "El nombre no puede ser nulo")
    private String nombre;

    @OneToMany(mappedBy = "id_tipo")
    private List<Paciente> pacientes;
}
