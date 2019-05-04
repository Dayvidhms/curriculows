package model;

import conexao.Conexao;
import controller.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO {
    
    private Connection conexao;
    
    public UsuarioDAO(){
        try {
            this.conexao = new Conexao().getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insertUser(Usuario usuario) {
                String insertCliente = "insert into usuario(nome, phone, usuario, senha)"
                + "values (?, ?, ?, ?)";

        try {
            PreparedStatement insere = this.conexao.prepareStatement(insertCliente);
            insere.setString(1, usuario.getNomeCompleto());
            insere.setString(2, usuario.getPhoneWhatsApp());
            insere.setString(3, usuario.getUsuario());
            insere.setString(4, usuario.getSenha());

            insere.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public Usuario loginUser(String user, String senha){
        String select = "select * from usuario where usuario = ? and senha = ?";
        Usuario usuario;
        
        try {
            PreparedStatement selecionar = this.conexao.prepareStatement(select);
            
            selecionar.setString(1, user);
            selecionar.setString(2, senha);
            
            ResultSet dados = selecionar.executeQuery();
            if(dados.next()){
                usuario = new Usuario();
                usuario.setId(dados.getInt("usuario_id"));
                usuario.setNomeCompleto(dados.getString("nome"));
                usuario.setPhoneWhatsApp(dados.getString("phone"));
                usuario.setSenha(dados.getString("phone"));
                usuario.setUsuario(dados.getString("usuario"));
                return usuario;
            }else{
                return null;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
