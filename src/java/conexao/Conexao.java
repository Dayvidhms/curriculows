package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    public Connection getConnection() throws SQLException, ClassNotFoundException{
       Class.forName("com.mysql.jdbc.Driver");
        
        try{
        
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/curriculoti?useSSL=false&"
                + "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                "root", "123456");
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
        
        
    }
    
}
