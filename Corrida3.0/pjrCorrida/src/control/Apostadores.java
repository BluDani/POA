package control;

public class Apostadores {
    
    private String nome;
    private float valor;
    private int helicoApostado;

    public Apostadores(String nome, float valor, int helicoApostado){

        super();
        this.nome = nome;
        this.valor = valor;
        this.helicoApostado = helicoApostado;

    }

    public String getNome(){
    return nome;
    }
    public void setNome(String nome){
    this.nome = nome;
    }

    public float getValor(){
    return valor;
    }
    public void setValor(float valor){
    this.valor = valor;
    }

    public int getHelicoApostado(){
    return helicoApostado;
    }
    public void setHelicoApostado(int helicoApostado){
    this.helicoApostado = helicoApostado;
    }
}
