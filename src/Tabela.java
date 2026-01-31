import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class Tabela extends JFrame {
    public Tabela(JFrame frame) {
        Ficheiro ficheiro = new Ficheiro();
        setTitle("Tabela");
        setSize(400,360);
        setResizable(false);
        setLocationRelativeTo(frame);

        ImageIcon logo = new ImageIcon(getClass().getResource("/gui/Gear.png"));
        this.setIconImage(logo.getImage());

        List<String> dados = ficheiro.ler("user_information/dados.csv");

        String[] colunas = new String[] {"Nome","email","idade","id"};
        Object[][] data = new Object[dados.size()][colunas.length];

        for (int i = 0; i < dados.size(); i++) {
            String[] linha = dados.get(i).split(",");

            data[i][0] = linha[0];
            data[i][1] = linha[1];
            data[i][2] = linha[2];
            data[i][3] = linha[3];
        }

        JTable table = new JTable(data, colunas);
        table.getColumnModel().getColumn(0).setPreferredWidth(120);
        table.getColumnModel().getColumn(1).setPreferredWidth(120);
        table.getColumnModel().getColumn(2).setPreferredWidth(30);
        table.getColumnModel().getColumn(3).setPreferredWidth(30);
        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane, BorderLayout.CENTER);

        DefaultTableModel model = new DefaultTableModel(data, colunas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 3) {
                    return false;
                }
                return true;
            }
        };

        table.setModel(model);

        setVisible(true);
    }
}
