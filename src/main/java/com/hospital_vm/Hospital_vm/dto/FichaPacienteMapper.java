package com.hospital_vm.Hospital_vm.dto;

import com.hospital_vm.Hospital_vm.model.Paciente;
import com.hospital_vm.Hospital_vm.model.ficha_paciente;
import org.springframework.stereotype.Component;

@Component
public class FichaPacienteMapper {

    public FichaPacienteDTO toDTO(ficha_paciente ficha) {
        if (ficha == null) return null;
        FichaPacienteDTO dto = new FichaPacienteDTO();
        dto.setId(ficha.getId());
        if (ficha.getPaciente() != null) {
            dto.setIdPaciente(ficha.getPaciente().getId());
        }
        dto.setDatos_personales_1(ficha.getDatos_personales_1());
        dto.setDatos_personales_2(ficha.getDatos_personales_2());
        dto.setDatos_personales_3(ficha.getDatos_personales_3());
        dto.setDatos_personales_4(ficha.getDatos_personales_4());
        dto.setDatos_personales_5(ficha.getDatos_personales_5());
        return dto;
    }

    public ficha_paciente toEntity(FichaPacienteDTO dto, Paciente paciente) {
        if (dto == null) return null;
        ficha_paciente ficha = new ficha_paciente();
        ficha.setPaciente(paciente);
        ficha.setDatos_personales_1(dto.getDatos_personales_1());
        ficha.setDatos_personales_2(dto.getDatos_personales_2());
        ficha.setDatos_personales_3(dto.getDatos_personales_3());
        ficha.setDatos_personales_4(dto.getDatos_personales_4());
        ficha.setDatos_personales_5(dto.getDatos_personales_5());
        return ficha;
    }
}
