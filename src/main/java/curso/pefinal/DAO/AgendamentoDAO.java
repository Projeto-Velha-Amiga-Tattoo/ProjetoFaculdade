package curso.pefinal.DAO;

import curso.pefinal.DTO.AgendamentoDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AgendamentoDAO {
    Connection con;
    ArrayList<AgendamentoDTO> agendamentos = new ArrayList<>();
    public void cadastrarAgendamento(AgendamentoDTO agendamentoDTO){
             
        try{
            con = new ConexaoBD().conectaBD();
                        
            String sql = "insert into agendamento(fk_id_funcionario,fk_id_cliente,fk_id_servico,fk_id_horario,data,observacao) values(?,?,?,?,?,?)";
            
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, agendamentoDTO.getFuncionario());
            pstm.setInt(2, agendamentoDTO.getCliente());
            pstm.setInt(3, agendamentoDTO.getServico());
            pstm.setInt(4, agendamentoDTO.getHorario());
            pstm.setString(5, agendamentoDTO.getData());
            pstm.setString(6, agendamentoDTO.getObservacao());
            
            pstm.execute();
            pstm.close();   

 

        }catch(Exception erro){
            JOptionPane.showMessageDialog(null, "CadastrarAgendamentoDAO: " + erro);
        }
    }
    
    public ArrayList<AgendamentoDTO> listarAgendamento(){
        
        try{
            con = new ConexaoBD().conectaBD();
            String sql = "select * from agendamento";
        
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            
            
            while(rs.next()){
                
                
                
                //formatando a data
                Date data = rs.getDate("data");
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String dataFormatada = dateFormat.format(data);
                        
                
                AgendamentoDTO agendamento = new AgendamentoDTO();
                agendamento.setId_agendamento(rs.getInt("id_agendamento"));
                agendamento.setFuncionario(rs.getInt("fk_id_funcionario"));
                agendamento.setCliente(rs.getInt("fk_id_cliente"));
                agendamento.setServico(rs.getInt("fk_id_servico"));
                agendamento.setHorario(rs.getInt("fk_id_horario"));
                agendamento.setData(dataFormatada);
                agendamento.setObservacao(rs.getString("observacao"));                
                agendamentos.add(agendamento);

                
                
            }
            
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "ListarClienteDAO: " + erro);
        }
        
        return agendamentos;
    }
    
    public void excluirAgendamento(int id){
        try{
            con = new ConexaoBD().conectaBD();
  
            String sql = "select * from agendamento where id_agendamento = ?";
            
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            
            ResultSet rs = pstm.executeQuery();
            
            if(rs.next()){
                 
                String sql2 = "delete from agendamento where id_agendamento = ?";
            
                PreparedStatement pstm2 = con.prepareStatement(sql2);
                pstm2.setInt(1, id);

                pstm2.execute();
                pstm2.close();
                
            }
            
            
            
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null,"DeletarAgendamentoDAO: " + erro);
        }
        
    }
}
