
public class HangmanLetterButtonControls extends LetterButtonControls implements IHangmanView
{

	public HangmanLetterButtonControls(String letters, HangmanModel hangmanModel) 
	{
		super(letters, hangmanModel);
		
	}
	
	public HangmanLetterButtonControls( String letters, int rows, int cols, HangmanModel hangmanModel)
	{
		super( letters, rows, cols, hangmanModel);
	}
	
	@Override
	public void updateView(Hangman hangmanModel) 
	{
		String usedLetters = hangmanModel.getUsedLetters();
		System.out.println( usedLetters);
		String a ;
		for( int i = 0; i < usedLetters.length(); i++)
		{
			a = usedLetters.substring(i, i+1);
			super.setDisabled( a);
		}
		
		if( hangmanModel.isGameOver())
		{
			setEnabledAll( true);
		}
		
	}

}
