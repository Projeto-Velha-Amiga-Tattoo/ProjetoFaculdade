package curso.pefinal.DAO;


import curso.pefinal.DTO.TesteAgendamentoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class TesteAgendamentoDAO {
     Connection con;
    
    public ResultSet testarAgendamentoCliente(TesteAgendamentoDTO teste){
        con = new ConexaoBD().conectaBD();
        try{
            String sql = "select * from agendamento where fk_id_cliente = ?";
            //preparando a conexao
            PreparedStatement pstm = con.prepareStatement(sql);
            
            //vai mostrar o que vai para a comparação no BD
            //cada linha substitui uma ?, e o número é a ordem
            pstm.setInt(1, teste.getId());
            
            //executa o comando 
            ResultSet rs = pstm.executeQuery();
            
            //retorna o resultado do BD
            return rs;
            
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "TesteAgendamento Cliente: " + erro);
            return null;
        }
    }
    
    
    public ResultSet testarAgendamentoFuncionario(TesteAgendamentoDTO teste){
        con = new ConexaoBD().conectaBD();
        try{
            String sql = "select * from agendamento where fk_id_funcionario = ?";
            //preparando a conexao
            PreparedStatement pstm = con.prepareStatement(sql);
            
            //vai mostrar o que vai para a comparação no BD
            //cada linha substitui uma ?, e o número é a ordem
            pstm.setInt(1, teste.getId());
            
            //executa o comando 
            ResultSet rs = pstm.executeQuery();
            
            //retorna o resultado do BD
            return rs;
            
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "TesteAgendamento Funcionario: " + erro);
            return null;
        }
    }
    
    public ResultSet agendamentoHorario(TesteAgendamentoDTO teste){
        con = new ConexaoBD().conectaBD();
        try{
            String sql = "select * from horario where id_horario = ?";
            //preparando a conexao
            PreparedStatement pstm = con.prepareStatement(sql);
            
            //vai mostrar o que vai para a comparação no BD
            //cada linha substitui uma ?, e o número é a ordem
            pstm.setInt(1, teste.getId());
            
            //executa o comando 
            ResultSet rs = pstm.executeQuery();
            
            //retorna o resultado do BD
            return rs;
            
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "TesteAgendamento Horario: " + erro);
            return null;
        }
    }
    
    public ResultSet agendamentoCliente(TesteAgendamentoDTO teste){
        con = new ConexaoBD().conectaBD();
        try{
            String sql = "select * from cliente where id_cliente = ?";
            //preparando a conexao
            PreparedStatement pstm = con.prepareStatement(sql);
            
            //vai mostrar o que vai para a comparação no BD
            //cada linha substitui uma ?, e o número é a ordem
            pstm.setInt(1, teste.getId());
            
            //executa o comando 
            ResultSet rs = pstm.executeQuery();
            
            //retorna o resultado do BD
            return rs;
            
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "TesteAgendamento Cliente: " + erro);
            return null;
        }
    }
    
    public ResultSet agendamentoFuncionario(TesteAgendamentoDTO teste){
        con = new ConexaoBD().conectaBD();
        try{
            String sql = "select * from funcionario where id_funcionario = ?";
            //preparando a conexao
            PreparedStatement pstm = con.prepareStatement(sql);
            
            //vai mostrar o que vai para a comparação no BD
            //cada linha substitui uma ?, e o número é a ordem
            pstm.setInt(1, teste.getId());
            
            //executa o comando 
            ResultSet rs = pstm.executeQuery();
            
            //retorna o resultado do BD
            return rs;
            
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "TesteAgendamento Funcionario: " + erro);
            return null;
        }
    }
    
    
    

    

}
