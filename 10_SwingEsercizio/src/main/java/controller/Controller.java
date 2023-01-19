package controller;

import applicazione.TestJFrame;
import gui.FramePrincipale;
import gui.PannelloPrincipale;

public class Controller {
	private FramePrincipale framePrincipale;
	private PannelloPrincipale pannelloPrincipale;
	private TestJFrame testFrame;
	
	public Controller() {
//		framePrincipale = new FramePrincipale();
//		pannelloPrincipale = new PannelloPrincipale();
//		
//		framePrincipale.setContentPane(pannelloPrincipale);
		
		testFrame = new TestJFrame();
		
	}
}
