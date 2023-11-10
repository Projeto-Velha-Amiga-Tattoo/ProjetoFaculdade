/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package curso.pefinal.DAO;


import curso.pefinal.DTO.TesteCPFDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Luanna
 */
public class TesteCPFDAO {
     Connection con;
    
    public ResultSet testarCPFCadastro(TesteCPFDTO teste){
        con = new ConexaoBD().conectaBD();
        try{
            String sql = "select * from cliente where cpf = ?";
            //preparando a conexao
            PreparedStatement pstm = con.prepareStatement(sql);
            
            //vai mostrar o que vai para a comparação no BD
            //cada linha substitui uma ?, e o número é a ordem
            pstm.setString(1, teste.getCpf());
            
            //executa o comando 
            ResultSet rs = pstm.executeQuery();
            
            //retorna o resultado do BD
            return rs;
            
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "TesteCPFCadastro: " + erro);
            return null;
        }
    }
    
    public ResultSet testarCPFAlteracao(TesteCPFDTO teste, int id){
        con = new ConexaoBD().conectaBD();
        try{
            String sql = "select * from cliente where cpf = ? and id_cliente <> ?";
            //preparando a conexao
            PreparedStatement pstm = con.prepareStatement(sql);
            
            //vai mostrar o que vai para a comparação no BD
            //cada linha substitui uma ?, e o número é a ordem
            pstm.setString(1, teste.getCpf());
            pstm.setInt(2, id);
            
            //executa o comando 
            ResultSet rs = pstm.executeQuery();
            
            //retorna o resultado do BD
            return rs;
            
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "TesteCPFAlteracao: " + erro);
            return null;
        }
    }
    

    

}
