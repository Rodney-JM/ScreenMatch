package excecao;

public class ErroDeConversaoDeAnoException extends RuntimeException {
    private String mensagem;

    public ErroDeConversaoDeAnoException(String m){
        this.mensagem = m;
    }


    public String getMensagem() {
        return this.mensagem;
    }
}
