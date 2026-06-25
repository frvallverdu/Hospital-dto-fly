package com.hospital_vm.Hospital_vm.controller;

import com.hospital_vm.Hospital_vm.dto.AtencionDTO;
import com.hospital_vm.Hospital_vm.dto.AtencionMapper;
import com.hospital_vm.Hospital_vm.model.Medico;
import com.hospital_vm.Hospital_vm.model.Paciente;
import com.hospital_vm.Hospital_vm.model.atencion;
import com.hospital_vm.Hospital_vm.service.AtencionService;
import com.hospital_vm.Hospital_vm.service.MedicoService;
import com.hospital_vm.Hospital_vm.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/atenciones")
public class AtencionController {

    @Autowired
    private AtencionService atencionService;

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private MedicoService medicoService;

    @Autowired
    private AtencionMapper atencionMapper;

    @GetMapping
    public ResponseEntity<List<AtencionDTO>> listar() {
        List<AtencionDTO> atenciones = atencionService.findAll()
                .stream().map(atencionMapper::toDTO).toList();
        if (atenciones.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(atenciones);
    }

    @PostMapping
    public ResponseEntity<AtencionDTO> guardar(@Valid @RequestBody AtencionDTO dto) {
        Paciente paciente = pacienteService.findById(dto.getIdPaciente());
        Medico medico = medicoService.findById(dto.getIdMedico());
        atencion saved = atencionService.save(atencionMapper.toEntity(dto, paciente, medico));
        return ResponseEntity.status(HttpStatus.CREATED).body(atencionMapper.toDTO(saved));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtencionDTO> buscar(@PathVariable Integer id) {
        try {
            atencion ate = atencionService.findById(id);
            return ResponseEntity.ok(atencionMapper.toDTO(ate));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<AtencionDTO> actualizar(@PathVariable Integer id,
                                                  @Valid @RequestBody AtencionDTO dto) {
        try {
            atencion existing = atencionService.findById(id);
            Paciente paciente = pacienteService.findById(dto.getIdPaciente());
            Medico medico = medicoService.findById(dto.getIdMedico());
            existing.setFechaAtencion(dto.getFechaAtencion());
            existing.setHoraAtencion(dto.getHoraAtencion());
            existing.setCosto(dto.getCosto());
            existing.setPaciente(paciente);
            existing.setMedico(medico);
            existing.setComentario(dto.getComentario());
            atencionService.save(existing);
            return ResponseEntity.ok(atencionMapper.toDTO(existing));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        try {
            atencionService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/paciente/{id}")
    public ResponseEntity<List<AtencionDTO>> obtenerAtencionesPorPaciente(@PathVariable Integer id) {
        List<AtencionDTO> atenciones = atencionService.listarPorPaciente(id)
                .stream().map(atencionMapper::toDTO).toList();
        if (atenciones.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(atenciones);
    }

    @GetMapping("/medico/{id}")
    public ResponseEntity<List<AtencionDTO>> obtenerAtencionesPorMedico(@PathVariable Integer id) {
        List<AtencionDTO> atenciones = atencionService.listarPorMedico(id)
                .stream().map(atencionMapper::toDTO).toList();
        if (atenciones.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(atenciones);
    }

    @GetMapping("/reportes/costos-por-tipo")
    public ResponseEntity<List<Object[]>> listarCostosAgrupados() {
        List<Object[]> reporte = atencionService.obtenerCostosPorTipo();
        if (reporte.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(reporte);
    }

    @GetMapping("/reporte/fecha/{fecha}")
    public ResponseEntity<List<AtencionDTO>> obtenerAtencionesPorFecha(@PathVariable LocalDate fecha) {
        List<AtencionDTO> reporte = atencionService.listarPorFecha(fecha)
                .stream().map(atencionMapper::toDTO).toList();
        if (reporte.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(reporte);
    }
}
