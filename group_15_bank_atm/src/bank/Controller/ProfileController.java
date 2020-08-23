package bank.Controller;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.UUID;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import bank.CustomerAccount;
import bank.Data;
import bank.LoggedUser;
import bank.PanelData;
import bank.Person;
import bank.View.ProfileListView;
import bank.View.ProfileView;
import bank.View.UserProfileView;

public class ProfileController {

	private JPanel profileView;
	private JPanel userProfileView;
	private JPanel profileList;
	private boolean isNew;
	//private String custId;

	public void initController()
	{
		//profileView =  new ProfileView();
		((ProfileView)profileView).getSaveButton().addActionListener(l -> SaveData());
	}

	

	public void SaveData()
	{

		if (isNew)
		{
			Person p = new Person(((ProfileView)profileView).getFirstNameTextField().getText(), ((ProfileView)profileView).getLastNameTextField().getText());
			Data.getBank().registerNewCustomer(p);
			((ProfileView)profileView).setMsgLabel("Data Saved. Please log in");
		}else
		{
		    LoggedUser.getProfile().getPerson().getName().setFirstName(((ProfileView)profileView).getFirstNameTextField().getText());
		    LoggedUser.getProfile().getPerson().getName().setLastName(((ProfileView)profileView).getLastNameTextField().getText());
		    ((ProfileView)profileView).setMsgLabel("Data Saved");
		}

	}

	public ProfileController() {
		profileView = new ProfileView();
		profileList = new ProfileListView();
		userProfileView = new UserProfileView();

		
		initController();
		//custId = ""; 
	}

	public void showLoggedUserProfile(CustomerAccount ca)
	{
		profileView.setVisible(true);		
		PanelData.setParentPanel(profileView);
		BindCustomerData(ca);
	}
	//
	public void showUserProfile(CustomerAccount ca)
	{
		userProfileView.setVisible(true);
		PanelData.setParentPanel(userProfileView);
		BindLoggedCustomerData(ca);
	}
	
	public void showNewUser()
	{
		profileView.setVisible(true);		
		PanelData.setParentPanel(profileView);
		
	}

	private void BindCustomerData(CustomerAccount ca)
	{
				((ProfileView)profileView).setFirstNameTextField(ca.getPerson().getName().getFirstName().toString());
				((ProfileView)profileView).setLastNameTextField(ca.getPerson().getName().getLastName().toString());
				
				
		
	}

	private void BindLoggedCustomerData(CustomerAccount ca)
	{
		((UserProfileView)userProfileView).setFirstNameTextField(ca.getPerson().getName().getFirstName().toString());
		((UserProfileView)userProfileView).setLastNameTextField(ca.getPerson().getName().getLastName().toString());



	}

	private void bindData()
	{

	}

	public boolean isNew() {
		return isNew;
	}

	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}

	public void ShowProfileList()
	{
			String col[] = { "Customer Name"};
			DefaultTableModel tableModel = new DefaultTableModel(col, 0);

			for (CustomerAccount p : Data.getBank().getCustomerAccounts())
			{
				
					Object[] objs = {
							p.toString(),
												};
					tableModel.addRow(objs);
				
			}

			JTable table = new JTable(tableModel);
			table.setFillsViewportHeight(true);

			table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent event) {
					if (table.getSelectedRow() > -1) {
						// print first column value from selected row
						//String id = table.getValueAt(table.getSelectedRow(), 0).toString();
						//ShowCustomerProfile(id);

					}
				}
			});

			((ProfileListView)profileList).setTable(table);



		profileList.setVisible(true);		
		PanelData.setParentPanel(profileList);
		

	}


}
