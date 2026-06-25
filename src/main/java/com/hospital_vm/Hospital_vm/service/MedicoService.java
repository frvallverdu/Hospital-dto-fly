package com.hospital_vm.Hospital_vm.service;

import com.hospital_vm.Hospital_vm.model.Medico;
import com.hospital_vm.Hospital_vm.repository.MedicoRepository;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public class MedicoService {
    @Autowired
    private MedicoRepository medicoRepository;

    public List<Medico> findAll(){
        return medicoRepository.findAll();
    }
    public Medico findById(Integer id){
        return medicoRepository.findById(id).get();
    }
    public Medico save(Medico medico){
        return medicoRepository.save(medico);
    }
    public void delete(Integer id){
        medicoRepository.deleteById(id);
    }
    public List<Object[]> listarMedicoyEspecialidad(){
        return medicoRepository.findAllMedicosConEspecialidad();
    }
}

