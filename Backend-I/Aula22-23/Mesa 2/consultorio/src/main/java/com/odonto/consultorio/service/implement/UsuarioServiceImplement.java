package com.odonto.consultorio.service.implement;

import com.odonto.consultorio.DAO.DAO;
import com.odonto.consultorio.DAO.UsuarioDao;
import com.odonto.consultorio.JDBCConnection;
import com.odonto.consultorio.model.Usuario;
import com.odonto.consultorio.service.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioServiceImplement implements UsuarioService {
    private DAO<Usuario> usuarioDAO = new UsuarioDao(new JDBCConnection());

    public UsuarioServiceImplement() {}

    @Override
    public List<Usuario> registrarUsuario(Usuario usuario) throws Exception {
        List<Usuario> resposta = new ArrayList<>();
        resposta.add(usuarioDAO.salvar(usuario));
        return resposta;
    }

    @Override
    public List<Usuario> listarUsuario() {
        return usuarioDAO.listar();
    }

    @Override
    public void excluirUsuario(Usuario usuario) {
        usuarioDAO.excluir(usuario);
    }
}
