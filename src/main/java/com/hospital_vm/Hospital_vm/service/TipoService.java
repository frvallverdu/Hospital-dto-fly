package com.hospital_vm.Hospital_vm.service;

import com.hospital_vm.Hospital_vm.model.tipo_usuario;
import com.hospital_vm.Hospital_vm.repository.TipoUsuarioRepository;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public class TipoService {
    @Autowired
    private TipoUsuarioRepository tipoRepository;

    public List<tipo_usuario> findAll(){
        return tipoRepository.findAll();
    }
    public tipo_usuario findById(Integer id){
        return tipoRepository.findById(id).get();
    }
    public tipo_usuario save(tipo_usuario tipo_usuario){
        return tipoRepository.save(tipo_usuario);
    }
    public void delete(Integer id){
        tipoRepository.deleteById(id);
    }
}

