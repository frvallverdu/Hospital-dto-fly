package com.hospital_vm.Hospital_vm.dto;

import com.hospital_vm.Hospital_vm.model.Paciente;
import com.hospital_vm.Hospital_vm.model.tipo_usuario;
import org.springframework.stereotype.Component;

@Component
public class PacienteMapper {

    public PacienteDTO toDTO(Paciente paciente) {
        if (paciente == null) return null;
        PacienteDTO dto = new PacienteDTO();
        dto.setId(paciente.getId());
        dto.setRun(paciente.getRun());
        dto.setNombres(paciente.getNombres());
        dto.setApellidos(paciente.getApellidos());
        dto.setFechaNacimiento(paciente.getFechaNacimiento());
        dto.setCorreo(paciente.getCorreo());
        if (paciente.getId_tipo() != null) {
            dto.setIdTipo(paciente.getId_tipo().getId());
            dto.setTipoNombre(paciente.getId_tipo().getNombre());
        }
        return dto;
    }

    public Paciente toEntity(PacienteDTO dto, tipo_usuario tipo) {
        if (dto == null) return null;
        Paciente paciente = new Paciente();
        paciente.setId(dto.getId());
        paciente.setRun(dto.getRun());
        paciente.setNombres(dto.getNombres());
        paciente.setApellidos(dto.getApellidos());
        paciente.setFechaNacimiento(dto.getFechaNacimiento());
        paciente.setCorreo(dto.getCorreo());
        paciente.setId_tipo(tipo);
        return paciente;
    }
}
