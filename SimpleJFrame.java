import javax.swing.*;
import java.awt.*;
public class SimpleJFrame extends JFrame
{
	public SimpleJFrame( String title, JComponent centerComponent )
	{
		this( title, centerComponent, null, null, null, null );
	}

	public SimpleJFrame( String title,
						 JComponent centerComponent,
						 JComponent northComponent, JComponent southComponent,
						 JComponent eastComponent,  JComponent westComponent )
	{
		setTitle( title);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);

		if ( centerComponent != null) add( centerComponent, BorderLayout.CENTER);
		if ( northComponent != null)  add( northComponent,  BorderLayout.NORTH);
		if ( southComponent != null)  add( southComponent,  BorderLayout.SOUTH);
		if ( eastComponent != null)   add( eastComponent,   BorderLayout.EAST);
		if ( westComponent != null)   add( westComponent,   BorderLayout.WEST);

		pack();
		setVisible( true);
	}
}
