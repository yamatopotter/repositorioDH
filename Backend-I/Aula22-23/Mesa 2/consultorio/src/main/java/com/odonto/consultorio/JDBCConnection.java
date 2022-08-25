package com.odonto.consultorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

    private String jdbcDriver;
    private String dbUrl;
    private String nomeUsuario;
    private String senha;

    public JDBCConnection(String jdbcDriver, String dbUrl, String nomeUsuario, String senha) {
        this.jdbcDriver = jdbcDriver;
        this.dbUrl = dbUrl;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
    }

    public JDBCConnection() {
        this.jdbcDriver = "org.h2.Driver";
        this.dbUrl = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;INIT=RUNSCRIPT FROM './src/main/java/com.odonto.consultorio/initDB.sql'";
        this.nomeUsuario = "sa";
        this.senha = "";
    }

    public Connection conectarComBancoDeDados() {
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(dbUrl,nomeUsuario,senha);
        }
        catch(SQLException throwables){
            throwables.printStackTrace();
        }
        return connection;
    }

}
