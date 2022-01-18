package File;

import java.io.File;

import javax.swing.JFileChooser;

public class ChooseFile {
	JFileChooser chooser = new JFileChooser();
	public File Chooser() {
		if(chooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION)
		{
			return chooser.getSelectedFile();
		}
		return null;
	}
}
