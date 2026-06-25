package com.hospital_vm.Hospital_vm.repository;
import com.hospital_vm.Hospital_vm.model.tipo_usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoUsuarioRepository extends JpaRepository<tipo_usuario, Integer>{

}

