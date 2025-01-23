package com.funeraria.domain.casoUso;

import com.funeraria.domain.dto.FunerariaDto;
import com.funeraria.domain.repository.IFunerariaRepository;
import com.funeraria.domain.service.IFunerariaService;
import com.funeraria.exception.EmailValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.crypto.ExemptionMechanismException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class FunerariaServiceImpl implements IFunerariaService {

    @Qualifier("IFunerariaRepository")
    private final IFunerariaRepository funerariaRepository;
    @Override
    public List<FunerariaDto> getAll() {
        return funerariaRepository.getAll();
    }

    @Override
    public Optional<FunerariaDto> getById(Integer id) {
        return funerariaRepository.getById(id);
    }

    @Override
    public Optional<FunerariaDto> findByNombre(String nombre) {
        return funerariaRepository.findByNombre(nombre);
    }

    @Override
    public Optional<FunerariaDto> findByEmail(String email) {
        return funerariaRepository.findByEmail(email);
    }

    @Override
    public Optional<FunerariaDto> update(FunerariaDto funerariaDto) {
        if(funerariaRepository.getById(funerariaDto.getId()).isEmpty()){
            return Optional.empty();
        }
        return Optional.of(funerariaRepository.save(funerariaDto));
    }

    @Override
    public FunerariaDto save(FunerariaDto funerariaDto) {
        if(!funerariaDto.getEmail().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")){
            throw new EmailValidationException();
        }

        return funerariaRepository.save(funerariaDto);
    }

    @Override
    public boolean delete(Integer id) {
        if(funerariaRepository.getById(id).isEmpty()){
            return false;
        }
        funerariaRepository.delete(id);
        return true;
    }
}
