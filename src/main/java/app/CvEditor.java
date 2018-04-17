package app;

import app.panel.*;
import app.util.CvUtils;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.ws.http.HTTPException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;

public class CvEditor {

    private JFrame mainFrame;
    private JMenuBar menuBar;
    private JMenu preferenceMenu;
    private JMenuItem configMenuItem;
    private JMenu fileMenu;
    private JMenuItem openMenuItem;

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

        fileMenu = new JMenu("Fichier");
        openMenuItem = new JMenuItem("Envoyer un CV");
        fileMenu.add(openMenuItem);
        menuBar.add(fileMenu);

        preferenceMenu = new JMenu("Préférences");
        configMenuItem = new JMenuItem("Configuration");
        preferenceMenu.add(configMenuItem);
        menuBar.add(preferenceMenu);

        mainFrame.setJMenuBar(menuBar);

        tabPanel = new JTabbedPane();
        formAddPanel = new CvFormPanel(ActionType.ADD);
        formModifyPanel = new CvFormPanel(ActionType.MODIFY);
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
                String service_path = JOptionPane.showInputDialog(mainFrame,"Configuration de le chemin du service :","Configuration du service",JOptionPane.PLAIN_MESSAGE);

                if(service_path != null) {
                    try {
                        CvUtils.setServicePath(service_path);
                    } catch (MalformedURLException e2) {
                        JOptionPane.showMessageDialog(mainFrame,"Le chemin d'accès au service est mal formé.","Erreur lors de l'entrée du chemin d'accès au service",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        openMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("XML file", "xml");
                chooser.setFileFilter(filter);
                int returnVal = chooser.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    FileReader file = null;
                    try {
                        file = new FileReader(chooser.getSelectedFile().getAbsolutePath());
                        CvUtils.doAction(ActionType.ADD,file);
                    } catch (IOException e1) {
                        JOptionPane.showMessageDialog(mainFrame,"Le fichier fourni n'a pas pu être lu.","Erreur lors de la lecture du fichier",JOptionPane.ERROR_MESSAGE);
                    } catch (HTTPException e1) {
                        JOptionPane.showMessageDialog(null,"Code de retour : "+e1.getStatusCode(),"Erreur lors de la requête",JOptionPane.ERROR_MESSAGE);
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
