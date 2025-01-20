package com.funeraria.controller;

import com.funeraria.domain.pojo.DepartamentoPojo;
import com.funeraria.domain.service.IDepartamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

    private final IDepartamentoService service;

    @GetMapping
    public ResponseEntity<List<DepartamentoPojo>> getAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartamentoPojo> getDepartamnetoId(@PathVariable Integer id) {
        return ResponseEntity.of(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<DepartamentoPojo> saveDepartamento(@RequestBody DepartamentoPojo departamentoPojo) {

        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(service.save(departamentoPojo));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .build();
        }
    }

    @PatchMapping
    public ResponseEntity<DepartamentoPojo> updateDepartamento(@RequestBody DepartamentoPojo departamentoPojo) {

       return ResponseEntity.of(service.update(departamentoPojo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteDepartamento(@PathVariable Integer id) {
        return new ResponseEntity<>(service.delete(id)? HttpStatus.OK:HttpStatus.NOT_FOUND);
    }

}
