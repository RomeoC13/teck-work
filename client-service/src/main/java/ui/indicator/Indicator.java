package ui.indicator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import ui.Side_Menu;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class Indicator extends JFrame {
	
	JTextField occupationField = new JTextField();
	JTextField itemsField =  new JTextField();
	JTextField equipmentField = new JTextField();
	JTextField sensorField = new JTextField();
	JTextField companyField = new JTextField();
	JTextField energyField = new JTextField();
	JPanel seconJPanel = new JPanel();
	Side_Menu sm;
	private JTextField textField;
	private JTextField titleField;

	public Indicator() {
		this.setVisible(true);
		this.setTitle("Indicateurs");
		this.setSize(800, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sm = new Side_Menu();
		JPanel contentPane = (JPanel) this.getContentPane();
		getContentPane().setLayout(new BorderLayout());
		contentPane.add(sm, BorderLayout.WEST);
		contentPane.add(addingAllMenu(), BorderLayout.CENTER);

	}

	private JPanel addingAllMenu() {
		seconJPanel = new JPanel(new BorderLayout());
		
		seconJPanel.add(optionOFTop(), BorderLayout.NORTH);
		seconJPanel.add(optionOFCentered(), BorderLayout.CENTER);

		return seconJPanel;
	}

	private JPanel optionOFTop() {
		JPanel mainTopPanel = new JPanel(new BorderLayout());
		
		JPanel topPanel = new JPanel(new FlowLayout());
		JButton allInfo = new JButton("information g�nerale");
		topPanel.add(allInfo);
		JButton infoByCompany = new JButton("information par entreprise");
		infoByCompany.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel pan  = new JPanel(new BorderLayout());
				pan.add(new JLabel("Veuillez entrer le nom d'une entreprise"), BorderLayout.NORTH);
				//pan.add(new JButton("valider"),BorderLayout.SOUTH);
				pan.add(new JTextField(), BorderLayout.CENTER);

                JOptionPane.showConfirmDialog(null, pan, "choix d'une entreprise", JOptionPane.OK_CANCEL_OPTION);
                
                	
                
				
				
			}
		});
		topPanel.add(infoByCompany);
		JButton infoByBuilding = new JButton("indicateur par batiments");
		infoByBuilding.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel pan  = new JPanel(new BorderLayout());
				pan.add(new JLabel("Veuillez entrer le nom du batiments"), BorderLayout.NORTH);
			//	pan.add(new JButton("valider"),BorderLayout.SOUTH);
				pan.add(new JTextField(), BorderLayout.CENTER);

                JOptionPane.showConfirmDialog(null, pan, "choix d'un batiment", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			}
		});
		topPanel.add(infoByBuilding);
		mainTopPanel.add(topPanel, BorderLayout.NORTH);
		JPanel titlePane = new JPanel();
		titleField = new JTextField();
		titlePane.add(titleField);
		titleField.setColumns(10);
		titlePane.setPreferredSize(new Dimension(100,100));
		topPanel.add(titlePane);
		
		
		mainTopPanel.add(titlePane, BorderLayout.SOUTH);
		mainTopPanel.setPreferredSize(new Dimension(100,200));
		return mainTopPanel;
	}
	
	private JPanel optionOFCentered() {
		JPanel mainPanel = new JPanel(new FlowLayout());
		

		
		

		//set in a panel all the list of indicators
		JPanel indicatorPanel = new JPanel(new GridLayout(6,1));
		indicatorPanel.setPreferredSize(new Dimension(200, 200));
		JLabel occupation = new JLabel("Taux d'occupation");
		indicatorPanel.add(occupation);
		JLabel connectedItems = new JLabel("Objets connect�s");
		indicatorPanel.add(connectedItems);
		JLabel equipment = new JLabel("Nombre d��quipements");
		indicatorPanel.add(equipment);
		JLabel sensor = new JLabel("Capteurs install�s");
		indicatorPanel.add(sensor);
		JLabel company = new JLabel("Nombre d�entreprise");
		indicatorPanel.add(company);
		JLabel energy = new JLabel("Consommation �nerg�tique");
		indicatorPanel.add(energy);
		mainPanel.add(indicatorPanel);
		
	
		
		// set in a panel all the list of each indicators result
		JPanel fieldPanel = new JPanel(new GridLayout(6,1));
		fieldPanel.setPreferredSize(new Dimension(100, 200));
		fieldPanel.add(occupationField);
		fieldPanel.add(itemsField);
		fieldPanel.add(equipmentField);
		fieldPanel.add(sensorField);
		fieldPanel.add(companyField);
		fieldPanel.add(energyField);
		mainPanel.add(fieldPanel);
		return mainPanel;
	}

	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		new Indicator();
	}
}