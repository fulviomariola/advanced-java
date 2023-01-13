package gui;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class MainPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	 
	public MainPanel() {		
		var formLabel = new JLabel("Aggiungi Utente");
		var nameLabel = new JLabel("Utente:"); 
		var passLabel = new JLabel("Password:");
		
		var nameField = new JTextField(15);
		var passField = new JTextField(15);
		
		var addButton = new JButton("Save");
		
		setLayout(new GridBagLayout());
		
		var gc = new GridBagConstraints();
		
		gc.gridx = 0;
		gc.gridy = 0;
		
		gc.gridwidth = 2;
		add(formLabel, gc);
		
		gc.gridy++;
		gc.gridwidth = 1;
		
		gc.gridx = 0;
		add(nameLabel, gc);
		
		gc.gridx = 1;
		add(nameField, gc);
		
		gc.gridy++;
		
		gc.gridx = 0;
		add(passLabel, gc);
		
		gc.gridx = 1;
		add(passField, gc);
		
		gc.gridy++;
		gc.gridx = 1;
		add(addButton, gc);
	}
}
 