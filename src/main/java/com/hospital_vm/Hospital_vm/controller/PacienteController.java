package com.hospital_vm.Hospital_vm.controller;

import com.hospital_vm.Hospital_vm.dto.PacienteDTO;
import com.hospital_vm.Hospital_vm.dto.PacienteMapper;
import com.hospital_vm.Hospital_vm.model.Paciente;
import com.hospital_vm.Hospital_vm.model.tipo_usuario;
import com.hospital_vm.Hospital_vm.service.PacienteService;
import com.hospital_vm.Hospital_vm.service.TipoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private TipoService tipoService;

    @Autowired
    private PacienteMapper pacienteMapper;

    @GetMapping
    public ResponseEntity<List<PacienteDTO>> listar() {
        List<PacienteDTO> pacientes = pacienteService.findAll()
                .stream().map(pacienteMapper::toDTO).toList();
        if (pacientes.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(pacientes);
    }

    @PostMapping
    public ResponseEntity<PacienteDTO> guardar(@Valid @RequestBody PacienteDTO dto) {
        tipo_usuario tipo = tipoService.findById(dto.getIdTipo());
        Paciente saved = pacienteService.save(pacienteMapper.toEntity(dto, tipo));
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteMapper.toDTO(saved));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> buscar(@PathVariable Integer id) {
        try {
            Paciente paciente = pacienteService.findById(id);
            return ResponseEntity.ok(pacienteMapper.toDTO(paciente));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteDTO> actualizar(@PathVariable Integer id,
                                                  @Valid @RequestBody PacienteDTO dto) {
        try {
            Paciente existing = pacienteService.findById(id);
            tipo_usuario tipo = tipoService.findById(dto.getIdTipo());
            existing.setRun(dto.getRun());
            existing.setNombres(dto.getNombres());
            existing.setApellidos(dto.getApellidos());
            existing.setFechaNacimiento(dto.getFechaNacimiento());
            existing.setCorreo(dto.getCorreo());
            existing.setId_tipo(tipo);
            pacienteService.save(existing);
            return ResponseEntity.ok(pacienteMapper.toDTO(existing));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        try {
            pacienteService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/historial")
    public ResponseEntity<PacienteDTO> obtenerHistorial(@PathVariable Integer id) {
        try {
            Paciente historial = pacienteService.obtenerHistorialCompleto(id);
            return ResponseEntity.ok(pacienteMapper.toDTO(historial));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
