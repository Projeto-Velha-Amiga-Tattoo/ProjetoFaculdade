package curso.pefinal.DAO;


import curso.pefinal.DTO.LoginDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class LoginDAO {
    Connection con;
    
    public ResultSet autenticacao(LoginDTO objUsuarioDTO){
        con = new ConexaoBD().conectaBD();
        try{
            String sql = "select * from login where user = ? and password = ?";
            //preparando a conexao
            PreparedStatement pstm = con.prepareStatement(sql);
            
            //vai mostrar o que vai para a comparação no BD
            //cada linha substitui uma ?, e o número é a ordem
            pstm.setString(1, objUsuarioDTO.getUser());
            pstm.setString(2, objUsuarioDTO.getPassword());
            
            //executa o comando 
            ResultSet rs = pstm.executeQuery();
            
            //retorna o resultado do BD
            return rs;
            
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "UsuarioDAO: " + erro);
            return null;
        }
    }
}
