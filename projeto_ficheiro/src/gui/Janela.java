package gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Janela extends JFrame{
    private JButton botao1;
    private JButton botao2;

    private int indiceAtual = 0;
    private List<ImageIcon> listaImagens;

    public Janela() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(340, 400);
        this.setResizable(false);

        ImageIcon icon = new ImageIcon(getClass().getResource("/gui/logo.png"));
        this.setIconImage(icon.getImage());

        this.getContentPane().setBackground(Color.lightGray);

        this.setLayout(null);

        //Imagem
        listaImagens = getListaImagens("projeto_ficheiro/src/gui/imagens");

        //Label
        JLabel rotulo = new JLabel("Isso é um teste.");
        rotulo.setIcon(listaImagens.get(indiceAtual));

        rotulo.setVerticalTextPosition(JLabel.TOP);
        rotulo.setHorizontalTextPosition(JLabel.CENTER);
        rotulo.setForeground(Color.DARK_GRAY);
        rotulo.setIconTextGap(5);

        rotulo.setBounds(60, 20, listaImagens.get(1).getIconWidth(), listaImagens.get(1).getIconHeight()+35);

        Border border = BorderFactory.createLineBorder(Color.DARK_GRAY, 5);
        rotulo.setBorder(border);

        //Panel
        JPanel painelCentral = new JPanel();
        painelCentral.setBackground(Color.lightGray);
        painelCentral.setLayout(null);

        JPanel painelUp = new JPanel();
        painelUp.setLayout(null);
        painelUp.setBackground(Color.DARK_GRAY);

        painelUp.setBounds(0, 0, 340, 30);
        painelCentral.setBounds(0, painelUp.getHeight(), 340, 370);

        //Button
        this.botao1 = new JButton("Anterior");
        botao1.addActionListener(e -> {
            indiceAtual--;
            if (indiceAtual < 0) {
                indiceAtual = listaImagens.size() - 1;
            }
            rotulo.setIcon(listaImagens.get(indiceAtual));
        });
        botao1.setFont(new Font("Arial", Font.BOLD, 11));
        botao1.setBounds(5, 5, 80, 20);
        botao1.setBackground(Color.lightGray);
        botao1.setForeground(Color.DARK_GRAY);

        this.botao2 = new JButton("Próxima");
        botao2.addActionListener(e -> {
            indiceAtual = (indiceAtual + 1) % listaImagens.size();
            rotulo.setIcon(listaImagens.get(indiceAtual));}
        );
        botao2.setFont(new Font("Arial", Font.BOLD, 11));
        botao2.setBounds(240, 5, 80, 20);
        botao2.setBackground(Color.lightGray);
        botao2.setForeground(Color.DARK_GRAY);

        painelUp.add(botao1);
        painelUp.add(botao2);
        painelCentral.add(rotulo);
        this.add(painelUp);
        this.add(painelCentral);
        this.setVisible(true);
    }

    public List<ImageIcon> getListaImagens(String path) {
        File pasta = new File(path);
        File[] arquivos = pasta.listFiles();

        List<ImageIcon> listaImagens = new ArrayList<>();

        for (File f : arquivos) {
            if (f.isFile() && f.getName().endsWith(".png")) {
                listaImagens.add(new ImageIcon(f.getAbsolutePath()));
            }
        }

        return listaImagens;
    }
}