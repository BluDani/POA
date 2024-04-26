package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import control.HelicoThread;

public class Janela extends JFrame implements ActionListener {

    private JButton btnCorrida;
    private JButton btnCancel;
    private JLabel lblPista;
    private JLabel lblVelocimetro;
    private ImageIcon imgHelico1;
    private ImageIcon imgHelico2;
    private ImageIcon imgHelico3;
    private ImageIcon pista;
    private ImageIcon velocimetro;
    
   
    public Janela() {
        super();
               // ADICIONANDO ELEMENTOS AO FORMUL�RIO
        this.setLayout(null);
        this.setSize(1280, 650);
        this.setLocation(50, 50);
        this.setResizable(false);
        getContentPane().setBackground(Color.white);
       
        this.setTitle("Corrida de Threads");
        velocimetro = new ImageIcon("./src/imagens/velocimetro.gif");
        pista = new ImageIcon("./pjrCorrida/src/imagens/ceu.gif");
       
        this.lblPista = new JLabel(pista);
        this.lblVelocimetro = new JLabel(velocimetro);

        // POSICIONANDO OS ELEMENTOS DO FORM
        this.lblVelocimetro.setBounds(200, 490, 150, 150);
        this.lblPista.setBounds(0, 0, 1280, 650);
       
        this.add(lblPista);
        this.lblPista.add(lblVelocimetro);
       
        this.lblPista.setBackground(Color.BLACK);

        this.btnCorrida = new JButton("Começar corrida");
        this.btnCancel = new JButton("Terminar corrida");

        // POSIONADO OS BOT�ES
        this.btnCorrida.setBounds(500, 550, 120, 50);
        this.btnCancel.setBounds(640, 550, 120, 50);

        // INSERINDO AS IMAGENS DOS Helicopteros
        imgHelico1 = new ImageIcon("./pjrCorrida/src/imagens/helico1.gif");
        imgHelico2 = new ImageIcon("./pjrCorrida/src/imagens/helico2.png");
        imgHelico3 = new ImageIcon("./pjrCorrida/src/imagens/helico3.gif");
       
        this.lblPista.add(btnCorrida);
        this.lblPista.add(btnCancel);

        this.setVisible(true);

        btnCorrida.addActionListener(this);
        btnCancel.addActionListener(this);

        JPanel jPanel = new JPanel();
        jPanel.setSize(300, 70);
        jPanel.setLayout(null);
        jPanel.setLocation(970, 510);
        jPanel.setBorder(BorderFactory.createTitledBorder("[Grupo de Trabalho]"));
        jPanel.setVisible(true);

        this.repaint();

    }

     // INSERINDO AS JLABELS DOS Helicopteros
    public JLabel JLabelHelico(String nome, ImageIcon img, int posX, int posY, int num) {

        HelicoThread Helico = new HelicoThread(nome, img, posX, posY, num);
        Helico.setSize(256, 141);
        Helico.setVisible(true);
        this.add(Helico);
        return Helico;
    }


    // PROGRAMANDO A A��O DOS BOT�ES
    @Override
    public void actionPerformed(ActionEvent dispara) {
        if (dispara.getSource() == this.btnCorrida) {
            this.lblPista.add(JLabelHelico("Helicoptero 1", imgHelico1, 0, 50, 1));
            this.lblPista.add(JLabelHelico("Helicoptero 2", imgHelico2, 0, 200, 2));
            this.lblPista.add(JLabelHelico("Helicoptero 3", imgHelico3, 0, 350, 3));
        }
        if (dispara.getSource() == this.btnCancel) {
            System.exit(0);
        }
    }
}