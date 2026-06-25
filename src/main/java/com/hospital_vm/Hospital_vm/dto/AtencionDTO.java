package com.hospital_vm.Hospital_vm.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AtencionDTO {
    private Integer id;

    @NotNull(message = "La fecha no puede ser nula")
    private LocalDate fechaAtencion;

    @NotNull(message = "La hora no puede ser nula")
    private LocalTime horaAtencion;

    @NotNull(message = "El costo no puede ser nulo")
    @DecimalMin(value = "0.0", inclusive = false, message = "El costo debe ser mayor a 0")
    private BigDecimal costo;

    @NotNull(message = "El paciente es obligatorio")
    private Integer idPaciente;

    private String nombrePaciente;

    @NotNull(message = "El medico es obligatorio")
    private Integer idMedico;

    private String nombreMedico;

    private String comentario;
}
