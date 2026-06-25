package com.hospital_vm.Hospital_vm.dto;

import com.hospital_vm.Hospital_vm.model.tipo_usuario;
import org.springframework.stereotype.Component;

@Component
public class TipoUsuarioMapper {

    public TipoUsuarioDTO toDTO(tipo_usuario tipo) {
        if (tipo == null) return null;
        TipoUsuarioDTO dto = new TipoUsuarioDTO();
        dto.setId(tipo.getId());
        dto.setNombre(tipo.getNombre());
        return dto;
    }

    public tipo_usuario toEntity(TipoUsuarioDTO dto) {
        if (dto == null) return null;
        tipo_usuario tipo = new tipo_usuario();
        tipo.setId(dto.getId());
        tipo.setNombre(dto.getNombre());
        return tipo;
    }
}
