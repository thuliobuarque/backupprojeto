//Nome do nosso pacote //      
package com.accenture.treinamento.factory;

//Classes necessárias para uso de Banco de dados //

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

//Início da classe de conexão//
public class ConexaoMySQL {
	
	    //Carregando o JDBC Driver padrão
		private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
		
		//Configurando a nossa conexão com um banco de dados//
		
	    // Banco Teste  \/
	    private static final String URL = "jdbc:mysql://localhost:3306/portalaccenture";
	    private static final String USER = "root";
	    private static final String PASS = "";
	    
	   //Método de Conexão//

	    public static Connection getConnection() {
	        
	        Connection conexao = null;

	        try {            
	            Class.forName(DRIVER_CLASS);
	        } catch (ClassNotFoundException ex) {
	            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
	                "Nao foi possivel localizar o driver de conexao com o banco!"
	                + "\n Por favor, entre em contato com o administrador." 
	                + "\n Erro: " + ex, "Erro"); 

	            FacesContext.getCurrentInstance().addMessage(null, msg);
	        }

	        try {

	            System.out.println("Conectando ao banco de dados...");
	            conexao = DriverManager.getConnection(URL, USER, PASS);
	            conexao.setAutoCommit(false);
	            System.out.println("Conexao realizada com sucesso!");



	        } catch (SQLException ex) {
	            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
	                "Nao foi possivel localizar o driver de conexao com o banco!"
	                + "\n Por favor, entre em contato com o administrador." 
	                + "\n Erro: " + ex, "Erro");

	            FacesContext.getCurrentInstance().addMessage(null, msg);
	        }
	        return conexao;
	    }


}