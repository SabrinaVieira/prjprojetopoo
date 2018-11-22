/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.control;

import fatec.poo.model.Turma;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author 0030481623010
 */
public class DaoTurma {
    
    private Connection conn;
    
    public DaoTurma(Connection conn) {
         this.conn = conn;
    }
    
    public void inserir(Turma turma) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO tbturma(Sigla_Turma, Descricao_Turma, Vagas_Turma, Periodo_Turma, Inicio_Turma, Termino_Turma) VALUES(?,?, ?, ?, ?, ?)");
            ps.setString(1, turma.getSiglaTurma());
            ps.setString(2, turma.getDescricao());
            ps.setInt(3, turma.getQtdVagas());
            ps.setString(4, turma.getPeriodo());
            ps.setString(5, turma.getDataInicio());
            ps.setString(6, turma.getDataTermino());
            
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
     public void alterar(Turma turma) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE tbturma set Sigla_Turma= ?" +
                                                 "where Descricao_Turma = ?");
            
            ps.setString(1, turma.getSiglaTurma());
            ps.setString(2, turma.getDescricao());
           
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
     
     public void consultar(String sigla) {
         Turma t = null;
         PreparedStatement ps = null;
         
         try {
             ps = conn.prepareStatement("SELECT * from tbturma WHERE " +
                                                      "Sigla_Turma= ? ");
             
             ps.setString(1, sigla);
             
             ResultSet rs = ps.executeQuery();
             
             if (rs.next() == true) {
                 t = new Turma (sigla, rs.getString("Descricao_Turma"));
             }
             
         } catch (SQLException ex) {
             System.out.println(ex.toString());
         }
     }
     
     public void excluir(String sigla) {
         Turma t = null;
         
         PreparedStatement ps = null;
         
         try {
             ps = conn.prepareStatement("DELETE from tbturma WHERE " +
                                                     "Sigla_Turma= ? ");
             
             ps.setString(1, sigla);
             
             ps.execute();
         } catch(SQLException ex) {
             System.out.println(ex.toString());
         }
     }
    
}
