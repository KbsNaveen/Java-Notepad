import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.JOptionPane;


/* Class that handles File menu Actions. */
class FileMenuListener implements ActionListener
{
  JNotePad NtPad;
	PrintRequestAttributeSet attributes = new HashPrintRequestAttributeSet();
	
	public FileMenuListener(JNotePad NtPad)
	{
		this.NtPad = NtPad;
	}

	public void actionPerformed(ActionEvent ac)
	{
		String m = ac.getActionCommand();
		if( m.equalsIgnoreCase( "New                   Ctrl+N" ) )
		{
			if( JNotePad.saved == 0)
			{
				SaveChanges chngs = new SaveChanges( NtPad, "Save Changes" , true);
				chngs.setVisible(true);
			}
			/*else*/ if( JNotePad.saved == 1 )
				NtPad.txt.setText(null);
		}
		else if( ac.getSource()== NtPad.open )
		{
			if( JNotePad.saved == 0)
			{
				SaveChanges chngs = new SaveChanges( NtPad, "Save Changes" , true);
				chngs.setVisible(true);
			}
			/*else*/ if( JNotePad.saved == 1 )
				open();
		}
		else if( m.equalsIgnoreCase( "Save                  Ctrl+S" ) )
		{
			save();
		}
		else if( m.equalsIgnoreCase( "Save As                    " ) )
		{
			new FileDialog(NtPad,"Save As",FileDialog.SAVE).setVisible(true);
		}
		else if( m.equalsIgnoreCase( "Page Setup                 " ) )
		{
			PrinterJob job = PrinterJob.getPrinterJob();
            job.pageDialog(attributes);
		}
		else if( m.equalsIgnoreCase( "Print                   Ctrl+P" ) )
		{
			try
            {
                PrinterJob job = PrinterJob.getPrinterJob();
                job.setPrintable(new Printable()
                {
                	public int print(Graphics g, PageFormat pf, int page) throws PrinterException
                    {
						if (page >= 1)
							return Printable.NO_SUCH_PAGE;
						Graphics2D g2 = (Graphics2D) g;
						g2.translate(pf.getImageableX(), pf.getImageableY());
						g2.drawString(NtPad.txt.getText(), 0, 10);
						return Printable.PAGE_EXISTS;
                   }
                });
                if (job.printDialog(attributes)) job.print(attributes);
            }
            catch (PrinterException e)
            {
                JOptionPane.showMessageDialog(null, e);
            }           
		}
		else if( m.equalsIgnoreCase( "Exit                   " ) )
		{
			if( JNotePad.saved == 0 )
			{
				SaveChanges chngs = new SaveChanges( NtPad, "Save Changes", true);
				chngs.setVisible(true);
			}
			/*else*/ if( JNotePad.saved == 1 )
			{
				NtPad.dispose();
				System.exit(0);
			}
			
		}
	}

	private void save()
	{
		FileDialog fd = new FileDialog(NtPad, "Save As", FileDialog.SAVE);
		// fd.setLocation( NtPad.getX()+100 , NtPad.getY()+150 );
		fd.setVisible(true);
	}

	private void open()
	{
		FileDialog fd = new FileDialog(NtPad, "Open", FileDialog.LOAD);
		fd.setVisible(true);
		String str = fd.getDirectory() + fd.getFile();
		try 
		{
			FileInputStream f = new FileInputStream(str);
			NtPad.txt.setText(null);
			int ch;
			do {
				ch = f.read();
				if (ch != -1)
					NtPad.txt.setText(NtPad.txt.getText() + (char) ch);

			} while (ch != -1);
			f.close();
		} 
		catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, e);
		} 
		catch (IOException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
}
