package com.hospital_vm.Hospital_vm.dto;

import com.hospital_vm.Hospital_vm.model.Medico;
import org.springframework.stereotype.Component;

@Component
public class MedicoMapper {

    public MedicoDTO toDTO(Medico medico) {
        if (medico == null) return null;
        MedicoDTO dto = new MedicoDTO();
        dto.setId(medico.getId());
        dto.setRun_medico(medico.getRun_medico());
        dto.setNombre_completo(medico.getNombre_completo());
        dto.setEspecialidad(medico.getEspecialidad());
        dto.setJefe_turno(medico.getJefe_turno());
        return dto;
    }

    public Medico toEntity(MedicoDTO dto) {
        if (dto == null) return null;
        Medico medico = new Medico();
        medico.setId(dto.getId());
        medico.setRun_medico(dto.getRun_medico());
        medico.setNombre_completo(dto.getNombre_completo());
        medico.setEspecialidad(dto.getEspecialidad());
        medico.setJefe_turno(dto.getJefe_turno());
        return medico;
    }
}
