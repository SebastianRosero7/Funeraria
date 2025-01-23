package com.funeraria.persistance.repository;

import com.funeraria.domain.dto.UsuarioDto;
import com.funeraria.domain.repository.IUsuarioRepository;
import com.funeraria.persistance.entity.UsuarioEntity;
import com.funeraria.persistance.jpa.IUsuarioRepositoryCRUD;
import com.funeraria.persistance.mapper.IUsuarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class UsuarioRepositoryImpl implements IUsuarioRepository {

    private final IUsuarioRepositoryCRUD usuarioRepository;
    @Qualifier("IUsuarioMapper")
    private final IUsuarioMapper usuarioMapper;

    @Override
    public List<UsuarioDto> getAll() {
        return usuarioMapper.toUsuariosDto(usuarioRepository.findAll());
    }

    @Override
    public Optional<UsuarioDto> getById(Integer id) {
        return usuarioRepository.findById(id).map(usuarioMapper::toUsuarioDto);
    }

    @Override
    public Optional<UsuarioDto> getByIdFuneraria(Integer id) {
        return usuarioRepository.findByfunerariaId(id).map(usuarioMapper::toUsuarioDto);
    }

    @Override
    public UsuarioDto save(UsuarioDto usuarioDto) {
        UsuarioEntity usuarioEntity= usuarioMapper.toUsuarioEntity(usuarioDto);
        return usuarioMapper.toUsuarioDto(usuarioRepository.save(usuarioEntity));

    }

    @Override
    public void delete(Integer id) {
        usuarioRepository.deleteById(id);
    }
}
