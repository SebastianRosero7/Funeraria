package com.funeraria.controller;

import com.funeraria.domain.dto.ClienteDto;
import com.funeraria.domain.dto.DepartamentoDto;
import com.funeraria.domain.useCase.IClienteUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final IClienteUseCase clienteUseCase;


    @GetMapping
    public ResponseEntity<List<ClienteDto>> getAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(clienteUseCase.getAll());
    }

    @GetMapping("/{cedula}")
    public ResponseEntity<ClienteDto> getClienteByCedula(@PathVariable String cedula) {
        return ResponseEntity.of(clienteUseCase.getById(cedula));
    }

    @GetMapping("/clientesByNombre/{nombre}")
    public ResponseEntity<List<ClienteDto>> getClienteByNombre(@PathVariable String nombre) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(clienteUseCase.getByNombre(nombre));
    }

    @GetMapping("/clientesByApellido/{apellido}")
    public ResponseEntity<List<ClienteDto>> getClienteByApellido(@PathVariable String apellido) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(clienteUseCase.getByApellido(apellido));
    }

    @PostMapping
    public ResponseEntity<ClienteDto> saveCliente(@RequestBody ClienteDto clienteDto) {

        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(clienteUseCase.save(clienteDto));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .build();
        }
    }

    @PatchMapping
    public ResponseEntity<ClienteDto> updateCliente(@RequestBody ClienteDto clienteDto) {

        return ResponseEntity.of(clienteUseCase.update(clienteDto));
    }

    @DeleteMapping("/{cedula}")
    public ResponseEntity<Boolean> deleteCliente(@PathVariable String cedula) {
        return new ResponseEntity<>(clienteUseCase.delete(cedula)? HttpStatus.OK:HttpStatus.NOT_FOUND);
    }

}
