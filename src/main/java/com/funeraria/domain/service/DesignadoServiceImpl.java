package com.funeraria.domain.service;

import com.funeraria.domain.dto.DesignadoDto;
import com.funeraria.domain.repository.IDesignadoRepository;
import com.funeraria.domain.useCase.IDesignadoUseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DesignadoServiceImpl implements IDesignadoUseCase {

    private final IDesignadoRepository designadoRepository;

    @Override
    public List<DesignadoDto> getAll() {
        return designadoRepository.getAll();
    }

    @Override
    public Optional<DesignadoDto> getById(Integer id) {
        return designadoRepository.getById(id);
    }

    @Override
    public List<DesignadoDto> getByParentesco(String parentesco) {
        return designadoRepository.getByParentesco(parentesco);
    }

    @Override
    public Optional<DesignadoDto> getByCedulaCliente(String cedula) {
        return designadoRepository.getByCedulaCliente(cedula);
    }

    @Override
    public List<DesignadoDto> getByContrato(String contrato) {
        return designadoRepository.getByContrato(contrato);
    }

    @Override
    public Optional<DesignadoDto> update(DesignadoDto designadoDto) {

            if(designadoRepository.getById(designadoDto.getId()).isEmpty()) {
                return Optional.empty();
            }

        return Optional.of(designadoRepository.save(designadoDto));
    }

    @Override
    public DesignadoDto save(DesignadoDto designadoDto) {
        return designadoRepository.save(designadoDto);
    }

    @Override
    public boolean delete(Integer id) {
        if(designadoRepository.getById(id).isEmpty()) {
            return false;
        }

        designadoRepository.delete(id);

        return true;
    }

    @Override
    @Transactional
    public boolean deleteByCedulaCliente(String cedula) {
        if(designadoRepository.getByCedulaCliente(cedula).isEmpty()) {
            return false;
        }

        designadoRepository.deleteByCedulaCliente(cedula);

        return true;
    }

    @Override
    @Transactional
    public boolean deleteByContrato(String contrato) {
        if(designadoRepository.getByContrato(contrato).isEmpty()) {
            return false;
        }

        designadoRepository.deleteByContrato(contrato);

        return true;
    }
}
