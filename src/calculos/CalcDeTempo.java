package calculos;

import modelos.Titulo;

public class CalcDeTempo {
    private int tempoTotal;

    public int getTempoTotal() {
        return tempoTotal;
    }

//    public void incluiFilme(Filme f){
//        this.tempoTotal += f.getDuracaoEmMinutos();
//    }// Design das classes
//
//    public void incluiSerie(Serie s){
//        this.tempoTotal += s.getDuracaoEmMinutos();
//    }

    public void inclui(Titulo t){
        this.tempoTotal += t.getDuracaoEmMinutos();
    }
}
