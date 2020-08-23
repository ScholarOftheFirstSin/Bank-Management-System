package bank.View;

import javax.swing.*;
import java.awt.*;


public class ManagerStockListView extends JPanel {

    private static final long serialVersionUID = 1L;

    private JLabel headerLabel;
    private JTable table;









    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;

        JScrollPane scrollPane = new JScrollPane(table);
        Dimension d = table.getPreferredSize();
        scrollPane.setPreferredSize(
                new Dimension(d.width,table.getRowHeight()*6+1));
        add(scrollPane, BorderLayout.CENTER);
    }

    public ManagerStockListView()
    {
        super(new BorderLayout());

        JPanel topPan = new JPanel(new BorderLayout());
        headerLabel = new JLabel("List of the stocks");
        topPan.add(headerLabel, BorderLayout.NORTH);
        topPan.add(Box.createVerticalStrut(10));


        add(topPan, BorderLayout.NORTH);
    }


}

