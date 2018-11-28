
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


/*@author Sabrina */
public class DaoTurma {
    private Connection con;
    
    public DaoTurma(Connection con){
        this.con = con;
    }
    public void inserir(Turma turma){
        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement("insert into tbTurma(sigla_turma, sigla_curso, nome_t, qnt_vagas, dt_inicio, periodo,dt_term) values(?,?,?,?,?,?,?)");
            ps.setString(1, turma.getCurso().getSigla());
            ps.setString(2, turma.getSiglaTurma());
            ps.setString(3,turma.getDescricao());
            ps.setInt(4,turma.getQtdVagas());
            ps.setString(5, turma.getDataInicio());
            ps.setString(6, turma.getPeriodo());
            ps.setString(7, turma.getDataTermino());
            
            ps.execute();
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }
    public void alterar(Turma turma){
        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement("update table tbTurma set sigla_curso = ?, nome_t = ?, qnt_vagas = ?, dt_inicio = ?, periodo = ?, dt_term= ? where sigla_turma = ?");
            ps.setString(1, turma.getCurso().getSigla());
            ps.setString(2,turma.getDescricao());
            ps.setInt(3,turma.getQtdVagas());
            ps.setString(4, turma.getDataInicio());
            ps.setString(5, turma.getPeriodo());
            ps.setString(6, turma.getDataTermino());

            ps.execute();
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }
    public Turma consultar(String sigla){
        Turma tur = null;
        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement("Select * from tbTurma where sigla_turma = ?");
            ps.setString(1, sigla);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                tur = new Turma(sigla, rs.getString("nome_t"));
                tur = new Turma(sigla, rs.getString(("qnt_vagas")));//este é inteiro mas da erro com getint
                tur = new Turma(sigla, rs.getString("dt_inicio"));
                tur = new Turma(sigla, rs.getString("periodo"));
                tur = new Turma(sigla, rs.getString("dt_term"));
                
            }
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
        return (tur);
    }
    public void excluir(Turma turma){
        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement("delete from tbTurma where sigla_turma = ?");
            ps.setString(1, turma.getSiglaTurma());
            
            ps.execute();            
        }catch(SQLException ex) {
            System.out.println(ex.toString());
        }
    }
=======
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
    
>>>>>>> 714ef8d031d792b110d6513219dd42d94460af7d
}
