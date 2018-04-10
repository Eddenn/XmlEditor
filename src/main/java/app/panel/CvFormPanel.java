package app.panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CvFormPanel extends JPanel{

    private JTextField prenom;
    private JTextField nom;
    private JCheckBox cbStage;
    private JCheckBox cbEmploi;
    private JTextField objectif;

    public CvFormPanel() {
        FlowLayout leftFlowLayout = new FlowLayout(FlowLayout.LEFT);
        //Identitée
        JPanel identitePanel = new JPanel();
        identitePanel.setLayout(new BoxLayout(identitePanel,BoxLayout.Y_AXIS));
        identitePanel.setBorder(BorderFactory.createTitledBorder("Identitée"));
        {
            prenom = new JTextField(50);
            JPanel p = new JPanel(leftFlowLayout);
            {
                p.add(new JLabel("Prénom :"));
                p.add(prenom);
            }
            identitePanel.add(p);

            nom = new JTextField(50);
            p = new JPanel(leftFlowLayout);
            {
                p.add(new JLabel("Nom :"));
                p.add(nom);
            }
            identitePanel.add(p);

        }
        add(identitePanel);

        //Objectif
        JPanel objectifPanel = new JPanel();
        objectifPanel.setLayout(new BoxLayout(objectifPanel,BoxLayout.Y_AXIS));
        objectifPanel.setBorder(BorderFactory.createTitledBorder("Objectif"));
        {
            cbStage = new JCheckBox("Stage",true);
            cbStage.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if(cbStage.isSelected()) cbEmploi.setSelected(false);
                    else cbStage.setSelected(true);
                }
            });
            cbEmploi = new JCheckBox("Emploi",false);
            cbEmploi.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if(cbEmploi.isSelected()) cbStage.setSelected(false);
                    else cbEmploi.setSelected(true);
                }
            });
            JPanel p = new JPanel(leftFlowLayout);
            {
                p.add(cbStage);
                p.add(cbEmploi);
            }
            objectifPanel.add(p);

            objectif = new JTextField(50);
            p = new JPanel(leftFlowLayout);
            {
                p.add(new JLabel("Objectif :"));
                p.add(objectif);
            }
            objectifPanel.add(p);

        }
        add(objectifPanel);

        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
    }

}
