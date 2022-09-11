
package equipecincocadastroproduto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Vini, Thomás
 */
public class CadastroProduto {
    
    private int idProduto;
    private String tipo;
    private String nome;
    private String descricao;
    private String resumo;
    private int quantidade;
    private Connection conexao;
    
    public CadastroProduto(Connection conexao){
        this.conexao = conexao;
    }


    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public ResultSet obterListaProdutos() throws SQLException{
        String sql = "SELECT * FROM cadastroProduto";
        PreparedStatement requisicao = this.conexao.prepareStatement(sql);
        //ResultSet rs = requisicao.executeQuery();
        return requisicao.executeQuery();
    }
    
    
    
    public boolean incluiProduto()throws SQLException{
        String sql = "INSERT INTO cadastroProduto(tipo,nome,descricao,resumo,quantidade) VALUES (?,?,?,?,?)";
        PreparedStatement requisicao = this.conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        requisicao.setString(1, tipo);  
        requisicao.setString(2, nome);    
        requisicao.setString(3, descricao);  
        requisicao.setString(4, resumo);  
        requisicao.setInt(5, quantidade);  
        requisicao.execute();
        ResultSet retorno = requisicao.getGeneratedKeys();
        if(retorno.next()){
            idProduto = retorno.getInt(1);
        }
        return true;
    }
        public void atualizaProdutos() throws SQLException{
        String sql = "UPDATE cadastroProduto SET tipo=?,nome=?,descricao=?,resumo=?, quantidade=? WHERE idProduto= ?";
        PreparedStatement requisicao = this.conexao.prepareStatement(sql);
        requisicao.setString(1, tipo);  
        requisicao.setString(2, nome);    
        requisicao.setString(3, descricao);  
        requisicao.setString(4, resumo);  
        requisicao.setInt(5, quantidade);  
        requisicao.setInt(6, idProduto);  
        requisicao.executeUpdate();
    }
        public void removerProdutos()throws SQLException{
        String sql = "DELETE FROM cadastroProduto WHERE idProduto = ?";
        PreparedStatement requisicao = this.conexao.prepareStatement(sql);
        requisicao.setInt(1, idProduto);  
        requisicao.execute();
        }

}
