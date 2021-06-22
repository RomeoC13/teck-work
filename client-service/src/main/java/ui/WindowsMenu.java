package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.SystemColor;

public class WindowsMenu extends JFrame {


    private JPanel panelTop = new JPanel();
    private JPanel panelLeft = new JPanel();
    private JPanel panelRight = new JPanel();
    private JPanel panelCenter = new JPanel();
    private JPanel panel;
    private Side_Menu sm;


    public WindowsMenu(String companyName) {
        this.setVisible(true);
        this.setTitle("Page d'accueil");
        this.setSize(676, 500);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        sm = new Side_Menu(companyName);
        //the general panel
        panel = (JPanel) this.getContentPane();
        panel.setLayout(new BorderLayout());

        // the left panel contains the menu
        panel.add(BorderLayout.WEST, sm);
        // the right panel contains
        //panel.add(BorderLayout.EAST,optionRightPanel());
        // the centered panel contains
        panel.add(BorderLayout.CENTER, optionCenteredPanel());

        // the top panel contains
        //panel.add(BorderLayout.NORTH, optionTopPanel());
        //this.setd
        if(!companyName.equals("Mairie"))
            sm.getIndicator().setEnabled(false);
        else if (sm.getDeconnexion().getActionCommand().equals("D�connexion"))
            this.dispose();

    }

    private JPanel optionCenteredPanel() {

        panelCenter = new JPanel();
        JLabel lab1 = new JLabel("centre");
        panelCenter.add(lab1);
        panelCenter.setBackground(SystemColor.inactiveCaptionBorder);
        return panelCenter;
    }


    private JPanel optionRightPanel() {
        panelRight = new JPanel();
        JLabel lab2 = new JLabel("droite");
        panelRight.add(lab2);
        panelRight.setBackground(SystemColor.inactiveCaptionBorder);
        return panelRight;
    }


    private JPanel optionTopPanel() {
        panelTop = new JPanel();
        JLabel lab4 = new JLabel();

        lab4.setFont(new Font("Serif", Font.CENTER_BASELINE, 20));
        lab4.setText("<html><body><font color='blanc'>Entreprise: Tech-Work </body></html>");
        panelTop.add(lab4);

        panelTop.setBackground(Color.white);
        return panelTop;
    }

    public JPanel getPanelCenter() {
        return panelCenter;
    }

    public void setPanelCenter(JPanel panelCenter) {
        this.panelCenter = panelCenter;
    }

    public static void main(String[] args) {
		new WindowsMenu(null);
	}
}
