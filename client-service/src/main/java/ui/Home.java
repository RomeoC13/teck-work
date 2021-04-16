package ui;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Home extends JFrame {
	private String [] element = {"mairie", "service", "pouvooirs", "publics"};
	private JComboBox combox;
	
	
	public Home() {
		this.setVisible(true);
		this.setTitle("page d'accueil");
		this.setSize(500,500);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		JPanel  panel = (JPanel)this.getContentPane();
		panel.setLayout(new BorderLayout());
		
		combox = new JComboBox(element);
		combox.setMaximumSize(new Dimension(20,20));
		panel.add(BorderLayout.CENTER,combox);
		
		JLabel label = new JLabel("veuillez entrer l'element que vous souhaiter");
		//setSize(50,30);
		panel.add(BorderLayout.NORTH, label);
		
		JButton button = new JButton("selection");
		//button.addActionListener(combox);
		
		panel.add(BorderLayout.SOUTH,button);
		
	}

	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		new Home();
	}

}