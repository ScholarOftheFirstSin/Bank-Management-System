package bank;

import bank.MySql.DBManager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelData {
	
	private static  JPanel parentPanel;
	private static  JPanel sidePanel;
	private static  JPanel headerPanel;
	//private static JFrame frame;
	public static void InitiatePanelData(JFrame frame, DBManager dbManager)
	{
		//frame = new JFrame();
		frame.setBounds(100, 100, 1050, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		parentPanel = new JPanel(new GridLayout());
		sidePanel = new JPanel();
		headerPanel = new JPanel();
		
		
		headerPanel.setBackground(Color.PINK);
		frame.getContentPane().add(headerPanel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Welcome to Fancy Bank ");
		headerPanel.add(lblNewLabel);
		FlowLayout flowLayouthead = (FlowLayout) headerPanel.getLayout();
		flowLayouthead.setVgap(50);
		flowLayouthead.setHgap(50);		
		frame.getContentPane().add(parentPanel, BorderLayout.CENTER);		
		
		sidePanel.setBackground(Color.PINK);
		FlowLayout flowLayout = (FlowLayout) sidePanel.getLayout();
		flowLayout.setVgap(10);
		flowLayout.setHgap(20);
		frame.getContentPane().add(sidePanel, BorderLayout.WEST);

		frame.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				dbManager.deleteBoughtStock();
				dbManager.deleteTransaction();

				dbManager.deleteAccount();
				dbManager.deleteLoan();

				dbManager.deleteStock();



				dbManager.deletePerson();



				Data.getStockMarket().saveStocks(dbManager);
				Data.getBank().saveCustomerAccounts(dbManager);
				System.out.println("Closed");
				e.getWindow().dispose();
			}
		});
		
		//JPanel sidePn = (JPanel) new SideBarView(parentPanel);
		//sidePanel.add(sidePn);
		//sidePn.setVisible(true);		
	}
	public static JPanel getParentPanel() {
		return parentPanel;
	}
	public static JPanel getSidePanel() {
		return sidePanel;
	}
	
	public static void setParentPanel(JPanel panel)
	{		
		parentPanel.removeAll();
		parentPanel.revalidate();
		parentPanel.repaint();
		parentPanel.add(panel, BorderLayout.CENTER);
	}
	
	public static void setSidePanel(JPanel panel)
	{		
		sidePanel.removeAll();
		sidePanel.revalidate();
		sidePanel.repaint();
		sidePanel.setBackground(Color.WHITE);
		sidePanel.add(panel, BorderLayout.WEST);
	}

}
