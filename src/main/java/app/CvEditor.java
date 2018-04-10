package app;

import app.panel.*;
import app.util.CvUtils;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

public class CvEditor {

    private JFrame mainFrame;
    private JMenuBar menuBar;
    private JMenu preferenceMenu;
    private JMenuItem configMenuItem;

    private JTabbedPane tabPanel;
    private CvFormPanel formAddPanel;
    private CvFormPanel formModifyPanel;
    private CvViewerPanel viewPanel;
    private CvViewerPanel deletePanel;
    private CvBasicViewerPanel homePanel;
    private CvBasicViewerPanel resumePanel;
    private CvBasicViewerPanel helpPanel;

    public CvEditor() {
        createModel();
        createComponents();
        placeComponents();
        createController();
    }

    public void display() {
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
        if (tabPanel.getSelectedComponent() instanceof CvBasicViewerPanel) {
            CvBasicViewerPanel cvPanel = (CvBasicViewerPanel) tabPanel.getSelectedComponent();
            cvPanel.load();
        }
    }

    private void createModel() {

    }

    private void createComponents() {
        mainFrame = new JFrame("Cv Editor");
        mainFrame.setSize(800,600);

        menuBar = new JMenuBar();
        preferenceMenu = new JMenu("Préférences");
        configMenuItem = new JMenuItem("Configuration");
        preferenceMenu.add(configMenuItem);
        menuBar.add(preferenceMenu);
        mainFrame.setJMenuBar(menuBar);

        tabPanel = new JTabbedPane();
        formAddPanel = new CvFormPanel();
        formModifyPanel = new CvFormPanel();
        viewPanel = new CvViewerPanel(ActionType.DETAIL);
        deletePanel = new CvViewerPanel(ActionType.DELETE);
        homePanel = new CvBasicViewerPanel(ActionType.HOME);
        resumePanel = new CvBasicViewerPanel(ActionType.RESUME);
        helpPanel = new CvBasicViewerPanel(ActionType.HELP);
    }

    private void placeComponents() {
        tabPanel.add("Accueil",homePanel);
        tabPanel.add("Liste des CVs",resumePanel);
        tabPanel.add("Aide",helpPanel);
        tabPanel.add("Détail d'un CV",viewPanel);
        tabPanel.add("Ajouter un CV",formAddPanel);
        tabPanel.add("Supprimer un CV",deletePanel);
        tabPanel.add("Modifier un CV",formModifyPanel);
        mainFrame.add(tabPanel);
    }

    private void createController() {
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        configMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String host_url = JOptionPane.showInputDialog(mainFrame,"Configuration de l'hôte :","Configuration du service",JOptionPane.PLAIN_MESSAGE);
                String port = JOptionPane.showInputDialog(mainFrame,"Configuration du port :","Configuration du service",JOptionPane.PLAIN_MESSAGE);
                String service_path = JOptionPane.showInputDialog(mainFrame,"Configuration de le chemin du service :","Configuration du service",JOptionPane.PLAIN_MESSAGE);

                if(port != null && host_url != null && service_path != null) {
                    try {
                        int iPort = Integer.parseInt(port);
                        try {
                            CvUtils.setHostUrl(host_url);
                        } catch (MalformedURLException e2) {
                            JOptionPane.showMessageDialog(mainFrame,"L'hôte est mal formé.","Erreur lors de l'entrée de l'hôte",JOptionPane.ERROR_MESSAGE);
                        }
                        CvUtils.setPort(iPort);
                        CvUtils.setServicePath(service_path);
                    } catch (NumberFormatException e1) {
                        JOptionPane.showMessageDialog(mainFrame,"Le port doit être un entier.","Erreur lors de l'entrée du port",JOptionPane.ERROR_MESSAGE);
                    }

                }
            }
        });

        tabPanel.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                if (tabPanel.getSelectedComponent() instanceof CvBasicViewerPanel) {
                    CvBasicViewerPanel cvPanel = (CvBasicViewerPanel) tabPanel.getSelectedComponent();
                    cvPanel.load();
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CvEditor().display();
            }
        });
    }
}
