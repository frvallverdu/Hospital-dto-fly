package com.hospital_vm.Hospital_vm.service;

import com.hospital_vm.Hospital_vm.model.ficha_paciente;
import com.hospital_vm.Hospital_vm.repository.FichaPacienteRepository;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional

public class FichaService {
    @Autowired
    private FichaPacienteRepository fechaRepository;

    public List<ficha_paciente> findAll(){
        return fechaRepository.findAll();
    }
    public ficha_paciente findById(Integer id){
        return fechaRepository.findById(id).get();
    }
    public ficha_paciente save(ficha_paciente ficha_paciente){
        return fechaRepository.save(ficha_paciente);
    }
    public void delete(Integer id){
        fechaRepository.deleteById(id);
    }
}
