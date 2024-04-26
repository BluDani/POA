package control;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class HelicoThread extends JLabel implements Runnable {
    private Thread helicoThread = null;
    private int posX;
    private int posY;
    @SuppressWarnings("unused")
    private ImageIcon imagem;
    private String nome;
    private int num;
    private static List<HelicoThread> finalistas = new ArrayList<>();

    //criando apostadores
    private List<String> vencedores = new ArrayList<>();

    private List<Apostadores> apostadores = new ArrayList<>();
    Apostadores apostador1 = new Apostadores("Daniel", 5, 1);
    Apostadores apostador2 = new Apostadores("Jota", 10, 3);
    Apostadores apostador3 = new Apostadores("Miguel", 7, 2);
    Apostadores apostador4 = new Apostadores("Rafael", 8, 1);
    Apostadores apostador5 = new Apostadores("Marcelo", 14, 2);

    public HelicoThread(String nome, ImageIcon img, int posX, int posY, int num){
        super(img);
        this.imagem = img;
        this.posX = posX;
        this.posY = posY;
        this.nome = nome;
        this.num = num;
        helicoThread = new Thread(this, nome);
        helicoThread.start();
    }

    @Override
    public void run() {

        //colocaando apostadores na lista
        apostadores.add(apostador1);
        apostadores.add(apostador2);
        apostadores.add(apostador3);
        apostadores.add(apostador4);
        apostadores.add(apostador5);

        while (posX < 1280) {

            posX += new Random().nextInt(2) * 40;
            this.setLocation(posX, posY);
            try {
                Thread.sleep((int) (Math.random() * 100)); // Intervalo de atualização aleatório
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        finalistas.add(this);
        if (finalistas.size() == 3) {
            
            exibirVencedores();
            calcularApostas();
        }
    }

    private void exibirVencedores() {

        JOptionPane.showMessageDialog(null, "Vencedores:\n"
        + "1º lugar: " + finalistas.get(0).nome + "\n"
        + "2º lugar: " + finalistas.get(1).nome + "\n"
        + "3º lugar: " + finalistas.get(2).nome);

    }

    private void calcularApostas(){

        int quantVencedores = 0;
        float total = 0;
        float valorAposta;
    
        for(Apostadores i : apostadores){
    
            if(i.getHelicoApostado() == finalistas.get(0).num){
    
                vencedores.add(i.getNome());
    
                quantVencedores++;
            }
    
            total += i.getValor();
        }
    
        if (quantVencedores == 0) {
            JOptionPane.showMessageDialog(null, "Não houve apostadores que acertaram o helicóptero vencedor.");
            return;
        }
    
        valorAposta = total / quantVencedores;
    
        for(String nomeVencedor : vencedores){
            JOptionPane.showMessageDialog(null, "Apostadores:\n" + nomeVencedor + " ganhou: R$" + valorAposta + "\n");
        }
    
        vencedores.clear(); // Limpar a lista de vencedores para a próxima corrida
        finalistas.clear(); // Limpar a lista de finalistas para a próxima corrida
    }
}
