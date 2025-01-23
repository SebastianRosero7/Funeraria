package com.funeraria.domain.service;

import com.funeraria.domain.UseaCase.IUsuarioUsecase;
import com.funeraria.domain.dto.UsuarioDto;
import com.funeraria.domain.repository.IUsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements IUsuarioUsecase {

    private final IUsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioDto> getAll() {
        return usuarioRepository.getAll();
    }

    @Override
    public Optional<UsuarioDto> getById(Integer id) {
        return usuarioRepository.getById(id);
    }

    @Override
    public Optional<UsuarioDto> getByIdFuneraria(Integer id) {
        return usuarioRepository.getByIdFuneraria(id);
    }

    @Override
    public Optional<UsuarioDto> update(UsuarioDto usuarioDto) {
        if(usuarioRepository.getById(usuarioDto.getId()).isEmpty()){
            return Optional.empty();
        }
        return Optional.of(usuarioRepository.save(usuarioDto));

    }

    @Override
    public UsuarioDto save(UsuarioDto usuarioDto) {
        return usuarioRepository.save(usuarioDto);
    }

    @Override
    public boolean delete(Integer id) {
        if(usuarioRepository.getById(id).isEmpty()){
            return false;
        }

        usuarioRepository.delete(id);
        return true;
    }
}
