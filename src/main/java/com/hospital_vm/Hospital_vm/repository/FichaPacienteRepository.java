package com.hospital_vm.Hospital_vm.repository;

import com.hospital_vm.Hospital_vm.model.ficha_paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FichaPacienteRepository extends JpaRepository<ficha_paciente, Integer>{

}

