public class Personagem {
    //Atributos
    //Encapsulamento
    private String nome; //Inicializada por padrão com null
    private int energia = 10;
    private int fome; //Inicializada por padrão com 0 → implicitamente pelo compilador
    private int sono = 0;//Inicializada com 0 → explicitamente pelo desenvolvedor

     //Constantes em Java
    //Nome = palavras em 'capslock' +'_' entre espaços de palavras
    //Static = significa que a variavel ou método é da classe e não da instância
    //Métodos estáticos(não instância) não podem trabalhar em conjunto com "this"(instância)
    final static int LIMITE_SUPERIOR = 10;


    //Métodos getters/setters
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }

    //Contrutores
    //Diga não a recursão infinita de Construtores
    public Personagem(int energia, int fome, int sono){
        if(energia >= 0 && energia <=10)
            this.energia = energia;
        if(fome >=0 && fome <=10)
            this.fome = fome;
        if(sono >= 0 && sono <=10)
            this.sono = sono;
    }
    public Personagem(String nome, int energia, int fome, int sono){
        //Pedindo ajuda para outro Construtor
        this(energia,fome,sono);//Essa sintaxe só pode ser usada dentro de um Construtor
        this.nome = nome;
        
    }

    //Classe autamente coesa
    //Não gera muita dependencia
    //Facil manutenção
    //Métodos possuem apenas uma função

    /*Exercicio 1 -Adicionaar um método à classe Personagem que exibe o estado(valores de estamina, fome e sono) dos objetos.Chame ele em cada método existente na sua classe. Ele deve exibir o nome do personagem seguido dos valores de cada variável.*/
    void informarStatus(){
        System.out.printf("Status de %s:\nEnergia: %s - Sono: %s - Fome: %s\n", 
        this.nome,
        this.energia, 
        this.sono, 
        this.fome);
    }

    void cacar(){
        //this → faz referência a instância do objeto
        //this → está declarado implicitamente já
        if(this.energia >= 2){
            System.out.println(this.nome + " caçando...");
            this.energia-=2;
            informarStatus();
        }
        else{
            System.out.println(this.nome + " sem energia para caçar...");
            informarStatus();
        }
        this.fome = Math.min(this.fome + 1, LIMITE_SUPERIOR);
        this.sono = Math.min(this.sono + 1,LIMITE_SUPERIOR);
    }
    
    //Exercicio 2 - Adição método GULOSO
    void cacar(int n){
        //this → faz referência a instância do objeto
        //this → está declarado implicitamente já
        if(this.energia >= 2){
            System.out.println(this.nome + " caçando...");
            this.energia = this.energia - n >= 0 ? this.energia - n : 0;
            informarStatus();
        }
        else{
            System.out.println(this.nome + " sem energia para caçar...");
            informarStatus();
        }
        this.fome = Math.min(this.fome + n, LIMITE_SUPERIOR);
        this.sono = Math.min(this.sono + 1,LIMITE_SUPERIOR);
    }

    void comer(){
        if(this.fome >=1){
            System.out.printf("%s comendo...\n",this.nome);
            this.fome-=1;
            // this.energia+=1;
            //Verificando se a energia do personagem é maior que 10(limite)
            //Caso não seja pode-se somar 1 a energia
            //Caso seja maior que 10 mantém a energia como está
            this.energia = this.energia +1 <= LIMITE_SUPERIOR ? this.energia+=1 : this.energia;
            informarStatus();
        }
        else{
            System.out.printf("%s sem fome...\n", this.nome);
            informarStatus();
        }
    }

    //Exercicio 2 - Adição método GULOSO
    void comer(int n){
        if(this.fome >=1){
            System.out.printf("%s comendo...\n",this.nome);
            this.fome= this.fome - n >=0? this.fome - n :0;
            // this.energia+=1;
            //Verificando se a energia do personagem é maior que 10(limite)
            //Caso não seja pode-se somar 1 a energia
            //Caso seja maior que 10 mantém a energia como está
            this.energia = this.energia +n <= LIMITE_SUPERIOR ? this.energia+=n : this.energia;
            informarStatus();
        }
        else{
            System.out.printf("Impressionante!. %s está sem fome...\n", this.nome);
            informarStatus();
        }
    }

    //Método dormir
    void dormir(){
        if(this.sono >= 1){
            System.out.println(String.format("%s dormindo...", this.nome));
            this.sono -=1;
            this.energia = this.energia + 1 <= LIMITE_SUPERIOR ? this.energia +1 : this.energia;
            informarStatus();
        }
        else{
            System.out.println(this.nome + " sem sono...");
            informarStatus();
        }
      
    }
    
}