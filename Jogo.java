import java.util.Random;

public class Jogo {
    //Variaveis locais = não inicializam
    //Variaveis de Classe e referência = inicializam
    //Inicialização = numeros = 0; string, classes = null;boolean = false; char = \0
    public static void main(String[] args) throws Exception {
        //Objeto p = forma comum de falar
        //Inicializando os personagens com os atributos (energia, fome, sono)
        Personagem cacador = new Personagem(10, 0,0);
        Personagem soneca = new Personagem(2, 4,10);
        Personagem guloso = new Personagem(4, 10,2);

        //Definindo nomes para os personagens
        cacador.setNome("Zezinho");
        soneca.setNome("Huguinho");
        guloso.setNome("Luizinho");
        //Classe para numero aleatórios
        Random gerador = new Random();
        //1: caçar
        //2: comer
        //3: dormir
        while(true){
            int oQueFazer = gerador.nextInt(3)+1; //[0,2]:sem somar 1 - [1,3]:somando 1
            int debuff = oQueFazer+1;
            switch(oQueFazer){
                case 1:
                    cacador.cacar();
                    guloso.cacar(debuff);
                    break;
                case 2:
                    cacador.comer();
                    guloso.comer(debuff);
                    break;
                case 3:
                    cacador.dormir();
                    guloso.dormir();
                    break;
            }
            System.out.println("\n=======================");
            //"Congela" a execução em 2s →passar o parametro em milissegundos
            Thread.sleep(2000);
        }
        
        // cacador.energia = 10;
        // cacador.fome = 0;
        // cacador.sono = 0;
        // cacador.cacar();
        // cacador.comer();
        // cacador.dormir();
    }
}
