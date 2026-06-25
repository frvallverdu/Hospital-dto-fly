package com.hospital_vm.Hospital_vm.repository;

import com.hospital_vm.Hospital_vm.model.Medico;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer>{
    @Query(value = "Select m.run_medico,m.nombre_completo, m.especialidad from medico m ", nativeQuery = true)
    List<Object[]> findAllMedicosConEspecialidad();

}

