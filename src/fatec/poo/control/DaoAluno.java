/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.control;

<<<<<<< HEAD
/**
 *
 * @author Sabrina
 */
public class DaoAluno {
    
=======
import fatec.poo.model.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author 0030481713006
 */
public class DaoAluno {

    private Connection conn;
    
    public DaoAluno(Connection conn){
        this.conn = conn;
    }
    
    public Aluno consultar(String cpf){
        Aluno aluno = null;
        try{
            PreparedStatement ps =  conn.prepareStatement("SELECT * FROM tbAluno WHERE cpf = ?");
            ps.setString(1, cpf);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                aluno = new Aluno(cpf, rs.getString("nome"));
                aluno.setEscolaridade(rs.getString("escolaridade"));
                aluno.setBairro(rs.getString("bairro"));
                aluno.setCelular(rs.getString("celular"));
                aluno.setCep(rs.getString("cep"));
                aluno.setCidade(rs.getString("cidade"));
                aluno.setDataNasc(rs.getString("data_nasc"));
                aluno.setEmail(rs.getString("email"));
                aluno.setEndereco(rs.getString("endereco"));
                aluno.setEstado(rs.getString("estado"));
                aluno.setEstadoCivil(rs.getString("estado_civil"));
                aluno.setNumero(rs.getInt("numero"));
                aluno.setRg(rs.getString("rg"));
                aluno.setSexo(rs.getString("sexo"));
                aluno.setTelefone(rs.getString("telefone"));
                
            }
        }catch(SQLException e)
        {
            System.out.println(e.toString());
        }
        return aluno;
    }
    
    public void inserir(Aluno aluno)
    {
        try
        {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO tbAluno "
                    + "(cpf, nome, escolaridade, bairro, celular, cep, cidade, data_nasc,"
                    + " email, endereco, estado, estado_civil, numero, rg, sexo, telefone) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            this.setPrepareStatement(ps, aluno);
            
            ps.execute();
        } 
        catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    public void alterar(Aluno aluno)
    {
        try
        {
            PreparedStatement ps = conn.prepareStatement("UPDATE tbAluno "
                    + "cpf = ?, nome = ? , escolaridade = ?, bairro = ?, celular = ?, cep = ?, cidade = ?, data_nasc = ?,"
                    + " email = ?, endereco = ?, estado = ?, estado_civil = ?, numero = ?, rg = ?, sexo = ?, telefone = ? ");
            this.setPrepareStatement(ps, aluno);
            
            ps.execute();
        } 
        catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    public void excluir(Aluno aluno)
    {
        try
        {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM tbaluno WHERE cpf = ?");
            ps.setString(0, aluno.getCpf());
            ps.execute();
        } 
        catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    
    private void setPrepareStatement(PreparedStatement ps, Aluno aluno)
    {
        
        try{
            ps.setString(1, aluno.getCpf());
            ps.setString(2, aluno.getNome());
            ps.setString(3, aluno.getEscolaridade());
            ps.setString(4, aluno.getBairro());
            ps.setString(5, aluno.getCelular());
            ps.setString(6, aluno.getCep());
            ps.setString(7, aluno.getCidade());
            ps.setString(8, aluno.getDataNasc());
            ps.setString(9, aluno.getEmail());
            ps.setString(10, aluno.getEndereco());
            ps.setString(11, aluno.getEstado());
            ps.setString(12, aluno.getEstadoCivil());
            ps.setInt(13, aluno.getNumero());
            ps.setString(14, aluno.getSexo());
            ps.setString(15, aluno.getTelefone());
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        
    }

>>>>>>> 714ef8d031d792b110d6513219dd42d94460af7d
}
