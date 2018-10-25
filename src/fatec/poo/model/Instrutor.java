package fatec.poo.model;
/*@author 0030481613035*/
public class Instrutor extends Pessoa{
    private String formacao;
    private String areaFormacao;
    private Turma[] turmas;
    private int qntTurma;
            
    public Instrutor(String cpf, String nome) {
        super(cpf, nome);
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public void setAreaFormacao(String areaFormacao) {
        this.areaFormacao = areaFormacao;
    }
    
    void addTurma(Turma t ){
        turmas[qntTurma++] = t;
    }
    
    
}
