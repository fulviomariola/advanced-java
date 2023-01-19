package applicazione;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TestJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtMsg;
	private JLabel lblMsg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestJFrame frame = new TestJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestJFrame() {
		setTitle("Gestione YouTube");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Inserisci Video");
		lblNewLabel.setFont(new Font("Sukhumvit Set", Font.BOLD, 17));
		lblNewLabel.setBounds(33, 31, 115, 16);
		contentPane.add(lblNewLabel);
		
		txtMsg = new JTextField();
		txtMsg.setBounds(160, 26, 235, 26);
		contentPane.add(txtMsg);
		txtMsg.setColumns(10);
		
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblMsg.setText(txtMsg.getText());
			}
		});
		btnNewButton.setBounds(31, 108, 117, 29);
		contentPane.add(btnNewButton);
		
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMsg.setText("");
				lblMsg.setText("");
			}
		});
		btnNewButton_1.setBounds(278, 108, 117, 29); 
		contentPane.add(btnNewButton_1);
		
		lblMsg = new JLabel("");
		lblMsg.setBounds(98, 203, 235, 16);
		contentPane.add(lblMsg);
	}
}
