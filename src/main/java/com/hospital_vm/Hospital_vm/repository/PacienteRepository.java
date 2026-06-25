package com.hospital_vm.Hospital_vm.repository;

import com.hospital_vm.Hospital_vm.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer>{
    
}

