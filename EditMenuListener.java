import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Date;
import javax.swing.JOptionPane;

/*Class that handles Edit menu actions*/
class EditMenuListener implements ActionListener
{
    JNotePad NtPad;

	EditMenuListener(JNotePad NtPad)
	{
		this.NtPad = NtPad;
	}

	public void actionPerformed(ActionEvent ac)
	{
		String m = ac.getActionCommand();
		if (m.equalsIgnoreCase("Undo                   Ctrl+Z")) {
			// have to find time to add.
		} 
		else if (m.equalsIgnoreCase("Cut               Ctrl+X"))	{
			copy();
			NtPad.txt.replaceRange("", NtPad.txt.getSelectionStart(),
					NtPad.txt.getSelectionEnd());
		} 
		else if (m.equalsIgnoreCase("Copy               Ctrl+C")) {
			copy();
		} 
		else if (m.equalsIgnoreCase("Paste              Ctrl+P")) {
			paste();
		}
		else if (m.equalsIgnoreCase("Delete             Del")) {
			NtPad.txt.replaceRange("", NtPad.txt.getSelectionStart(),
					NtPad.txt.getSelectionEnd());
		}
		else if (m.equalsIgnoreCase("Find               Ctrl+F")) {
			Find find = new Find(NtPad, "Find", false);
			find.setVisible(true);
		} 
		else if (m.equalsIgnoreCase("Replace             Ctrl+H")) {
			Replace rplc = new Replace(NtPad, "Replace", false);
			rplc.setVisible(true);
		}
		else if (m.equalsIgnoreCase("Go To                Ctrl+G")) {
			NtPad.txt.setRows(1);
			NtPad.txt.setCaretPosition(0);
		}
		else if (m.equalsIgnoreCase("Select All           Ctrl+A")) {
			NtPad.txt.selectAll();
		}
		else if (m.equalsIgnoreCase("Time/Date                 F5")) {
			NtPad.txt.replaceRange(new Date().toString(),
					NtPad.txt.getSelectionStart(), NtPad.txt.getSelectionEnd());
		}
	}

	private void copy()
	{
		Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
		String str = NtPad.txt.getSelectedText();
		if (str == null)
			str = NtPad.txt.getText();
		StringSelection slctStr = new StringSelection(str);
		clpbrd.setContents(slctStr, null);
	}

	private void paste()
	{
		Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
		DataFlavor flavor = DataFlavor.stringFlavor;

		if (clpbrd.isDataFlavorAvailable(flavor))
		{
			try {
				String text = (String) (clpbrd.getData(flavor));
				NtPad.txt.replaceRange(text, NtPad.txt.getSelectionStart(),
						NtPad.txt.getSelectionEnd());
			}
			catch (UnsupportedFlavorException ex) {
				JOptionPane.showMessageDialog(null, ex); // handle exception
			}
			catch (IOException e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}
	}
}
