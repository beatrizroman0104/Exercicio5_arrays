package exercicio01;

public class MonitorEnergia {
    double[] consumo;
    int[] dias;
    int indice;

    /// construtor alt+insert
    public MonitorEnergia(int tamanho) {
        this.consumo = new double[tamanho];
    }
    /// método
    public void registrar(double valor){
        /// length é um atributo
        if(indice < consumo.length) {
            consumo[indice] = valor;
            indice++;
        }
    }

    public double media(){
        ///  ou return media(1, indice);
        double media = 0;
        for(int i = 0; i < indice; i++){
            media += consumo[i];
        }
        return media / indice;
    }

    public double media(int inicio, int fim){
        double media = 0;
        for(int i = inicio - 1; i < fim; i++){
            media += consumo[i];
        }
        return media / (fim - inicio + 1) ;
    }

    /// não controla -> 1° até a última
    //for(double i : consumo) {
    //    println(i);
    //}

}
