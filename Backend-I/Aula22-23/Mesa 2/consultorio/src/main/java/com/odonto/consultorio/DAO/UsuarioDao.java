package com.odonto.consultorio.DAO;

import com.odonto.consultorio.JDBCConnection;
import com.odonto.consultorio.model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao implements DAO<Usuario> {

    private JDBCConnection jdbcConnection;

    public UsuarioDao(JDBCConnection jdbcConnection) {
        this.jdbcConnection = jdbcConnection;
    }

    @Override
    public Usuario salvar(Usuario usuario) throws Exception {
        Connection connection = jdbcConnection.conectarComBancoDeDados();

        String insertSql = "INSERT INTO usuario (nome, email, senha, nivelAcesso)" +
                "VALUES (?, ?, ?, ?)";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,usuario.getNome());
            preparedStatement.setString(2, usuario.getEmail());
            preparedStatement.setString(3, usuario.getSenha());
            preparedStatement.setString(4, usuario.getNivelAcesso());

            try (ResultSet usuarioID = preparedStatement.getGeneratedKeys()){
                if(usuarioID.next()){
                    usuario.setId(usuarioID.getInt(1));
                }
                else{
                    throw new SQLException("Ops! O dado não foi inserido pois não existe a ID do objeto");
                }
            }
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw new RuntimeException(e);
        }finally {
            connection.close();
        }

        return usuario;
    }

    @Override
    public List<Usuario> listar() {
        Connection connection = jdbcConnection.conectarComBancoDeDados();
        List<Usuario> usuarios = new ArrayList<>();
        String selectSQL = "SELECT * FROM usuario";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                usuarios.add(new Usuario(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5)
                        ));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuarios;
    }

    @Override
    public void excluir(Usuario usuario) {
        Connection connection = jdbcConnection.conectarComBancoDeDados();

        String deleteSQL = "DELETE FROM usuario WHERE id = ?";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setInt(1, usuario.getId());

            int affectedRows = preparedStatement.executeUpdate();

            if(affectedRows>0){
                connection.commit();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
