package principal;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import excecao.ErroDeConversaoDeAnoException;
import modelos.Titulo;
import modelos.TituloOmdb;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.List;
import java.util.Scanner;


public class SearchControler {
    private Gson gson;
    private Scanner scan;

    public SearchControler() {
        scan = new Scanner(System.in);
        gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create(); //padroniza a escrita dos atributos para o código
        }

        public void searchMovies() throws IOException {
            String searchedMovie = "";
            List<Titulo> movies = new ArrayList<>();

            while (!searchedMovie.equalsIgnoreCase("sair")) {
                System.out.println("Qual filme você deseja pesquisar?");
                searchedMovie = scan.nextLine();

                if (searchedMovie.equalsIgnoreCase("sair")) {
                    break;
                }

                String address = "https://www.omdbapi.com/?t=" + searchedMovie + "&apikey=4e1d39e5";

                address = address.replaceAll(" ", "+").toLowerCase();
                try {
                    //Realiza uma conexão entre cliente e servidor e devolve em forma do request
                    HttpClient client = HttpClient.newHttpClient();
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri(URI.create(address))
                            .build();//pega o objeto e monta ele através de métodos

                    HttpResponse<String> response = client
                            .send(request, HttpResponse.BodyHandlers.ofString());

                    System.out.println(response.body());

                    TituloOmdb meuTituloOmdb = gson.fromJson(response.body(), TituloOmdb.class);

                    //try{
                    Titulo meuTitulo = new Titulo(meuTituloOmdb);
                    System.out.println(meuTitulo);

                    movies.add(meuTitulo);
                } catch (NumberFormatException e) {
                    System.out.println("Aconteceu um imprevisto! Tente novamente");
                    System.out.println(e.getMessage());
                } catch (IllegalFormatException e) {
                    System.out.println("Foi escrito de forma incorreta, verifique o endereço e tente novamente");
                } catch (ErroDeConversaoDeAnoException e) {
                    System.out.println(e.getMensagem());
                }catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }  finally {
                    System.out.println("O programa terminou...");
                }
            }

            FileWriter writer = new FileWriter("movies.json");
            writer.write(gson.toJson(movies));
            writer.close();
        }
    }