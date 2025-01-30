package com.funeraria.controller;


import com.funeraria.domain.dto.FunerariaDto;
import com.funeraria.domain.useCase.IFunerariaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/funerarias")
public class FunerariaController {

    private final IFunerariaUseCase service;

    @GetMapping
    public ResponseEntity<List<FunerariaDto>> getAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FunerariaDto> getFunerariaId(@PathVariable Integer id) {
        return ResponseEntity.of(service.getById(id));
    }

    @GetMapping("/byNombre/{nombre}")
    public ResponseEntity<FunerariaDto> getFunerariaNombre(@PathVariable String nombre) {
        return ResponseEntity.of(service.findByNombre(nombre));
    }


    @GetMapping("/byEmail/{email}")
    public ResponseEntity<FunerariaDto> getFunerariaEmail(@PathVariable String email) {
        return ResponseEntity.of(service.findByEmail(email));
    }

    @PostMapping
    public ResponseEntity<FunerariaDto> saveFuneraria(@RequestBody FunerariaDto funerariaDto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                    .body(service.save(funerariaDto));


    }

    @PatchMapping
    public ResponseEntity<FunerariaDto> updateFuneraria(@RequestBody FunerariaDto funerariaDto) {

        return ResponseEntity.of(service.update(funerariaDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteFuneraria(@PathVariable Integer id) {
        return new ResponseEntity<>(service.delete(id)? HttpStatus.OK:HttpStatus.NOT_FOUND);
    }



}
