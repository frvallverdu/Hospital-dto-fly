package com.hospital_vm.Hospital_vm.controller;

import com.hospital_vm.Hospital_vm.dto.FichaPacienteDTO;
import com.hospital_vm.Hospital_vm.dto.FichaPacienteMapper;
import com.hospital_vm.Hospital_vm.model.Paciente;
import com.hospital_vm.Hospital_vm.model.ficha_paciente;
import com.hospital_vm.Hospital_vm.service.FichaService;
import com.hospital_vm.Hospital_vm.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ficha-pacientes")
public class FichaController {

    @Autowired
    private FichaService fichaService;

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private FichaPacienteMapper fichaMapper;

    @GetMapping
    public ResponseEntity<List<FichaPacienteDTO>> listar() {
        List<FichaPacienteDTO> fichas = fichaService.findAll()
                .stream().map(fichaMapper::toDTO).toList();
        if (fichas.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(fichas);
    }

    @PostMapping
    public ResponseEntity<FichaPacienteDTO> guardar(@Valid @RequestBody FichaPacienteDTO dto) {
        Paciente paciente = pacienteService.findById(dto.getIdPaciente());
        ficha_paciente saved = fichaService.save(fichaMapper.toEntity(dto, paciente));
        return ResponseEntity.status(HttpStatus.CREATED).body(fichaMapper.toDTO(saved));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FichaPacienteDTO> buscar(@PathVariable Integer id) {
        try {
            ficha_paciente ficha = fichaService.findById(id);
            return ResponseEntity.ok(fichaMapper.toDTO(ficha));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<FichaPacienteDTO> actualizar(@PathVariable Integer id,
                                                       @Valid @RequestBody FichaPacienteDTO dto) {
        try {
            ficha_paciente existing = fichaService.findById(id);
            existing.setDatos_personales_1(dto.getDatos_personales_1());
            existing.setDatos_personales_2(dto.getDatos_personales_2());
            existing.setDatos_personales_3(dto.getDatos_personales_3());
            existing.setDatos_personales_4(dto.getDatos_personales_4());
            existing.setDatos_personales_5(dto.getDatos_personales_5());
            fichaService.save(existing);
            return ResponseEntity.ok(fichaMapper.toDTO(existing));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        try {
            fichaService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
