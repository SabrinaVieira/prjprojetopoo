
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fatec.poo.control;

import fatec.poo.control.DaoCurso;
import fatec.poo.model.Turma;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;



/*@author Sabrina */
public class DaoTurma {
    private Connection con;
    
    public DaoTurma(Connection con){
        this.con = con;
    }
    public void inserir(Turma turma){
        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement("insert into tbTurma(sigla_turma,"
                                    + " sigla_curso, nome_t, qnt_vagas, "
                                    + "dt_inicio, periodo, dt_term) "
                                    + "values(?,?,?,?,?,?,?)");
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
            ps = con.prepareStatement("UPDATE table tbTurma set sigla_curso = ?,"
                                    + " nome_t = ?, qnt_vagas = ?, dt_inicio = ?,"
                                    + " periodo = ?, dt_term= ? "
                                    + "WHERE sigla_turma = ?");
            ps.setString(1, turma.getCurso().getSigla());
            ps.setString(2,turma.getDescricao());
            ps.setInt(3,turma.getQtdVagas());
            ps.setString(4, turma.getDataInicio());
            ps.setString(5, turma.getPeriodo());
            ps.setString(6, turma.getDataTermino());
            ps.setString(7, turma.getSiglaTurma());

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
                //tur.setCurso(DaoCurso.consultar(rs.getString("sigla_curso")));
                
                tur.setQtdVagas(rs.getInt("qtd_vagas"));
                tur.setDataInicio(rs.getString("dt_inicio"));
                tur.setPeriodo(rs.getString("periodo"));
                
                try {
                    SimpleDateFormat dbFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    SimpleDateFormat targetFt = new SimpleDateFormat("dd/MM/yyyy");
                    Date date = dbFormat.parse(rs.getString("dt_term"));
                    tur.setDataTermino(targetFt.format(date));
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
                
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
}
