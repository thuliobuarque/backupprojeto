package com.accenture.treinamento.portal.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import org.primefaces.component.api.UIData;
import org.primefaces.context.RequestContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.accenture.treinamento.portal.dao.PessoaDAO;
import com.accenture.treinamento.portal.model.PessoaBean;

import javax.faces.component.EditableValueHolder;
import javax.servlet.ServletContext;

@ManagedBean(name = "MBPessoa")
@ViewScoped
public class PessoaController {

	private PessoaBean pessoa;
	private Integer idpessoa;
	private List<PessoaBean> listapessoa;
	
	private Integer tipo;
	private String campotexto;
	private Integer campobusca;
	
	

	public PessoaController() {
		pessoa = new PessoaBean();
	}



	public PessoaBean getPessoa() {
		return pessoa;
	}



	public void setPessoa(PessoaBean pessoa) {
		this.pessoa = pessoa;
	}



	public Integer getIdpessoa() {
		return idpessoa;
	}



	public void setIdpessoa(Integer idpessoa) {
		this.idpessoa = idpessoa;
	}



	public List<PessoaBean> getListapessoa() {
		return listapessoa;
	}



	public void setListapessoa(List<PessoaBean> listapessoa) {
		this.listapessoa = listapessoa;
	}



	public Integer getTipo() {
		return tipo;
	}



	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}



	public String getCampotexto() {
		return campotexto;
	}



	public void setCampotexto(String campotexto) {
		this.campotexto = campotexto;
	}



	public Integer getCampobusca() {
		return campobusca;
	}



	public void setCampobusca(Integer campobusca) {
		this.campobusca = campobusca;
	}



	
	

	
}