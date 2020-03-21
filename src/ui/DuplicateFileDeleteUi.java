package ui;

import java.awt.HeadlessException;

import javax.swing.JFrame;

public class DuplicateFileDeleteUi extends JFrame{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateFileDeleteUi(String path) throws HeadlessException {
		super("Windows Exploder - Javatpoint");
		add(new MainUiPanel(),"Center");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 400);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DuplicateFileDeleteUi("j");
	}

}
