package com.odonto.consultorio.controller;

import com.odonto.consultorio.model.Usuario;
import com.odonto.consultorio.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {
    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping("/usuario/listarUsuarios/")
    public List<Usuario> listUsuarios(){
        return usuarioService.listarUsuario();
    }

    @PostMapping("/usuario/resgistrarUsuario")
    public List<Usuario> registrarUsuario(@RequestParam(name="name") String nome,
                                          @RequestParam(name="email") String email,
                                          @RequestParam(name="senha") String senha,
                                          @RequestParam(name="nivelAcesso") String nivelAcesso) throws Exception {

        return usuarioService.registrarUsuario(new Usuario(nome, email, senha, nivelAcesso));
    }
}
