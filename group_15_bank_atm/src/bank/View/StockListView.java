package bank.View;

import javax.swing.*;
import java.awt.*;


    public class StockListView extends JPanel {

        private static final long serialVersionUID = 1L;

        private JLabel headerLabel;
        private JTable table;
        private JButton buy;
        private JButton sell;
        private JButton stockPeekProfit;



        public JButton getStockPeekProfit() {
            return stockPeekProfit;
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

        public StockListView()
        {
            super(new BorderLayout());
            buy = new JButton("Buy Stock");
            sell = new JButton("Sell Stock");
            stockPeekProfit = new JButton("Peek profit");
            JPanel topPan = new JPanel(new BorderLayout());
            headerLabel = new JLabel("List of the stocks");
            topPan.add(headerLabel, BorderLayout.NORTH);
            topPan.add(Box.createVerticalStrut(10));
            topPan.add(buy, BorderLayout.WEST);
            topPan.add(sell, BorderLayout.CENTER);
            topPan.add(stockPeekProfit, BorderLayout.EAST);

            add(topPan, BorderLayout.NORTH);
        }

        public JButton getBuy() {
            return buy;
        }

        public JButton getSell() {
            return sell;
        }
    }

