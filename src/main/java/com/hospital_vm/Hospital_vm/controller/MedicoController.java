package com.hospital_vm.Hospital_vm.controller;

import com.hospital_vm.Hospital_vm.dto.MedicoDTO;
import com.hospital_vm.Hospital_vm.dto.MedicoMapper;
import com.hospital_vm.Hospital_vm.model.Medico;
import com.hospital_vm.Hospital_vm.service.MedicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @Autowired
    private MedicoMapper medicoMapper;

    @GetMapping
    public ResponseEntity<List<MedicoDTO>> listar() {
        List<MedicoDTO> medicos = medicoService.findAll()
                .stream().map(medicoMapper::toDTO).toList();
        if (medicos.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(medicos);
    }

    @PostMapping
    public ResponseEntity<MedicoDTO> guardar(@Valid @RequestBody MedicoDTO dto) {
        Medico saved = medicoService.save(medicoMapper.toEntity(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(medicoMapper.toDTO(saved));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicoDTO> buscar(@PathVariable Integer id) {
        try {
            Medico medico = medicoService.findById(id);
            return ResponseEntity.ok(medicoMapper.toDTO(medico));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicoDTO> actualizar(@PathVariable Integer id,
                                                @Valid @RequestBody MedicoDTO dto) {
        try {
            Medico existing = medicoService.findById(id);
            existing.setRun_medico(dto.getRun_medico());
            existing.setNombre_completo(dto.getNombre_completo());
            existing.setEspecialidad(dto.getEspecialidad());
            existing.setJefe_turno(dto.getJefe_turno());
            medicoService.save(existing);
            return ResponseEntity.ok(medicoMapper.toDTO(existing));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        try {
            medicoService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/medico-y-especialidad")
    public ResponseEntity<List<Object[]>> listarMedicoyEspecialidad() {
        List<Object[]> medicos = medicoService.listarMedicoyEspecialidad();
        if (medicos.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(medicos);
    }
}
