/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.control;

import fatec.poo.model.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author 0030481623010
 */
public class DaoCurso {
    private Connection conn;
    
    public DaoCurso (Connection conn) {
        this.conn = conn;
    }
    
    public void inserir(Curso curso) {
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement("INSERTO INTO tbcurso (Sigla_Curso, " +
                                        "Nome_Curso, Carga_Curso, Valor_Curso," +
                                        "Programa_Curso, Data_Curso, " +
                                        "Valor_Instrutor) Values (?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, curso.getSigla());
            ps.setString(2, curso.getNome());
            ps.setInt(3, curso.getCargaHoraria());
            ps.setDouble(4, curso.getValor());
            ps.setString(5, curso.getPrograma());
            ps.setString(6, curso.getDataVigencia());
            ps.setDouble(7, curso.getValorHoraInstrutor());
            
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        
    }
    
    public void alterar (Curso curso) {
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement("UPDATE table tbcurso tbcurso " +
                                        "Nome_Curso= ?, Carga_Curso= ?, Valor_Curso= ?," +
                                        "Programa_Curso= ?, Data_Curso= ?, " +
                                        "Valor_Instrutor= ? where Sigla_Curso= ?");
            ps.setString(1, curso.getNome());
            ps.setInt(2, curso.getCargaHoraria());
            ps.setDouble(3, curso.getValor());
            ps.setString(4, curso.getPrograma());
            ps.setString(5, curso.getDataVigencia());
            ps.setDouble(6, curso.getValorHoraInstrutor());
            ps.setString(7, curso.getSigla());
            
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    
}
