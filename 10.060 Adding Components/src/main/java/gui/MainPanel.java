package gui;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;

public class MainPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	 
	public MainPanel() {		
		var formLabel = new JLabel("Aggiungi Utente");
		var nameLabel = new JLabel("Utente:"); 
		var namePassword = new JLabel("Password:");
		
		var nameField = new JTextField();
		var passField = new JTextField();
		
		var addButton = new JButton("Save");
		
		setLayout(new BorderLayout());
		
		add(formLabel, BorderLayout.NORTH);
		add(nameLabel, BorderLayout.CENTER);
		//add(namePassword, BorderLayout.);
	}
}
 