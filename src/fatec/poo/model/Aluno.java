
package fatec.poo.model;

/* @author 0030481613035 */
public class Aluno extends Pessoa{
    private String escolaridade;

    public Aluno(String cpf, String nome) {
        super(cpf, nome);
    }
    
    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }
    
    
}
