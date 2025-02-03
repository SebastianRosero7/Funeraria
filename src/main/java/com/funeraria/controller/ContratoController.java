package com.funeraria.controller;

import com.funeraria.domain.useCase.IContratoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/contratos")
public class ContratoController {

    private final IContratoUseCase useCase;

}
