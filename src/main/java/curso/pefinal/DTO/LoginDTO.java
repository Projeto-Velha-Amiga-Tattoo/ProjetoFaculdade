package curso.pefinal.DTO;

public class LoginDTO {
    
    private int id_login;
    private String user;
    private String password;
    private int id_usuario;

    public LoginDTO() {

    }
    
    public LoginDTO(String user, String senha) {
        this.user = user;
        this.password = password;
    }

    public int getId_login() {
        return id_login;
    }

    public void setId_login(int id_login) {
        this.id_login = id_login;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    
}
