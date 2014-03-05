import java.awt.event.ActionEvent;


public class NewGameButtonControl extends JButton implements IHangmanView
{
	HangmanModel hangmanModel;
	
	
	public NewGameButtonControl( HangmanModel hangmanModel)
	{
		this.hangmanModel = hangmanModel;
		
		
		setText( "New Game");
		setEnabled( false);
		addActionListener( new MyListener());
		
	}
	
	public class MyListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			setEnabled( false);
			hangmanModel.initNewGame();
		}
		
	}

	@Override
	public void updateView(Hangman hangmanModel)
	{
		if( hangmanModel.isGameOver())
		{
			setEnabled( true);
			System.out.println( "SDAFGHFDS");
		}
		
	}
}
