package com.hospital_vm.Hospital_vm.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PacienteDTO {
    private Integer id;

    @NotBlank(message = "El RUN no puede ser nulo")
    @Size(max = 13, message = "El RUN no puede superar 13 caracteres")
    private String run;

    @NotBlank(message = "El nombre no puede ser nulo")
    private String nombres;

    @NotBlank(message = "El apellido no puede ser nulo")
    private String apellidos;

    private LocalDate fechaNacimiento;

    @NotBlank(message = "El correo no puede ser nulo")
    private String correo;

    @NotNull(message = "El tipo de usuario es obligatorio")
    private Integer idTipo;

    private String tipoNombre;
}
