package com.funeraria.controller;

import com.funeraria.domain.dto.ContratoDto;
import com.funeraria.domain.useCase.IContratoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/contratos")
public class ContratoController {

    private final IContratoUseCase useCase;

    @GetMapping
    public ResponseEntity<List<ContratoDto>> getAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(useCase.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContratoDto> getContratoById(@PathVariable String id) {
        return ResponseEntity.of(useCase.getById(id));
    }

    @GetMapping("/contratoByTipo/{tipo}")
    public ResponseEntity<List<ContratoDto>> getContratoByTipo(@PathVariable String tipo) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(useCase.getByTipo(tipo));
    }

    @GetMapping("/contratoByAfiliacion/{afiliacion}")
    public ResponseEntity<List<ContratoDto>> getContratoByAfiliacion(@PathVariable Integer afiliacion) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(useCase.getByAfiliacion(afiliacion));
    }

    @GetMapping("/contratoByFecha/{fecha}")
    public ResponseEntity<List<ContratoDto>> getContratoByFecha(@PathVariable LocalDate fecha) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(useCase.getByFecha(fecha));
    }

    @GetMapping("/contratoByTitular/{id}")
    public ResponseEntity<List<ContratoDto>> getContratoByTitular(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(useCase.getByTitular(id));
    }

    @GetMapping("/contratoByFuneraria/{id}")
    public ResponseEntity<List<ContratoDto>> getContratoByFuneraria(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(useCase.getByFuneraria(id));
    }

    @PostMapping
    public ResponseEntity<ContratoDto> saveContrato(@RequestBody ContratoDto contratoDto) {

        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(useCase.save(contratoDto));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .build();
        }
    }

    @PatchMapping
    public ResponseEntity<ContratoDto> updateDepartamento(@RequestBody ContratoDto contratoDto) {

        return ResponseEntity.of(useCase.update(contratoDto));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Boolean> deleteDepartamento(@PathVariable String codigo) {
        return new ResponseEntity<>(useCase.delete(codigo)? HttpStatus.OK:HttpStatus.NOT_FOUND);
    }


}
