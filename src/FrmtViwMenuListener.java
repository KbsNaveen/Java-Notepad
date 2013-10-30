import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


/* Handles Format and view menu actions. */
class FrmtViwMenuListener implements ActionListener,ItemListener
{
        JNotePad NtPad;
	public FrmtViwMenuListener(JNotePad NtPad)
	{
		this.NtPad = NtPad;
	}

	public void actionPerformed(ActionEvent ae) //have to find time to comlpete.
	{
		String m = ae.getActionCommand();
		if( m.equalsIgnoreCase( "Font                 " ) )
		{
			FontDialog1 fnt = new FontDialog1(NtPad, "Font" , true);
			/*fnt.setVisible(true);
			fnt.setSize(500, 400);
			fnt.setLocation(NtPad.NFrame.getX()+50,NtPad.NFrame.getY()+150);*/
		}
		else if( m.equalsIgnoreCase( "Word Wrap       " ) )
		{
			//NtPad.stsbar.setEnabled(false);
		}
		else if(  m.equalsIgnoreCase( "Status Bar      " ) )
		{
			
		}
	}
	
	public void itemStateChanged(ItemEvent ie)
	{
		if( ie.getStateChange() == 1 )
		{
			NtPad.stsbar.setEnabled(false);
			NtPad.Goto.setEnabled(false);
		}
		else
		{
			NtPad.stsbar.setEnabled(true);
			NtPad.Goto.setEnabled(true);
		}
	}
	
}
