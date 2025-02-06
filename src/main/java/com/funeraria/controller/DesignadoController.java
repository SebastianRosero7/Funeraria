package com.funeraria.controller;

import com.funeraria.domain.dto.DesignadoDto;
import com.funeraria.domain.useCase.IDesignadoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/designados")
public class DesignadoController {

    private final IDesignadoUseCase designadoUseCase;


    @GetMapping
    public ResponseEntity<List<DesignadoDto>> getAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(designadoUseCase.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DesignadoDto> getDesignadoById(@PathVariable Integer id) {
        return ResponseEntity.of(designadoUseCase.getById(id));
    }

    @GetMapping("/designadoByParentesco/{parentesco}")
    public ResponseEntity<List<DesignadoDto>> getDesignadoByParentesco(@PathVariable String parentesco) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(designadoUseCase.getByParentesco(parentesco));
    }

    @GetMapping("/designadoBycedula/{cedula}")
    public ResponseEntity<DesignadoDto> getDesignadoByCedula(@PathVariable String cedula) {
        return ResponseEntity.of(designadoUseCase.getByCedulaCliente(cedula));
    }

    @GetMapping("/designadoByContrato/{contrto}")
    public ResponseEntity<List<DesignadoDto>> getDesignadoByContrato(@PathVariable String contrto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(designadoUseCase.getByContrato(contrto));
    }


    @PostMapping
    public ResponseEntity<DesignadoDto> saveDesignado(@RequestBody DesignadoDto designadoDto) {

        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(designadoUseCase.save(designadoDto));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .build();
        }
    }

    @PatchMapping
    public ResponseEntity<DesignadoDto> updateDesignado(@RequestBody DesignadoDto designadoDto) {

        return ResponseEntity.of(designadoUseCase.update(designadoDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteDesignado(@PathVariable Integer id) {
        return new ResponseEntity<>(designadoUseCase.delete(id)? HttpStatus.OK:HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteByCedula/{cedula}")
    public ResponseEntity<Boolean> deleteDesignadoByCedula(@PathVariable String cedula) {
        return new ResponseEntity<>(designadoUseCase.deleteByCedulaCliente(cedula)? HttpStatus.OK:HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteByContrato/{contrato}")
    public ResponseEntity<Boolean> deleteDesignadoByContrato(@PathVariable String contrato) {
        return new ResponseEntity<>(designadoUseCase.deleteByContrato(contrato)? HttpStatus.OK:HttpStatus.NOT_FOUND);
    }

}
