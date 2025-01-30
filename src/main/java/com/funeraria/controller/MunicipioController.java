package com.funeraria.controller;

import com.funeraria.domain.useCase.IMunicipioUseCase;
import com.funeraria.domain.dto.MunicipioDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequiredArgsConstructor
@RequestMapping(path = "/municipios")
public class MunicipioController {
    private final IMunicipioUseCase municipioUseCase;

    @GetMapping
    public ResponseEntity<List<MunicipioDto>> getAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(municipioUseCase.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MunicipioDto> getMunicipioById(@PathVariable Integer id) {
        return ResponseEntity.of(municipioUseCase.getById(id));
    }

    @GetMapping("/byIdDepartamento/{id}")
    public ResponseEntity<List<MunicipioDto>> getMunicipioByDepartamentoId(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(municipioUseCase.getByDepartamentoId(id));
    }

    @PatchMapping
    public ResponseEntity<MunicipioDto> updateMunicipio(@RequestBody MunicipioDto municipioDto) {

        return ResponseEntity.of(municipioUseCase.update(municipioDto));
    }

    @PostMapping
    public ResponseEntity<MunicipioDto> saveMunicipio(@RequestBody MunicipioDto municipioDto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(municipioUseCase.save(municipioDto));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteMunicipio(@PathVariable Integer id) {
        return new ResponseEntity<>(municipioUseCase.delete(id)? HttpStatus.OK:HttpStatus.NOT_FOUND);
    }

}
