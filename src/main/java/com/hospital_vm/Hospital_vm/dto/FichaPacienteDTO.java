package com.hospital_vm.Hospital_vm.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FichaPacienteDTO {
    private Integer id;

    @NotNull(message = "El id del paciente es obligatorio")
    private Integer idPaciente;

    @NotBlank(message = "El dato no puede ser nulo")
    @Size(max = 100)
    private String datos_personales_1;

    @NotBlank(message = "El dato no puede ser nulo")
    @Size(max = 100)
    private String datos_personales_2;

    @NotBlank(message = "El dato no puede ser nulo")
    @Size(max = 100)
    private String datos_personales_3;

    @NotBlank(message = "El dato no puede ser nulo")
    @Size(max = 100)
    private String datos_personales_4;

    @NotBlank(message = "El dato no puede ser nulo")
    @Size(max = 100)
    private String datos_personales_5;
}
