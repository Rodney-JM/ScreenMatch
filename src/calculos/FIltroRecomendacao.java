package calculos;

public class FIltroRecomendacao {
    public void filtra(Classificacao c){
        if (c.getClassificacao()>=4){
            System.out.println("Está entre os preferidos do momento");
        } else if (c.getClassificacao()>=2) {
            System.out.println("É bem avaliado do momento");
        }else{
            System.out.println("Coloque na sua lista para assistir depois");
        }
    }
}
