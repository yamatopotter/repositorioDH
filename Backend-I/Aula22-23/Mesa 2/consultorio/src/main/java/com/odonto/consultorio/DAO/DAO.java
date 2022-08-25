package com.odonto.consultorio.DAO;

import java.util.List;

public interface DAO <T>{
    public T salvar(T t) throws Exception;
    public List<T> listar();
    public void excluir(T t);
}
