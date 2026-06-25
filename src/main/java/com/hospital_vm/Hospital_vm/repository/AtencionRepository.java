package com.hospital_vm.Hospital_vm.repository;

import com.hospital_vm.Hospital_vm.model.atencion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;


import java.util.List;
import java.time.LocalDate;



@Repository
public interface AtencionRepository extends JpaRepository<atencion, Integer>{
    List<atencion> findByPacienteId(Integer id);
    List<atencion> findByMedicoId(Integer id);
    @Query(value = "SELECT t.nombre, SUM(a.costo) FROM atencion a JOIN paciente p ON a.id_paciente = p.id JOIN tipo_usuario t ON p.id_tipo = t.id GROUP BY t.nombre", nativeQuery = true)
    List<Object[]> obtenerCostosAgrupadosPorTipo();
    List<atencion> findByFechaAtencionOrderByHoraAtencionAsc(LocalDate fecha);

}
