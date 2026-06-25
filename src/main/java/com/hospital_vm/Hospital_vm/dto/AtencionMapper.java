package com.hospital_vm.Hospital_vm.dto;

import com.hospital_vm.Hospital_vm.model.Medico;
import com.hospital_vm.Hospital_vm.model.Paciente;
import com.hospital_vm.Hospital_vm.model.atencion;
import org.springframework.stereotype.Component;

@Component
public class AtencionMapper {

    public AtencionDTO toDTO(atencion ate) {
        if (ate == null) return null;
        AtencionDTO dto = new AtencionDTO();
        dto.setId(ate.getId());
        dto.setFechaAtencion(ate.getFechaAtencion());
        dto.setHoraAtencion(ate.getHoraAtencion());
        dto.setCosto(ate.getCosto());
        dto.setComentario(ate.getComentario());
        if (ate.getPaciente() != null) {
            dto.setIdPaciente(ate.getPaciente().getId());
            dto.setNombrePaciente(ate.getPaciente().getNombres() + " " + ate.getPaciente().getApellidos());
        }
        if (ate.getMedico() != null) {
            dto.setIdMedico(ate.getMedico().getId());
            dto.setNombreMedico(ate.getMedico().getNombre_completo());
        }
        return dto;
    }

    public atencion toEntity(AtencionDTO dto, Paciente paciente, Medico medico) {
        if (dto == null) return null;
        atencion ate = new atencion();
        ate.setId(dto.getId());
        ate.setFechaAtencion(dto.getFechaAtencion());
        ate.setHoraAtencion(dto.getHoraAtencion());
        ate.setCosto(dto.getCosto());
        ate.setComentario(dto.getComentario());
        ate.setPaciente(paciente);
        ate.setMedico(medico);
        return ate;
    }
}
