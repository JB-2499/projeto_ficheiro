import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Deletar extends Conta implements ActionListener, KeyListener {
    private JTextField id;

    private JButton botaoConfirmar;
    private JButton botaoCancelar;

    public Deletar (JFrame janela) {
        super(janela);
        this.frame.setTitle("Pesquisar");

        //region Panels
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        panel1.setLayout(null);
        panel1.setBackground(Color.DARK_GRAY);
        panel1.setBounds(0, 0, 400, 40);
        this.frame.add(panel1);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        panel2.setBackground(Color.white);
        panel2.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 5));
        panel2.setOpaque(true);
        panel2.setLayout(null);
        panel2.setBounds(0, 40, 384, 211);
        this.frame.add(panel2);
        //endregion

        //region Labels
        JLabel titulo = new JLabel("Informe o Id do indivíduo");
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        titulo.setBackground(Color.darkGray);
        titulo.setForeground(Color.white);
        titulo.setOpaque(true);
        titulo.setBounds(95, 4, 350, 30);
        panel1.add(titulo);

        JLabel textId = new JLabel("Id:");
        textId.setFont(new Font("Arial", Font.BOLD, 15));
        textId.setOpaque(true);
        textId.setBounds(125, 80, 20, 25);
        panel2.add(textId);

        //endregion

        //region TextFields
        id = new JTextField();
        id.addKeyListener(this);
        id.setBounds(145 , 80, 100, 25);
        id.setFont(new Font("Arial", Font.BOLD, 15));
        panel2.add(id);
        //endregion

        //region Buttons
        botaoConfirmar = new JButton("Deletar");
        botaoConfirmar.setBackground(Color.lightGray);
        botaoConfirmar.setBounds(110, 180, 80, 30);
        botaoConfirmar.setFont(new Font("Arial", Font.BOLD, 10));
        botaoConfirmar.addActionListener(this);
        botaoConfirmar.setFocusable(false);
        panel2.add(botaoConfirmar);

        botaoCancelar = new JButton("Cancelar");
        botaoCancelar.setBackground(Color.lightGray);
        botaoCancelar.setFont(new Font("Arial", Font.BOLD, 10));
        botaoCancelar.setBounds(200, 180, 80, 30);
        botaoCancelar.addActionListener(this);
        botaoCancelar.setFocusable(false);
        panel2.add(botaoCancelar);
        //endregion

        this.frame.getRootPane().setDefaultButton(botaoConfirmar);
        this.frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botaoConfirmar) {
            int idInt = Integer.parseInt(id.getText());

            ficheiro.deletar(idInt);
            JOptionPane.showMessageDialog(null, "Pessoa removida com sucesso!");
            this.frame.dispose();
        } else if (e.getSource() == botaoCancelar) {
            this.frame.dispose();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if (!((c >= '0' && c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            e.consume();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
