package com.dh.veiculo.service.impl;

import com.dh.veiculo.model.Veiculo;
import com.dh.veiculo.service.VeiculoService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class VeiculoServiceImpl implements VeiculoService {

    @Override
    public List<Veiculo> listaVeiculos() {
        return Arrays.asList(new Veiculo("Toyota", "Marrom", "toyota.jpeg"), new Veiculo("Honda", "Branco", "honda.jpeg"), new Veiculo("Fiat", "Vermelho", "fiat.jpeg"));
    }
}
