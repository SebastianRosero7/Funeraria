package com.funeraria.controller;

import com.funeraria.domain.dto.ConvenioDto;
import com.funeraria.domain.useCase.IConvenioUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/convenios")
@RequiredArgsConstructor
public class ConvenioController{
    private final IConvenioUseCase convenioUseCase;

    @GetMapping
    public ResponseEntity<List<ConvenioDto>> getAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(convenioUseCase.getAll());
    }

    @GetMapping("/{nit}")
    public ResponseEntity<ConvenioDto> getConvenioByNit(@PathVariable Integer nit) {
        return ResponseEntity.of(convenioUseCase.getById(nit));
    }

    @GetMapping("/convenioByEmpresa/{empresa}")
    public ResponseEntity<ConvenioDto> getConvenioByEmpresa(@PathVariable String empresa) {
        return ResponseEntity.of(convenioUseCase.getByEmpresa(empresa));
    }

    @GetMapping("/convenioByTitular/{titular}")
    public ResponseEntity<ConvenioDto> getConvenioByTitular(@PathVariable String titular) {
        return ResponseEntity.of(convenioUseCase.getBytitular(titular));
    }

    @GetMapping("/convenioByCedula/{cedula}")
    public ResponseEntity<ConvenioDto> getConvenioByCedula(@PathVariable String cedula) {
        return ResponseEntity.of(convenioUseCase.getByCedula(cedula));
    }

    @GetMapping("/convenioByFuneraria/{id}")
    public ResponseEntity<List<ConvenioDto>> getConvenioByFuneraria(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(convenioUseCase.getByFuneraria(id));
    }



    @PostMapping
    public ResponseEntity<ConvenioDto> saveConvenio(@RequestBody ConvenioDto convenioDto) {

        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(convenioUseCase.save(convenioDto));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .build();
        }
    }

    @PatchMapping
    public ResponseEntity<ConvenioDto> updateConvenio(@RequestBody ConvenioDto convenioDto) {

        return ResponseEntity.of(convenioUseCase.update(convenioDto));
    }

    @DeleteMapping("/{nit}")
    public ResponseEntity<Boolean> deleteConvenio(@PathVariable Integer nit) {
        return new ResponseEntity<>(convenioUseCase.delete(nit)? HttpStatus.OK:HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteByCedula/{cedula}")
    public ResponseEntity<Boolean> deleteConvenioByCedula(@PathVariable String cedula) {
        return new ResponseEntity<>(convenioUseCase.deleteByCedula(cedula)? HttpStatus.OK:HttpStatus.NOT_FOUND);
    }

}
