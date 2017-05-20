package com.accenture.treinamento.portal.dao;

import java.util.List;

import javax.faces.model.SelectItem;

import com.accenture.treinamento.portal.model.UsuarioBean;
import com.accenture.treinamento.sistema.exception.ProjetoException;

public interface IUsuarioDAO {

	public abstract UsuarioBean autenticarUsuario(UsuarioBean usuario) throws ProjetoException;
	public abstract boolean cadastrarUsuario(UsuarioBean usuario) throws ProjetoException;


}
