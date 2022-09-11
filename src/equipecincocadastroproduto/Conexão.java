/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package equipecincocadastroproduto;

/**
 *
 * @author Vini, Thomás
 * 
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexão {
    private boolean statusConexao;
    private Connection conexao;
    private String mensagemErro;
    private String nomeDriver;
    private String nomeServidor;
    private String portaServidor;
    private String nomeUsuario;
    private String senha;
    private String nomeBanco;
    private String url;

    public Conexão(String nomeServidor, String portaServidor, String nomeUsuario, String senha, String nomeBanco) {
        this.nomeServidor = nomeServidor;
        this.portaServidor = portaServidor;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.nomeBanco = nomeBanco;
        this.url = "jdbc:mysql://"+nomeServidor+":"+portaServidor+"/"+nomeBanco+
        "?autoReconnect=true&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    }
    
    public void realizaConexao(){
        this.nomeDriver="com.mysql.cj.jdbc.Driver";
        try{
           Class.forName(nomeDriver);
           this.conexao = DriverManager.getConnection(url, nomeUsuario, senha);
           statusConexao = true;
            System.out.println("Conectou");
        }
        catch(ClassNotFoundException e){
            mensagemErro +="Não foi possível carregar o driver";
            statusConexao = false;
        }
        catch(SQLException e){
            mensagemErro +="Não foi possível conectar";
            statusConexao = false;
        }
    }

    public boolean isStatusConexao() {
        return statusConexao;
    }

    public Connection getConexao() {
        return conexao;
    }

    public String getMensagemErro() {
        return mensagemErro;
    }
    
}