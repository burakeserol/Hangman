import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextField;


public class TextFieldControlPanel extends JPanel
{

	HangmanModel hangmanModel;
	
	JTextField textField;
	
	public TextFieldControlPanel( HangmanModel hangmanModel)
	{
		this.hangmanModel = hangmanModel;
		
		textField = new JTextField( 10);
		textField.addActionListener( new MyListener());
		
		add( textField);
	}
	
	
	public class MyListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			String prediction = textField.getText();
			char test;
			
			for( int i = 0; i < prediction.length(); i++)
			{
				test = prediction.charAt(i);
				hangmanModel.tryThis( test);
			}
			
			textField.setText("");
		}
		
	}
}
