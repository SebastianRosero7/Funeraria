package com.funeraria.domain.service;

import com.funeraria.domain.pojo.DepartamentoPojo;
import com.funeraria.domain.repository.IDepartamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DepartamentoServiceImpl implements IDepartamentoService {

    private final IDepartamentoRepository departamentoRepository;


    @Override
    public List<DepartamentoPojo> getAll() {
        return departamentoRepository.getAll();
    }

    @Override
    public Optional<DepartamentoPojo> getById(Integer id) {
        return departamentoRepository.getById(id);
    }

    @Override
    public DepartamentoPojo save(DepartamentoPojo departamentoPojo) {
        return departamentoRepository.save(departamentoPojo);
    }

    @Override
    public boolean delete(Integer id) {
        try {
            departamentoRepository.delete(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
