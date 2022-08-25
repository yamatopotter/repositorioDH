package com.odonto.consultorio.service;

import com.odonto.consultorio.model.Usuario;

import java.util.List;

public interface UsuarioService {
    List<Usuario> registrarUsuario(Usuario usuario) throws Exception;
    List<Usuario> listarUsuario();
    void excluirUsuario(Usuario usuario);
}
