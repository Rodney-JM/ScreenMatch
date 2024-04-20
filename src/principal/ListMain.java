package principal;

import modelos.Filme;
import modelos.Serie;
import modelos.Titulo;

import java.util.*;

public class ListMain {
    public static void main(String[] args) {
        Filme avatar = new Filme("Avatar", 2017);
        avatar.avalia(10);
        Filme bladeRunner = new Filme("Blade Runner 2049", 2017);
        bladeRunner.avalia(10);
        Filme loboDeWallStreet = new Filme("O Lobo de Wall Street", 2013);
        loboDeWallStreet.avalia(8);

        Serie teenWolf = new Serie("Teen Wolf", 2011);

        List<Titulo> listaFilmes = new LinkedList<>();
        listaFilmes.add(avatar);
        listaFilmes.add(bladeRunner);
        listaFilmes.add(loboDeWallStreet);
        listaFilmes.add(teenWolf);

        //listaFilmes.forEach(System.out::println);
        for (Titulo item: listaFilmes){
            System.out.println(item.getNome());
            if (item instanceof Filme){
                Filme filme = (Filme)item;
                System.out.println(filme.getClassificacao());
            }
        }

        ArrayList<String> buscaPorArtista = new ArrayList<>();
        buscaPorArtista.add("Adam Sandler");
        buscaPorArtista.add("Ryan Gosling");
        buscaPorArtista.add("Margot Robbie");

        Collections.sort(buscaPorArtista); //Ordena alfabeticamente, aceita apenas listas de objetos

        Collections.sort(listaFilmes); //foi preciso implementar o compare dentro do Titulo

        //Comparator
        listaFilmes.sort(Comparator.comparing(Titulo::getAnoDeLancamento));//lambda, ordena por ano de lançamento

        System.out.println(listaFilmes);
    }
}
