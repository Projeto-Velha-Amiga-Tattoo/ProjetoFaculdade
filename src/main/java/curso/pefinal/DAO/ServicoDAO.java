
package curso.pefinal.DAO;


import curso.pefinal.DTO.ServicoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Luanna
 */
public class ServicoDAO {
    
    Connection con;
    ArrayList<ServicoDTO> servicos = new ArrayList<>();

    public void cadastrarServico(ServicoDTO servicoDTO) {

        Integer id_gerado = null;
        try {
            con = new ConexaoBD().conectaBD();

            String sql = "insert into servico(nome) values(?)";

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, servicoDTO.getNome());

            pstm.execute();

            pstm.close();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "CadastrarServicoDAO: " + erro);
        }
    }

/////////////////////////////////////////////////////////////////

    public ArrayList<ServicoDTO> listarServico() {

        try {
            con = new ConexaoBD().conectaBD();
            String sql = "select * from servico";

            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {

                ServicoDTO servico = new ServicoDTO();
                servico.setId_servico(rs.getInt("id_servico"));
                servico.setNome(rs.getString("nome"));
                servicos.add(servico);

            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ListarServicoDAO: " + erro);
        }

        return servicos;
    }

//////////////////////////////////////////////////////////////////

    public ServicoDTO servicoAlteracao(int id) {
        int id_servico;

        try {

            con = new ConexaoBD().conectaBD();

            String sql = "select * from servico where id_servico = ?";
            //preparando a conexao
            PreparedStatement pstm = con.prepareStatement(sql);

            //vai mostrar o que vai para a comparação no BD
            //cada linha substitui uma ?, e o número é a ordem
            pstm.setInt(1, id);

            //executa o comando 
            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                ServicoDTO servico = new ServicoDTO();
                servico.setId_servico(rs.getInt("id_servico"));
                servico.setNome(rs.getString("nome"));
                return servico;

            } else {
                JOptionPane.showMessageDialog(null, "Servico não encontrado");
                return null;
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "servicoAlteracaoDAO: " + erro);
            return null;
        }
    }

///////////////////////////////////////////////////////////////////////

    public void alterarServico(ServicoDTO servicoDTO) {

        try {
            con = new ConexaoBD().conectaBD();

            String sql = "update servico set nome = ? where id_servico = ?";

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, servicoDTO.getNome());
            pstm.setInt(2, servicoDTO.getId_servico());

            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "AlterarServicoDAO: " + erro);
        }
    }

/////////////////////////////////////////////////////////////////////////

    public void excluirServico(int id) {
        try {
            con = new ConexaoBD().conectaBD();

            String sql = "select * from servico where id_servico = ?";

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {

                String sql2 = "delete from servico where id_servico = ?";

                PreparedStatement pstm2 = con.prepareStatement(sql2);
                pstm2.setInt(1, id);

                pstm2.execute();
                pstm2.close();
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "DeletarFuncionarioDAO: " + erro);
        }

    }
}
