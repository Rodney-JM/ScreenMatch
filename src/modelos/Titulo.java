package modelos;

import com.google.gson.annotations.SerializedName;
import excecao.ErroDeConversaoDeAnoException;

import java.time.Year;

//A classe mãe, generalização
public class Titulo implements Comparable<Titulo>{
    @SerializedName("Title") //Name se comporta como title para a API
    private String nome; //String é uma classe
    @SerializedName("Year")
    private int anoDeLancamento;
    private boolean incluidoNoPlano;
    private double avaliacaoSoma;
    private int totalDeAvaliacoes;
    private double duracaoEmMinutos;

    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Titulo(TituloOmdb meuTituloOmdb) {
        this.nome = meuTituloOmdb.title();

        if (meuTituloOmdb.year().length()> 4){
            throw new ErroDeConversaoDeAnoException("Não foi possível converter o ano, porque ele possui " +
                    "mais de 4 caracteres");
        }
        this.anoDeLancamento = Integer.valueOf(meuTituloOmdb.year());
        this.duracaoEmMinutos = Integer.valueOf(meuTituloOmdb.runtime().substring(0, 2));
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnoDeLancamento(int anoDeLancamento){
        this.anoDeLancamento = anoDeLancamento;
    }

    public void setDuracaoEmMinutos(double duracaoEmMinutos){
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public int getTotalDeAvaliacoes(){//get busca o valor
        return totalDeAvaliacoes;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public double getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public String getNome() {
        return nome;
    }

    public void exibeFichaTecnica(){
        System.out.println("Nome do filme: "+ nome);
        System.out.println("Ano de Lançamento: "+ anoDeLancamento);
    }

    public void avalia(double nota){
        avaliacaoSoma += nota;
        totalDeAvaliacoes++;
    }

    double obtemMedia(){
        return avaliacaoSoma/totalDeAvaliacoes;
    }

    @Override
    public int compareTo(Titulo o) {
        return this.getNome().compareTo(o.getNome());
    }

    @Override
    public String toString() {
        return "nome: " + getNome() + "\nano De Lancamento: " + getAnoDeLancamento() + "\nDuração em minutos: " + getDuracaoEmMinutos();
    }
}
