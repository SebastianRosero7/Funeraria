package com.funeraria.controller;

import com.funeraria.domain.dto.TitularDto;
import com.funeraria.domain.useCase.ITitularUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/titulares")
public class TitularController {

    private final ITitularUseCase titularUseCase;

    @GetMapping
    public ResponseEntity<List<TitularDto>> getAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(titularUseCase.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TitularDto> getTitularById(@PathVariable Integer id) {
        return ResponseEntity.of(titularUseCase.getById(id));
    }

    @GetMapping("/titularByCedula/{cedula}")
    public ResponseEntity<TitularDto> getTitularByCedula(@PathVariable String cedula) {
        return ResponseEntity.of(titularUseCase.getByCedulaCliente(cedula));
    }


    @PostMapping
    public ResponseEntity<TitularDto> save(@RequestBody TitularDto titularDto) {

        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(titularUseCase.save(titularDto));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .build();
        }
    }

    @PatchMapping
    public ResponseEntity<TitularDto> updateTitular(@RequestBody TitularDto titularDto) {

        return ResponseEntity.of(titularUseCase.update(titularDto));
    }

    @DeleteMapping("/deleteByCedula/{cedula}")
    public ResponseEntity<Boolean> deleteTitularByCedula(@PathVariable String cedula) {
        return new ResponseEntity<>(titularUseCase.deleteByCedulaCliente(cedula)? HttpStatus.OK:HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
        return new ResponseEntity<>(titularUseCase.delete(id)? HttpStatus.OK:HttpStatus.NOT_FOUND);
    }



}
