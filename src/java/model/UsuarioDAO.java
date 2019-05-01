package model;

import conexao.Conexao;
import controller.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
            insere.setString(3, usuario.getSenha());
            insere.setString(4, usuario.getUsuario());

            insere.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
