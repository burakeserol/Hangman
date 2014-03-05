import java.awt.Color;


public class LabelsHangmanView extends JPanel implements IHangmanView
{
	HangmanModel hangmanModel;
	JLabel labelKnownSoFar;
	JLabel labelUsedLetters;
	JLabel labelIncorrectTries;
	JLabel labelEmpty;
	
	public LabelsHangmanView( HangmanModel hangmanModel)
	{
		this.hangmanModel = hangmanModel;
		
		labelKnownSoFar = new JLabel( "Known so Far: ");
		labelUsedLetters = new JLabel( "Used Letters: ");
		labelIncorrectTries = new JLabel( "Incorrect Tries: ");
		labelEmpty = new JLabel( "");
		
		labelKnownSoFar.setFont(new Font("Serif", Font.PLAIN, 14));
		labelUsedLetters.setFont(new Font("Serif", Font.PLAIN, 20));
		labelIncorrectTries.setFont(new Font("Serif", Font.PLAIN, 20));
		
		add( labelKnownSoFar);
		add( labelEmpty);
		add( labelIncorrectTries);
		add( labelEmpty);
		add( labelUsedLetters);
		
		setBackground( Color.GREEN);
		
		setPreferredSize( new Dimension( 200, 400));
	}
	
	
	
	@Override
	public void updateView(Hangman hangmanModel) 
	{		
		labelKnownSoFar.setText( "Known so Far: " + hangmanModel.getKnownSoFar());
		labelUsedLetters.setText( "Used Letters: " + hangmanModel.getUsedLetters());
		labelIncorrectTries.setText( "Incorrect Tries: " + hangmanModel.getNumOfIncorrectTries());		
		
		
	}

}
