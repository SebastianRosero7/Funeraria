package com.funeraria.controller;

import com.funeraria.domain.useCase.IUsuarioUsecase;
import com.funeraria.domain.dto.UsuarioDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/usuarios")
public class UsuarioController {

    private final IUsuarioUsecase usuarioUsecase;

    @GetMapping
    public ResponseEntity<List<UsuarioDto>> getAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(usuarioUsecase.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> getUsuarioId(@PathVariable Integer id) {
        return ResponseEntity.of(usuarioUsecase.getById(id));
    }

    @GetMapping("/byIdFuneraria/{id}")
    public ResponseEntity<UsuarioDto> getUsuarioByIdFuneraria(@PathVariable Integer id) {
        return ResponseEntity.of(usuarioUsecase.getByIdFuneraria(id));
    }

    @PatchMapping
    public ResponseEntity<UsuarioDto> updateUsuario(@RequestBody UsuarioDto usuarioDto) {

        return ResponseEntity.of(usuarioUsecase.update(usuarioDto));
    }

    @PostMapping
    public ResponseEntity<UsuarioDto> saveUsuario(@RequestBody UsuarioDto usuarioDto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(usuarioUsecase.save(usuarioDto));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUsuario(@PathVariable Integer id) {
        return new ResponseEntity<>(usuarioUsecase.delete(id)? HttpStatus.OK:HttpStatus.NOT_FOUND);
    }

}
