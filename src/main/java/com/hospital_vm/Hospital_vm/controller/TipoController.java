package com.hospital_vm.Hospital_vm.controller;

import com.hospital_vm.Hospital_vm.dto.TipoUsuarioDTO;
import com.hospital_vm.Hospital_vm.dto.TipoUsuarioMapper;
import com.hospital_vm.Hospital_vm.model.tipo_usuario;
import com.hospital_vm.Hospital_vm.service.TipoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tipo-usuarios")
public class TipoController {

    @Autowired
    private TipoService tipoService;

    @Autowired
    private TipoUsuarioMapper tipoMapper;

    @GetMapping
    public ResponseEntity<List<TipoUsuarioDTO>> listar() {
        List<TipoUsuarioDTO> tipos = tipoService.findAll()
                .stream().map(tipoMapper::toDTO).toList();
        if (tipos.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(tipos);
    }

    @PostMapping
    public ResponseEntity<TipoUsuarioDTO> guardar(@Valid @RequestBody TipoUsuarioDTO dto) {
        tipo_usuario saved = tipoService.save(tipoMapper.toEntity(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(tipoMapper.toDTO(saved));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoUsuarioDTO> buscar(@PathVariable Integer id) {
        try {
            tipo_usuario tipo = tipoService.findById(id);
            return ResponseEntity.ok(tipoMapper.toDTO(tipo));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoUsuarioDTO> actualizar(@PathVariable Integer id,
                                                     @Valid @RequestBody TipoUsuarioDTO dto) {
        try {
            tipo_usuario existing = tipoService.findById(id);
            existing.setNombre(dto.getNombre());
            tipoService.save(existing);
            return ResponseEntity.ok(tipoMapper.toDTO(existing));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        try {
            tipoService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
