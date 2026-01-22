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

        this.setLayout(new BorderLayout());

        //Imagem
        listaImagens = getListaImagens("projeto_ficheiro/src/gui/imagens");

        //Label
        JLabel rotulo = new JLabel("Isso é um teste.");

        rotulo.setLayout(new BorderLayout());
        rotulo.setIcon(listaImagens.get(indiceAtual));

        rotulo.setVerticalTextPosition(JLabel.TOP);
        rotulo.setHorizontalTextPosition(JLabel.CENTER);
        rotulo.setForeground(Color.darkGray);
        rotulo.setIconTextGap(5);

        Border border = BorderFactory.createLineBorder(Color.darkGray, 5);
        rotulo.setBorder(border);

        rotulo.setVerticalAlignment(JLabel.CENTER);
        rotulo.setHorizontalAlignment(JLabel.CENTER);

        //Panel
        JPanel painelCentral = new JPanel();
        painelCentral.setBackground(Color.lightGray);
        painelCentral.setLayout(new BorderLayout());

        JPanel painelUp = new JPanel();
        painelUp.setLayout(new BorderLayout());
        painelUp.setBackground(Color.darkGray);

        painelUp.setPreferredSize(new Dimension(340, 30));
        painelUp.setBorder(BorderFactory.createLineBorder(Color.darkGray, 5));

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
        botao1.setPreferredSize(new Dimension(80, 20));
        botao1.setBackground(Color.lightGray);
        botao1.setForeground(Color.darkGray);

        this.botao2 = new JButton("Próxima");
        botao2.addActionListener(e -> {
            indiceAtual = (indiceAtual + 1) % listaImagens.size();
            rotulo.setIcon(listaImagens.get(indiceAtual));}
        );
        botao2.setFont(new Font("Arial", Font.BOLD, 11));
        botao2.setPreferredSize(new Dimension(80, 20));
        botao2.setBackground(Color.lightGray);
        botao2.setForeground(Color.darkGray);

        painelUp.add(botao1, BorderLayout.WEST);
        painelUp.add(botao2, BorderLayout.EAST);
        painelCentral.add(rotulo);
        this.add(painelCentral, BorderLayout.CENTER);
        this.add(painelUp, BorderLayout.NORTH);
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