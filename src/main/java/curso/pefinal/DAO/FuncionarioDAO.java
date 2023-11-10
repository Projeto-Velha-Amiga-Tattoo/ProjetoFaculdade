package curso.pefinal.DAO;


import curso.pefinal.DTO.EnderecoDTO;
import curso.pefinal.DTO.FuncionarioDTO;
import curso.pefinal.DTO.LoginDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FuncionarioDAO {
     Connection con;
    ArrayList<FuncionarioDTO> funcionarios = new ArrayList<>();
    public void cadastrarFuncionario(FuncionarioDTO funcionarioDTO){
        
                
        EnderecoDTO end;
        
        Integer id_gerado = null;        
        try{
            con = new ConexaoBD().conectaBD();
            end = funcionarioDTO.getEndereco();
            
            PreparedStatement pstm = con.prepareStatement("insert into endereco(rua,numero,complemento,bairro,cidade,cep,estado) values(?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, end.getRua());
            pstm.setInt(2, end.getNumero());
            pstm.setString(3, end.getComplemento());
            pstm.setString(4, end.getBairro());
            pstm.setString(5, end.getCidade());
            pstm.setString(6, end.getCep());
            pstm.setInt(7, end.getEstado());
            pstm.execute();
            
            ResultSet id_end = pstm.getGeneratedKeys();
            if(id_end.next()){
                id_gerado = id_end.getInt(1);
            }
            
            pstm.close();
            
            
            LoginDTO login;
            
            login = funcionarioDTO.getLogin();
            Integer id_gerado2 = null;  
            
            PreparedStatement pstm2 = con.prepareStatement("insert into login(user,password,id_usuario) values(?,?,?)",Statement.RETURN_GENERATED_KEYS);
            pstm2.setString(1, login.getUser());
            pstm2.setString(2, login.getPassword());
            pstm2.setInt(3, 1);
            pstm2.execute();
            
            ResultSet id_login = pstm2.getGeneratedKeys();
            if(id_login.next()){
                id_gerado2 = id_login.getInt(1);
            }
            
            pstm2.close();
            
            String sql = "insert into funcionario(fk_id_login,fk_id_endereco,nome,cpf,data_nasc,telefone,funcao) values(?,?,?,?,?,?,?)";
            
            PreparedStatement pstm3 = con.prepareStatement(sql);
            pstm3.setInt(1, id_gerado2);
            pstm3.setInt(2, id_gerado);
            pstm3.setString(3, funcionarioDTO.getNome());
            pstm3.setString(4, funcionarioDTO.getCpf());
            pstm3.setString(5,funcionarioDTO.getData_nasc());
            pstm3.setString(6, funcionarioDTO.getTelefone());
            pstm3.setInt(7, funcionarioDTO.getFuncao());
            pstm3.execute();
            pstm3.close();   

 

        }catch(Exception erro){
            JOptionPane.showMessageDialog(null, "CadastrarFuncionarioDAO: " + erro);
        }
    }
    
    public ArrayList<FuncionarioDTO> listarFuncionario(){
        
        int id_end;
        int id_login;
        try{
            con = new ConexaoBD().conectaBD();
            String sql = "select * from funcionario";
        
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            
            
            while(rs.next()){
                
                
                
                //formatando a data
                Date data = rs.getDate("data_nasc");
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String dataFormatada = dateFormat.format(data);
                        
                //pegando o id do endereço
                id_end = rs.getInt("fk_id_endereco");
                
                String sql2 = "select * from endereco where id_endereco = ?";
        
                PreparedStatement pstm2 = con.prepareStatement(sql2);
                pstm2.setInt(1, id_end);
                ResultSet rs2 = pstm2.executeQuery();
                
                //pegando o id do login
                id_login = rs.getInt("fk_id_login");
                
                String sql3 = "select * from login where id_login = ?";
        
                PreparedStatement pstm3 = con.prepareStatement(sql3);
                pstm3.setInt(1, id_login);
                ResultSet rs3 = pstm3.executeQuery();
                
                if(rs2.next() && rs3.next()){
                    EnderecoDTO endereco = new EnderecoDTO(); 
                    endereco.setId_endereco(rs2.getInt("id_endereco"));
                    endereco.setRua(rs2.getString("rua"));
                    endereco.setNumero(rs2.getInt("numero"));
                    endereco.setBairro(rs2.getString("bairro"));
                    endereco.setComplemento(rs2.getString("complemento"));
                    endereco.setCep(rs2.getString("cep"));
                    endereco.setCidade(rs2.getString("cidade"));
                    endereco.setEstado(rs2.getInt("estado"));
                    
                    LoginDTO login = new LoginDTO();
                    login.setUser(rs3.getString("user"));
                    login.setPassword(rs3.getString("password"));
                    
                    FuncionarioDTO funcionario = new FuncionarioDTO();
                    funcionario.setId_funcionario(rs.getInt("id_funcionario"));
                    funcionario.setNome(rs.getString("nome"));
                    funcionario.setCpf(rs.getString("CPF"));
                    funcionario.setData_nasc(dataFormatada);
                    funcionario.setTelefone(rs.getString("telefone"));
                    funcionario.setEndereco(endereco);
                    funcionario.setLogin(login);
                    funcionario.setFuncao(rs.getInt("funcao"));
                    funcionarios.add(funcionario);
                }else{
                    JOptionPane.showMessageDialog(null, "Endereço ou Login não encontrado");
                }
                
                
                
                
            }
            
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "ListarFuncionarioDAO: " + erro);
        }
        
        return funcionarios;
    }
    
    //Retorna qual funcionario vai alterar
    public FuncionarioDTO funcionarioAlteracao(int id){
        
        int id_end;
        int id_login;
        try{
            
            con = new ConexaoBD().conectaBD();
                        
            
            String sql = "select * from funcionario where id_funcionario = ?";
            //preparando a conexao
            PreparedStatement pstm = con.prepareStatement(sql);
            
            //vai mostrar o que vai para a comparação no BD
            //cada linha substitui uma ?, e o número é a ordem
            pstm.setInt(1, id);
            
            //executa o comando 
            ResultSet rs = pstm.executeQuery();
            
            if(rs.next()){
                
                //formatando a data
                Date data = rs.getDate("data_nasc");
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String dataFormatada = dateFormat.format(data);
                
                //pegando o id do endereço
                id_end = rs.getInt("fk_id_endereco");
                
                String sql2 = "select * from endereco where id_endereco = ?";
        
                PreparedStatement pstm2 = con.prepareStatement(sql2);
                pstm2.setInt(1, id_end);
                ResultSet rs2 = pstm2.executeQuery();
                
                //pegando o id do login
                id_login = rs.getInt("fk_id_login");
                
                String sql3 = "select * from login where id_login = ?";
        
                PreparedStatement pstm3 = con.prepareStatement(sql3);
                pstm3.setInt(1, id_login);
                ResultSet rs3 = pstm3.executeQuery();
                
                if(rs2.next() && rs3.next()){
                    EnderecoDTO endereco = new EnderecoDTO(); 
                    endereco.setId_endereco(rs2.getInt("id_endereco"));
                    endereco.setRua(rs2.getString("rua"));
                    endereco.setNumero(rs2.getInt("numero"));
                    endereco.setBairro(rs2.getString("bairro"));
                    endereco.setComplemento(rs2.getString("complemento"));
                    endereco.setCep(rs2.getString("cep"));
                    endereco.setCidade(rs2.getString("cidade"));
                    endereco.setEstado(rs2.getInt("estado"));


                    LoginDTO login = new LoginDTO();
                    login.setUser(rs3.getString("user"));
                    login.setPassword(rs3.getString("password"));
                    
                    FuncionarioDTO funcionario = new FuncionarioDTO();
                    funcionario.setId_funcionario(rs.getInt("id_funcionario"));
                    funcionario.setNome(rs.getString("nome"));
                    funcionario.setCpf(rs.getString("CPF"));
                    funcionario.setData_nasc(dataFormatada);
                    funcionario.setTelefone(rs.getString("telefone"));
                    funcionario.setEndereco(endereco);
                    funcionario.setLogin(login);
                    funcionario.setFuncao(rs.getInt("funcao"));
                    
                    return funcionario;
                }else{  
                    JOptionPane.showMessageDialog(null, "Endereço ou Login não encontrado");
                    return null;
                }
                

            }else{  
                JOptionPane.showMessageDialog(null, "Funcionário não encontrado");
                return null;
            }
            
            
            
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "funcionarioAlteracaoDAO: " + erro);
            return null;
        }
        
    }
    
    //Alteração do funcionário
    public void alterarFuncionario(FuncionarioDTO funcionarioDTO){
        
        EnderecoDTO end;
        int id_end;
        
        LoginDTO login;
        int id_login;
        try{
            con = new ConexaoBD().conectaBD();
            
            String sql = "update funcionario set nome = ?, cpf = ?, data_nasc = ?,telefone = ?, funcao = ? where id_funcionario = ?";
            
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, funcionarioDTO.getNome());
            pstm.setString(2, funcionarioDTO.getCpf());
            pstm.setString(3,funcionarioDTO.getData_nasc());
            pstm.setString(4, funcionarioDTO.getTelefone());
            pstm.setInt(5, funcionarioDTO.getFuncao());
            pstm.setInt(6, funcionarioDTO.getId_funcionario());
            
            pstm.execute();
            pstm.close();   
            
            String sql2 = "select * from funcionario where id_funcionario = ?";
            
            PreparedStatement pstm2 = con.prepareStatement(sql2);
            pstm2.setInt(1, funcionarioDTO.getId_funcionario());
            
            ResultSet rs = pstm2.executeQuery();
            
            if(rs.next()){
                
                id_end = rs.getInt("fk_id_endereco");
                end = funcionarioDTO.getEndereco();
            
                String sql3 = "update endereco set rua = ?,numero = ?, complemento = ?, bairro = ?, cidade = ?, estado = ?, cep = ? where id_endereco = ?";
                PreparedStatement pstm3 = con.prepareStatement(sql3);
                pstm3.setString(1, end.getRua());
                pstm3.setInt(2, end.getNumero());
                pstm3.setString(3, end.getComplemento());
                pstm3.setString(4, end.getBairro());
                pstm3.setString(5, end.getCidade());
                pstm3.setInt(6, end.getEstado());
                pstm3.setString(7, end.getCep());
                pstm3.setInt(8, id_end);

                pstm3.execute();
                pstm3.close();
                
                id_login = rs.getInt("fk_id_login");
                login = funcionarioDTO.getLogin();
                
                String sql4 = "update login set user = ?,password = ? where id_login = ?";
                PreparedStatement pstm4 = con.prepareStatement(sql4);
                pstm4.setString(1, login.getUser());
                pstm4.setString(2, login.getPassword());
                pstm4.setInt(3,id_login);
                
                pstm4.execute();
                pstm4.close();
                
            }else{
                JOptionPane.showMessageDialog(null, "Funcionário não encontrado");
            }
            
            

        }
        catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "AlterarFuncionarioDAO: " + erro);
        }
        
    }
    
    public void excluirFuncionario(int id){
        try{
            con = new ConexaoBD().conectaBD();
            int id_end;
            int id_login;
            String sql = "select * from funcionario where id_funcionario = ?";
            
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            
            ResultSet rs = pstm.executeQuery();
            
            if(rs.next()){
                
               
                
                String sql2 = "delete from funcionario where id_funcionario = ?";
            
                PreparedStatement pstm2 = con.prepareStatement(sql2);
                pstm2.setInt(1, id);

                pstm2.execute();
                pstm2.close();
                
                id_end = rs.getInt("fk_id_endereco");
                String sql3 = "delete from endereco where id_endereco = ?";
            
                PreparedStatement pstm3 = con.prepareStatement(sql3);
                pstm3.setInt(1, id_end);

                pstm3.execute();
                pstm3.close();
                
                id_login = rs.getInt("fk_id_login");
                String sql4 = "delete from login where id_login = ?";
            
                PreparedStatement pstm4 = con.prepareStatement(sql4);
                pstm4.setInt(1, id_login);

                pstm4.execute();
                pstm4.close();
            }
            
            
            
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null,"DeletarFuncionarioDAO: " + erro);
        }
        
    }
}
