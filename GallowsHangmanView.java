import java.awt.BorderLayout;


public class GallowsHangmanView extends JPanel implements IHangmanView
{
	HangmanModel hangmanModel;
	JLabel lostOrWin;
	JLabel word;

	public GallowsHangmanView(HangmanModel hangmanModel)
	{
		this.hangmanModel = hangmanModel;
		
		setLayout( new BorderLayout());
		setBackground( Color.cyan);
		
		lostOrWin = new JLabel();
		lostOrWin.setFont(new Font("Serif", Font.PLAIN, 20));
		word = new JLabel( hangmanModel.getKnownSoFar());
		word.setFont(new Font("Serif", Font.PLAIN, 20));
		
		add( lostOrWin, BorderLayout.NORTH);
		add( word, BorderLayout.SOUTH);
		
		setPreferredSize( new Dimension( 300,400));
	}
	
	@Override
	public void updateView(Hangman hangmanModel) 
	{
		repaint();
		
		word.setText( hangmanModel.getKnownSoFar());
		if ( hangmanModel.isGameOver() )
		{
			if ( hangmanModel.hasLost() )
			{
				lostOrWin.setText( "YOU LOST!");
			}	
			else
			{
				lostOrWin.setText( "YOU WON!");
			}
		}
		
		else 
		{
			lostOrWin.setText( "");
		}
	}
	
	public void paintComponent( Graphics g)
	{
		super.paintComponent(g);
		g.fillRect( 25, 270, 200, 25);
		g.fillRect( 50, 50, 15, 220);
		g.fillRect( 50, 50, 100, 15);
		g.fillRect( 140, 65, 10, 50);
		
		/*g.drawOval( 120, 115, 50, 50);
		g.drawLine( 145, 165, 145, 220);
		g.drawLine( 145, 170, 120, 190);
		g.drawLine( 145, 170, 170, 190);
		g.drawLine( 145, 220, 120, 250);
		g.drawLine( 145, 220, 170, 250);*/
		
		if( hangmanModel.getNumOfIncorrectTries() == 1)
		{
			//head
			g.drawOval( 120, 115, 50, 50);
		}
		
		if( hangmanModel.getNumOfIncorrectTries() == 2)
		{
			//head
			g.drawOval( 120, 115, 50, 50);
			//body
			g.drawLine( 145, 165, 145, 220);
		}
		
		if( hangmanModel.getNumOfIncorrectTries() == 3)
		{
			//head
			g.drawOval( 120, 115, 50, 50);
			//body
			g.drawLine( 145, 165, 145, 220);
			//left arm
			g.drawLine( 145, 170, 120, 190);
		}
		
		if( hangmanModel.getNumOfIncorrectTries() == 4)
		{
			//head
			g.drawOval( 120, 115, 50, 50);
			//body
			g.drawLine( 145, 165, 145, 220);
			//left arm
			g.drawLine( 145, 170, 120, 190);
			//right arm
			g.drawLine( 145, 170, 170, 190);
		}
		
		if( hangmanModel.getNumOfIncorrectTries() == 5)
		{
			//head
			g.drawOval( 120, 115, 50, 50);
			//body
			g.drawLine( 145, 165, 145, 220);
			//left arm
			g.drawLine( 145, 170, 120, 190);
			//right arm
			g.drawLine( 145, 170, 170, 190);
			//left leg
			g.drawLine( 145, 220, 120, 250);
		}
		
		if( hangmanModel.getNumOfIncorrectTries() == 6)
		{
			//head
			g.drawOval( 120, 115, 50, 50);
			//body
			g.drawLine( 145, 165, 145, 220);
			//left arm
			g.drawLine( 145, 170, 120, 190);
			//right arm
			g.drawLine( 145, 170, 170, 190);
			//left leg
			g.drawLine( 145, 220, 120, 250);
			//right leg
			g.drawLine( 145, 220, 170, 250);
		}
	}

}
