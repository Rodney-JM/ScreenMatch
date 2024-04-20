package principal;

//import é a forma que referenciamos uma classe dentro de outra

import calculos.CalcDeTempo;
import calculos.FIltroRecomendacao;
import modelos.Episodio;
import modelos.Filme;
import modelos.Serie;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Filme primeiroFilme = new Filme("Interstelar", 2017); //tipo reference
        primeiroFilme.setDuracaoEmMinutos(107);
        primeiroFilme.exibeFichaTecnica();
        primeiroFilme.avalia(3);
        primeiroFilme.avalia(7.8);
        primeiroFilme.avalia(4.2);

        Serie umbrellaAcademy = new Serie("Lost", 1990);
        umbrellaAcademy.setTemporadas(2);
        umbrellaAcademy.setEpisodiosPorTemporada(9);
        umbrellaAcademy.setMinutosPorEpisodio(45);

        System.out.println("Duração para maratonar Umbrella Academy: " + umbrellaAcademy.getDuracaoEmMinutos());

        Filme bladeRunner = new Filme("Blade Runner 2049", 2017);
        bladeRunner.setNome("Blade Runner 2049");
        bladeRunner.setDuracaoEmMinutos(210);

        CalcDeTempo calculadora = new CalcDeTempo();

        calculadora.inclui(primeiroFilme);
        calculadora.inclui(bladeRunner);
        System.out.println(calculadora.getTempoTotal());

        FIltroRecomendacao filtro = new FIltroRecomendacao();
        filtro.filtra(primeiroFilme);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(umbrellaAcademy);
        episodio.setTotalVisualizacoes(232);
        filtro.filtra(episodio);

        Filme terceiroFilme = new Filme("Vertigo", 1969);
        terceiroFilme.setDuracaoEmMinutos(210);
        terceiroFilme.avalia(10);

        ArrayList<Filme> listaDeFilmes = new ArrayList<>(); //Declara um arraylist e o tipo como um objeto
        listaDeFilmes.add(primeiroFilme);
        listaDeFilmes.add(bladeRunner);
        listaDeFilmes.add(terceiroFilme);

        System.out.println(listaDeFilmes.size());
        System.out.println("Primeiro filme = " + listaDeFilmes.get(0).getNome());

        System.out.println(listaDeFilmes.get(0).toString());


    }
}
