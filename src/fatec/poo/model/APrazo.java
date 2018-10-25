/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.model;

/**
 *
 * @author 0030481623010
 */
public class APrazo {
    private double valor, taxaJuros;
    private String dtVencimento;
    private int qtdeMensalidade;

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setTaxaJuros(double taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

    public void setDtVencimento(String dtVencimento) {
        this.dtVencimento = dtVencimento;
    }

    public void setQtdeMensalidade(int qtdeMensalidade) {
        this.qtdeMensalidade = qtdeMensalidade;
    }
    
    
    
    
}
