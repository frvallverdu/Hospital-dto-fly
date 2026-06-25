package com.hospital_vm.Hospital_vm.service;

import com.hospital_vm.Hospital_vm.model.atencion;
import com.hospital_vm.Hospital_vm.repository.AtencionRepository;


import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class AtencionService {
    @Autowired
    private AtencionRepository atencionRepository;

    public List<atencion> findAll(){
        return atencionRepository.findAll();
    }
    public atencion findById(Integer id){
        return atencionRepository.findById(id).get();
    }
    public atencion save(atencion atencion){
        return atencionRepository.save(atencion);
    }
    public void delete(Integer id){
        atencionRepository.deleteById(id);
    }
    public List<atencion> listarPorPaciente(Integer id){
        return atencionRepository.findByPacienteId(id);
    }
    public List<atencion> listarPorMedico(Integer id){
        return atencionRepository.findByMedicoId(id);
    }
    public List<Object[]> obtenerCostosPorTipo(){
       return atencionRepository.obtenerCostosAgrupadosPorTipo();
    }
    public List<atencion> listarPorFecha(LocalDate fecha){
        return atencionRepository.findByFechaAtencionOrderByHoraAtencionAsc(fecha);
    }
}   
