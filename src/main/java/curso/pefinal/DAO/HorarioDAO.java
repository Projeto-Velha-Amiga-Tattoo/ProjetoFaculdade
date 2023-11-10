package curso.pefinal.DAO;

import curso.pefinal.DTO.HorarioDTO;
import curso.pefinal.DTO.ServicoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class HorarioDAO {
    
    Connection con;
    ArrayList<HorarioDTO> horarios = new ArrayList<>();
    public ArrayList<HorarioDTO> listarHorario() {

        try {
            con = new ConexaoBD().conectaBD();
            String sql = "select * from horario";

            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {

                HorarioDTO horario = new HorarioDTO();
                horario.setId_horario(rs.getInt("id_horario"));
                horario.setHora(rs.getString("hora"));
                horarios.add(horario);

            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ListarHorarioDAO: " + erro);
        }

        return horarios;
    }
}
