package bank.View;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class BoughtStockView extends JPanel {

    private static final long serialVersionUID = 1L;

    private JLabel headerLabel;
    private JButton newLoanButton;
    JTable table;

    public BoughtStockView()
    {
        super(new BorderLayout());


        JPanel topPan = new JPanel(new BorderLayout());

        headerLabel = new JLabel("List of the stock you bought");


        topPan.add(headerLabel, BorderLayout.NORTH);
        topPan.add(Box.createVerticalStrut(10));

        add(topPan, BorderLayout.NORTH);
    }

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




}
