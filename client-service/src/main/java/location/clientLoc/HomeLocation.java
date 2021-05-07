package location.clientLoc;

import location.serveurLoc.serveurLoc;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeLocation {
    static JFrame frame=new JFrame("Réservation d'un espace");
    static JPanel panel = new JPanel();
    static serveurLoc r = new serveurLoc();
    static boolean b = true;

    static class StyledButtonUI extends BasicButtonUI {

        @Override
        public void installUI(JComponent c) {
            super.installUI(c);
            AbstractButton button = (AbstractButton) c;
            button.setOpaque(false);
            button.setBorder(new EmptyBorder(5, 15, 5, 15));
        }

        @Override
        public void paint(Graphics g, JComponent c) {
            AbstractButton b = (AbstractButton) c;
            paintBackground(g, b, b.getModel().isPressed() ? 2 : 0);
            super.paint(g, c);
        }

        private void paintBackground(Graphics g, JComponent c, int yOffset) {
            Dimension size = c.getSize();
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.setColor(c.getBackground().darker());
            g.fillRoundRect(0, yOffset, size.width, size.height - yOffset, 10, 10);
            g.setColor(c.getBackground());
            g.fillRoundRect(0, yOffset, size.width, size.height + yOffset - 5, 10, 10);
        }
    }

    public static class ActionPlan implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            panel.removeAll();
            frame.dispose();
            Plan p = new Plan();
            String[] args = {};
            p.main(args);
        }
    }

    public static class ActionAccueil implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            panel.removeAll();
            frame.dispose();
            HomeLoc h = new HomeLoc();
            String[] args = {};
            h.main(args);
        }
    }

    public static class ActionFormulaire implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            panel.removeAll();
            Location.panelFormulaire.removeAll();
            frame.dispose();
            Location l = new Location();
            String[] args = {};
            l.main(args);
        }
    }


    public static void main(String[] args) {
        if(b) {
            r.init();
            b = false;
        }

        System.out.println("oui");

        final JButton buttonAccueil = new JButton("Accueil");
        buttonAccueil.addActionListener(new HomeLoc.ActionAccueil());
        buttonAccueil.setFont(new Font("Calibri", Font.PLAIN, 14));
        buttonAccueil.setBackground(new Color(0x3C4DCE));
        buttonAccueil.setForeground(Color.white);
        buttonAccueil.setUI(new HomeLoc.StyledButtonUI());
        panel.add(buttonAccueil);

        final JButton buttonPlan = new JButton("Plan");
        buttonPlan.addActionListener(new HomeLoc.ActionPlan());
        buttonPlan.setFont(new Font("Calibri", Font.PLAIN, 14));
        buttonPlan.setBackground(new Color(0x3C4DCE));
        buttonPlan.setForeground(Color.white);
        buttonPlan.setUI(new HomeLoc.StyledButtonUI());
        panel.add(buttonPlan);

        final JButton buttonFormulaire = new JButton("Formulaire");
        buttonFormulaire.addActionListener(new HomeLoc.ActionFormulaire());
        buttonFormulaire.setFont(new Font("Calibri", Font.PLAIN, 14));
        buttonFormulaire.setBackground(new Color(0x3C4DCE));
        buttonFormulaire.setForeground(Color.white);
        buttonFormulaire.setUI(new HomeLoc.StyledButtonUI());
        panel.add(buttonFormulaire);

        frame.add(panel);
        frame.setSize(800,500);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}