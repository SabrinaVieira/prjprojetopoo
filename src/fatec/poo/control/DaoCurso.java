package fatec.poo.control;

import fatec.poo.model.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoCurso {
    private Connection con;
    
    public DaoCurso(Connection con){
        this.con = con;
    }
    public void inserir(Curso curso){
        PreparedStatement ps = null;
    }
    
    public void alterar(Curso curso){
        PreparedStatement ps = null;
    }
    
    public Curso consultar(Curso curso){
        Curso cur = null;
        PreparedStatement ps = null;
        
        return (cur);
    }
     public void excluir(Curso curso){
        PreparedStatement ps = null;
     }
     public ArrayList listar(Curso curso){
        PreparedStatement ps = null;
        
     }
     }
}
