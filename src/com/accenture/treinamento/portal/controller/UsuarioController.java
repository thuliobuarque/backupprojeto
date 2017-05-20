package com.accenture.treinamento.portal.controller;

import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;
import javax.faces.component.EditableValueHolder;

import org.primefaces.context.RequestContext;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;


import com.accenture.treinamento.comum.util.SessionUtil;
import com.accenture.treinamento.portal.dao.IUsuarioDAO;
import com.accenture.treinamento.portal.dao.UsuarioDAO;
import com.accenture.treinamento.portal.model.UsuarioBean;
import com.accenture.treinamento.sistema.exception.ProjetoException;

/**
 *
 * @author Thulio, thayse, thales, caio, priscila, veridiana
 * @since 26/03/2015
 */

@ManagedBean(name = "MBUsuarios")
@SessionScoped
public class UsuarioController {

	private UsuarioBean usuario;
	// LISTAS
		private List<UsuarioBean> listaUsuario;
		

	public UsuarioController() {
		usuario = new UsuarioBean();
		listaUsuario =  new ArrayList<>();
		listaUsuario = null;

	}

	public String login() throws ProjetoException {

		UsuarioDAO ud = new UsuarioDAO();
		usuario = ud.autenticarUsuario(usuario);

		if (usuario == null) {
			FacesContext fct = FacesContext.getCurrentInstance();
			fct.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Usuário ou senha inválidos!", "Erro"));

			return "";
		} else {

			return "/pages/comum/principal.faces?faces-redirect=true";
		}
	}

	public void cadastrarUsuario() {

		UsuarioDAO sdao = new UsuarioDAO();
		boolean cadastrou = sdao.cadastrarUsuario(usuario);

		if (cadastrou == true) {

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Sistema cadastrado com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance()
					.execute("dlgCadSistema.hide();");
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ocorreu um erro durante o cadastro!", "Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance()
					.execute("dlgCadSistema.hide();");
		}
	}
	
	public void atualizarUsuario() {

		UsuarioDAO sdao = new UsuarioDAO();
		boolean atualizou = sdao.atualizouUsuario(usuario);

		if (atualizou == true) {

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Sistema atualizado com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance()
					.execute("dlgAtuUsuario.hide();");
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ocorreu um erro durante o cadastro!", "Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance()
					.execute("dlgdlgAtuUsuario.hide();");
		}
	}
	
	
	public void LimparObjeto(){
		usuario = null;
	}

	public UsuarioBean getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioBean usuario) {
		this.usuario = usuario;
	}

	public List<UsuarioBean> getListaUsuario() {
		if (listaUsuario == null) {
			UsuarioDAO fdao = new UsuarioDAO ();
			listaUsuario = fdao.listaUsuario();
		}
		return listaUsuario;
	}

	public void setListaUsuario(List<UsuarioBean> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}
	
	

}