package fatec.poo.control;

<<<<<<< HEAD
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*@author Sabrina*/
public class Conexao {
    private String connectionString;
    private String driver;
    private String usuario;
    private String senha;
    private String connection = null;
    
    public Conexao(String usuario, String senha){
        this.usuario = usuario;
        this.senha = senha;
    }
    
    public void setConnectionString(String connectionString){
        this.connectionString = connectionString;
    }
    
    public void setDriver(String driver){
        this.driver = driver;
    }
    
    public Connection conectar(){
        if (connection == null){
=======
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;


public class Conexao {
   private String connectionString;
   private String driver;
   private String usuario;
   private String senha;
   private Connection connection=null;

   public Conexao(String usuario, String senha) {   
        this.usuario = usuario;
        this.senha = senha;   
   }

   public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
   }

   public void setDriver(String driver) {
        this.driver = driver;
   }
   
   public Connection conectar() {
        
	   if (connection == null){
>>>>>>> 714ef8d031d792b110d6513219dd42d94460af7d
	      try {
                 Class.forName(driver);
            
                 connection = DriverManager.getConnection(connectionString, usuario, senha);               
	         System.out.println("Conexao OK");
<<<<<<< HEAD
                }catch (Exception ex) {
                  System.out.println("Falha na Conexao");
                  System.out.println(ex.toString() + ex.getMessage());
                }
	}
        return connection;
    }
    
    public void fecharConexao(){
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException ex){
                System.out.println(ex.toString());    
            }
=======
              }catch (Exception ex) {
                  System.out.println("Falha na Conexao");
                  System.out.println(ex.toString() + ex.getMessage());
          }
	   }
       
	   return connection;
   }
   
   public void fecharConexao(){
        if (connection != null){
	   try {
                  connection.close();
           } catch (SQLException ex) {
                   System.out.println(ex.toString());    
           }
>>>>>>> 714ef8d031d792b110d6513219dd42d94460af7d
        }   
    }
}