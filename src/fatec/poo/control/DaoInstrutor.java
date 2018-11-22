/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.control;

import fatec.poo.model.Instrutor;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author 0030481713006
 */
public class DaoInstrutor{
    
    
    private Connection conn;
    
    public DaoInstrutor(Connection conn){
        this.conn = conn;
    }
    
    public Instrutor consultar(String cpf){
        Instrutor instrutor = null;
        try{
            PreparedStatement ps =  conn.prepareStatement("SELECT * FROM tbInstrutor WHERE cpf = ?");
            ps.setString(1, cpf);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                instrutor = new Instrutor(cpf, rs.getString("nome"));
                instrutor.setAreaFormacao(rs.getString("area_formacao"));
                instrutor.setBairro(rs.getString("bairro"));
                instrutor.setCelular(rs.getString("celular"));
                instrutor.setCep(rs.getString("cep"));
                instrutor.setCidade(rs.getString("cidade"));
                instrutor.setDataNasc(rs.getString("data_nasc"));
                instrutor.setEmail(rs.getString("email"));
                instrutor.setEndereco(rs.getString("endereco"));
                instrutor.setEstado(rs.getString("estado"));
                instrutor.setEstadoCivil(rs.getString("estado_civil"));
                instrutor.setFormacao(rs.getString("formacao"));
                instrutor.setNumero(rs.getInt("numero"));
                instrutor.setRg(rs.getString("rg"));
                instrutor.setSexo(rs.getString("sexo"));
                instrutor.setTelefone(rs.getString("telefone"));
                
            }
        }catch(SQLException e)
        {
            System.out.println(e.toString());
        }
        return instrutor;
    }
    
    public void inserir(Instrutor instrutor)
    {
        try
        {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO tbInstrutor "
                    + "(cpf, nome, area_formacao, bairro, celular, cep, cidade, data_nasc,"
                    + " email, endereco, estado, estado_civil, formacao, numero, rg, sexo, telefone) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            this.setPrepareStatement(ps, instrutor);
            
            ps.execute();
        } 
        catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    public void alterar(Instrutor instrutor)
    {
        try
        {
            PreparedStatement ps = conn.prepareStatement("UPDATE tbInstrutor "
                    + "cpf = ?, nome = ? , area_formacao = ?, bairro = ?, celular = ?, cep = ?, cidade = ?, data_nasc = ?,"
                    + " email = ?, endereco = ?, estado = ?, estado_civil = ?, formacao = ?, numero = ?, rg = ?, sexo = ?, telefone = ? ");
            this.setPrepareStatement(ps, instrutor);
            
            ps.execute();
        } 
        catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    public void excluir(Instrutor instrutor)
    {
        try
        {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM tbinstrutor WHERE cpf = ?");
            ps.setString(0, instrutor.getCpf());
            ps.execute();
        } 
        catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    
    private void setPrepareStatement(PreparedStatement ps, Instrutor instrutor)
    {
        
        try{
            ps.setString(1, instrutor.getCpf());
            ps.setString(2, instrutor.getNome());
            ps.setString(3, instrutor.getAreaFormacao());
            ps.setString(4, instrutor.getBairro());
            ps.setString(5, instrutor.getCelular());
            ps.setString(6, instrutor.getCep());
            ps.setString(7, instrutor.getCidade());
            ps.setString(8, instrutor.getDataNasc());
            ps.setString(9, instrutor.getEmail());
            ps.setString(10, instrutor.getEndereco());
            ps.setString(11, instrutor.getEstado());
            ps.setString(12, instrutor.getEstadoCivil());
            ps.setString(13, instrutor.getFormacao());
            ps.setInt(14, instrutor.getNumero());
            ps.setString(15, instrutor.getSexo());
            ps.setString(16, instrutor.getTelefone());
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        
    }
}
