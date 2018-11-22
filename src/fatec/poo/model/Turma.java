/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.model;

import java.util.ArrayList;

/**
 *
 * @author 0030481713006
 */
public class Turma {
    private String siglaTurma;
    private String descricao;
    private String dataInicio;
    private String dataTermino;
    private String periodo;
    private int qtdVagas;
    private String observacoes;
    private Instrutor instrutor;
    private Curso curso;
    private ArrayList<Matricula> matriculas;
    
    public Turma(String sigla, String descricao){
        this.siglaTurma = sigla;
        this.descricao = descricao;
        
        this.matriculas = new ArrayList<Matricula>();
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataTermino(String dataTermino) {
        this.dataTermino = dataTermino;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public void setQtdVagas(int qtdVagas) {
        this.qtdVagas = qtdVagas;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    
    public void setInstrutor(Instrutor instrutor){
        this.instrutor = instrutor;
    }
    
    public void emitirListaFrequencia(){}
    
    public void setCurso(Curso curso)
    {
        this.curso = curso;
    }
    
    public void addMatricula(Matricula matricula){
        this.matriculas.add(matricula);
        matricula.setTurma(this);
    }

    public String getSiglaTurma() {
        return siglaTurma;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public String getDataTermino() {
        return dataTermino;
    }

    public String getPeriodo() {
        return periodo;
    }

    public int getQtdVagas() {
        return qtdVagas;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public Instrutor getInstrutor() {
        return instrutor;
    }

    public Curso getCurso() {
        return curso;
    }

    public ArrayList<Matricula> getMatriculas() {
        return matriculas;
    }
    
    
    
    
}
