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
public class MedicoDTO {
    private Integer id;

    @NotBlank(message = "El RUN del medico no puede ser nulo")
    @Size(max = 10, message = "El RUN no puede superar 10 caracteres")
    private String run_medico;

    @NotBlank(message = "El nombre no puede ser nulo")
    private String nombre_completo;

    @Size(max = 100, message = "La especialidad no puede superar 100 caracteres")
    private String especialidad;

    @NotNull(message = "El jefe de turno no puede ser nulo")
    private Character jefe_turno;
}
