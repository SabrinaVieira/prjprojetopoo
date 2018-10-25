
package fatec.poo.model;

/**
 *
 * @author 0030481623010
 */
public class Matricula {
    
    private String data;
    private int QtdeFaltas;
    private double Nota;
    private Turma turma;
    
    void Matricula (String matricula) {
        
    }

    public void setQtdeFaltas(int QtdeFaltas) {
        this.QtdeFaltas = QtdeFaltas;
    }

    public void setNota(double Nota) {
        this.Nota = Nota;
    }
    
    void EmitirCarne() {
        
    }
    
    public void setTurma(Turma turma){
        this.turma = turma;
    }
    
}
