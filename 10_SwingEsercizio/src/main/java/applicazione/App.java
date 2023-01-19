package applicazione;

import javax.swing.SwingUtilities;

import controller.Controller;
//import controller.Controller;

public class App {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(Controller::new);
	}

}
