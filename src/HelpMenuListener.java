import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* Handles Help menu actions. */
class HelpMenuListener implements ActionListener
{
        JNotePad NtPad;
	public HelpMenuListener(JNotePad NtPad)
	{
		this.NtPad = NtPad;
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String m = ae.getActionCommand();
		if( m.equalsIgnoreCase( "View Help              " ) )
		{
			//Have to make help documentation.
		}
		else if( m.equalsIgnoreCase( "About JNotepad    " ) )
		{
			About ant = new About(NtPad, "About JNotePad" , true);
		}
	}	
}
