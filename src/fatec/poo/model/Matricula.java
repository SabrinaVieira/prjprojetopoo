
package fatec.poo.model;

/**
 *
 * @author 0030481623010
 */
public class Matricula {
    
    private String data;
    private int QtdeFaltas;
    private double Nota;
    private AVista avista;
    private APrazo aprazo;

    public Matricula(String data) {
        this.data = data;
    }
    
    void Matricula (String matricula) {
        
    }

    public void setQtdeFaltas(int QtdeFaltas) {
        this.QtdeFaltas = QtdeFaltas;
    }

    public void setNota(double Nota) {
        this.Nota = Nota;
    }
    
    public void setAvista (AVista obj) {
        this.avista = obj;
    }
    
    public void setAprazo (APrazo obj) {
        this.aprazo = obj;
    }
    
    public void EmitirCarne() {
        
    }
    
    
    
}
