import java.awt.*;
public class GUIHangman
{
	
	TextFieldControlPanel textArea;
	NewGameButtonControl newGameButton;
	LabelsHangmanView labelView;
	GallowsHangmanView gallowsView;
	HangmanLetterButtonControls buttons;
	
	public GUIHangman()
	{
    	System.out.println( "Start of GUIHangman\n");
    	
    	
		HangmanModel		hangman;
		IHangmanSetup		basicSetup;
		ConsoleHangmanView	consoleView;

		basicSetup = new BasicSetup();
		hangman = new HangmanModel( basicSetup);

		consoleView = new ConsoleHangmanView();
		hangman.addView( consoleView);
		
		labelView = new LabelsHangmanView( hangman);
		hangman.addView( labelView);
		
		gallowsView = new GallowsHangmanView( hangman);
		hangman.addView( gallowsView);
		
		textArea = new TextFieldControlPanel( hangman);
		newGameButton = new NewGameButtonControl(hangman);
		hangman.addView(newGameButton);
		
		buttons = new HangmanLetterButtonControls( hangman.getAllLetters(), 13, 2, hangman);
		hangman.addView( buttons);
		
		new SimpleJFrame( "GUIHangman", 	// title
							gallowsView,			// center
							textArea, newGameButton,		// north, south
							buttons, labelView );	// east, west

		// this is an infinite loop reading from the console
		ConsoleControl.controlFor( hangman);
	}

	public static void main( String[] args)
	{
		new GUIHangman();

//		// This is the approved way to initialise GUIs
//		// but won't work with the ConsoleControl as is!
//		// --------------------------------------------
//		SwingUtilities.invokeLater(
//			new Runnable() {
//			    public void run() {
//	        		new GUIHangman();
//	        		new GUIHangman();
//	    		}
//			});
	}

} // end of class GUIHangman
