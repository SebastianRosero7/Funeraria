package com.funeraria.controller;

import com.funeraria.domain.dto.DepartamentoDto;
import com.funeraria.domain.useCase.IDepartamentoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

    private final IDepartamentoUseCase service;

    @GetMapping
    public ResponseEntity<List<DepartamentoDto>> getAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartamentoDto> getDepartamnetoId(@PathVariable Integer id) {
        return ResponseEntity.of(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<DepartamentoDto> saveDepartamento(@RequestBody DepartamentoDto departamentoDto) {

        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(service.save(departamentoDto));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .build();
        }
    }

    @PatchMapping
    public ResponseEntity<DepartamentoDto> updateDepartamento(@RequestBody DepartamentoDto departamentoDto) {

       return ResponseEntity.of(service.update(departamentoDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteDepartamento(@PathVariable Integer id) {
        return new ResponseEntity<>(service.delete(id)? HttpStatus.OK:HttpStatus.NOT_FOUND);
    }

}
