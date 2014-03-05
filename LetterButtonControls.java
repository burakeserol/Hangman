import javax.swing.*;
public class LetterButtonControls extends JPanel
{
	HangmanModel hangmanModel;
	
	public LetterButtonControls( String letters, HangmanModel hangmanModel)
	{
		this( letters, 2, 13 ,hangmanModel);
		this.hangmanModel = hangmanModel;
	}

	public LetterButtonControls( String letters, int rows, int cols, HangmanModel hangmanModel)
	{
		this.hangmanModel = hangmanModel;
		
		setBorder( new TitledBorder("Choose a letter...") );
		setLayout( new GridLayout( rows, cols) );

		for( int i = 0; i < letters.length(); i++) {
			JButton b = new JButton( "" + letters.charAt(i) );
			b.setMargin( new Insets( 1, 2, 1, 2) );
			b.addActionListener( new HangmanLetterButtonsController());//
			add( b);
		}
		
		setPreferredSize( new Dimension( 200,400));
	}
	
	

	public void addActionListener( ActionListener l)
	{
		Component[] buttons = getComponents();
		for ( Component b : buttons )
		{
			( (JButton) b).addActionListener( l);
		}
	}

	public void setEnabledAll( boolean state)
	{
		for ( Component c : getComponents() ) {
			((JButton) c).setEnabled( state);
		}
	}

	public void setDisabled( String letters)
	{
		for ( Component c : getComponents() ) {
			char ch = ((JButton) c).getLabel().charAt(0);
			if ( letters.indexOf(ch) >= 0)
				((JButton) c).setEnabled( false);
		}
	}
	
	public class HangmanLetterButtonsController implements ActionListener
	{

		public void actionPerformed(ActionEvent e)
		{
			String pressedButton = e.getActionCommand();
			char tryButton = pressedButton.charAt( 0);
			
			hangmanModel.tryThis( tryButton);
			setDisabled( pressedButton);
			
			if( hangmanModel.isGameOver())
			{
				setEnabledAll( true);
			}
			
		}
		
	}
}
