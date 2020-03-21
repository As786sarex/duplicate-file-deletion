package ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileSystemView;

public class MainUiPanel extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	private static final String BASE_PATH="D:"; 
	
	private JButton button;
	private JFileChooser fileChooser;
	public MainUiPanel() {
		super();
		button=new JButton("Open File Chooser");
		button.setVisible(true);
		button.addActionListener(this);
		setLayout(new BorderLayout());
		add(button,BorderLayout.CENTER);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==button) {
			fileChooser=new JFileChooser(BASE_PATH,FileSystemView.getFileSystemView());
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int i=fileChooser.showOpenDialog(null);
			if(i==JFileChooser.APPROVE_OPTION) {
				JOptionPane.showMessageDialog(this,fileChooser.getSelectedFile().getAbsolutePath(),"Alert",JOptionPane.PLAIN_MESSAGE);
			}
		}
		
	}
	
	
	

}
