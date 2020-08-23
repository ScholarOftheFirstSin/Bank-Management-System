package bank.View;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import bank.SpringUtilities;

import java.awt.GridLayout;

public class UserProfileView extends JPanel{

    private static final long serialVersionUID = 1L;

    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel middleNameLabel;
    private JTextField middleNameTextField;
    private JLabel AddressLabel;
    private JTextField firstNameTextField;
    private JTextField lastNameTextField;
    private JTextField AddressTextField;
    private JButton saveButton;

    private JLabel emailLabel;
    private JTextField emailTextField;
    private JLabel passwordLabel;
    private JPasswordField passwordTextField;
    private JLabel msgLabel;
    private JLabel headerLabel;

    public UserProfileView()
    {
        super(new BorderLayout());
        headerLabel = new JLabel("Profile Detail");

        firstNameLabel = new JLabel("First Name", JLabel.TRAILING);
        firstNameTextField = new JTextField(20);
        firstNameLabel.setLabelFor(firstNameTextField);

        middleNameLabel = new JLabel("Middle Name" , JLabel.TRAILING);
        middleNameTextField = new JTextField(10);
        middleNameLabel.setLabelFor(middleNameTextField);

        lastNameLabel = new JLabel("Last Name", JLabel.TRAILING);
        lastNameTextField = new JTextField(20);
        lastNameLabel.setLabelFor(lastNameTextField);

        AddressLabel = new JLabel("Address", JLabel.TRAILING);
        AddressTextField = new JTextField(50);
        AddressLabel.setLabelFor(AddressTextField);

        emailLabel = new JLabel("Email", JLabel.TRAILING);
        emailTextField = new JTextField(20);
        emailLabel.setLabelFor(emailTextField);

        passwordLabel = new JLabel("Password", JLabel.TRAILING);
        passwordTextField = new JPasswordField(20);
        passwordLabel.setLabelFor(passwordTextField);

        saveButton = new JButton("Sign Up ");
        msgLabel = new JLabel();


        JPanel jp = new JPanel(new SpringLayout());

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;



        jp.add(firstNameLabel);
        jp.add(firstNameTextField);

        jp.add(lastNameLabel);
        jp.add(lastNameTextField);


        SpringUtilities.makeCompactGrid(jp, 2, 2, //rows, cols
                6, 6, //initX, initY
                6, 6); //xPad, yPad



        this.add(headerLabel, gbc);
        this.add(jp, gbc);
        this.add(msgLabel, gbc);
    }

    public void setMsgLabel(String msgLabel) {
        this.msgLabel.setText(msgLabel);
    }
    public JTextField getFirstNameTextField() {
        return firstNameTextField;
    }

    public void setFirstNameTextField(String firstNameTextField) {
        this.firstNameTextField.setText(firstNameTextField);
    }

    public JTextField getLastNameTextField() {
        return lastNameTextField;
    }

    public void setLastNameTextField(String lastNameTextField) {
        this.lastNameTextField.setText(lastNameTextField);
    }



}
