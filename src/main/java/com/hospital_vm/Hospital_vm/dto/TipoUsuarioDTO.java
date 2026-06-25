package com.hospital_vm.Hospital_vm.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoUsuarioDTO {
    private Integer id;

    @NotBlank(message = "El nombre no puede ser nulo")
    @Size(max = 40, message = "El nombre no puede superar 40 caracteres")
    private String nombre;
}
