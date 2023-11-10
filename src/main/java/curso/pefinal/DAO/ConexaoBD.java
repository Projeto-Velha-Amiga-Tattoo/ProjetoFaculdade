package curso.pefinal.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Luanna
 */
public class ConexaoBD {
     public Connection conectaBD(){
        Connection con = null;
        try{
            String url = "jdbc:mysql://localhost:3306/pe?user=root&password=";
            con = DriverManager.getConnection(url);
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"ConexaoBD: " + erro.getMessage());
        }
        
        return con;
    }
}
