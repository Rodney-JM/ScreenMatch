package modelos;

//modificadores de acesso: public, private, protected

import calculos.Classificacao;

public class Filme extends Titulo implements Classificacao { //herança
    private String diretor;

    public Filme(String nome, int anoDeLancamento) {
        super(nome, anoDeLancamento);
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public int getClassificacao() {
        return (int)obtemMedia()/2;
    }

    @Override
    public String toString() {
        return "Filme: "+ this.getNome() + "("+this.getAnoDeLancamento()+")";
    }
}

//Dentro de um pacote do Java usamos diversas classes que possuem uma relação entre si
//Implements=> para interfaces