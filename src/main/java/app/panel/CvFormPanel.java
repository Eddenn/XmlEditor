package app.panel;

import app.model.Cvi;
import app.model.Langues;
import app.model.NiveauCertif;
import app.model.NiveauDiplome;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CvFormPanel extends JPanel{

    private static final FlowLayout leftFlowLayout = new FlowLayout(FlowLayout.LEFT);
    private JTextField prenom;
    private JTextField nom;
    private JRadioButton rbStage;
    private JRadioButton rbEmploi;
    private JTextField objectif;
    private ActionType actionType;
    private JButton actionButton;

    private DefaultListModel<Cvi.Prof.Expe> expeListModel;
    private JList<Cvi.Prof.Expe> expeList;

    private DefaultListModel<Cvi.Competences.Diplome> diplomeListModel;
    private JList<Cvi.Competences.Diplome> diplomeList;

    private DefaultListModel<Cvi.Competences.Certif> certifListModel;
    private JList<Cvi.Competences.Certif> certifList;

    private DefaultListModel<Cvi.Competences.Lv> lvListModel;
    private JList<Cvi.Competences.Lv> lvList;

    private DefaultListModel<Cvi.Competences.Info.Langage> infoListModel;
    private JList<Cvi.Competences.Info.Langage> infoList;

    private DefaultListModel<Cvi.Divers> diversListModel;
    private JList<Cvi.Divers> diversList;

    public CvFormPanel(ActionType actionType) {
        if(actionType != ActionType.ADD && actionType != ActionType.MODIFY) throw new IllegalArgumentException("CvFormPanel ne peux avoir que ADD ou MODIFY en action.");
        this.actionType = actionType;

        JScrollPane jScrollPane = new JScrollPane(initializeForm());
        jScrollPane.getVerticalScrollBar().setUnitIncrement(16);
        setLayout(new BorderLayout());
        add(jScrollPane,BorderLayout.CENTER);
        actionButton = new JButton("Envoyer");
        add(actionButton,BorderLayout.SOUTH);
    }

    private JPanel initializeForm() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));

        //Identitée
        mainPanel.add(createIdentitePanel());

        //Objectif
        mainPanel.add(createObjectifPanel());

        //Expérences professionnelles
        mainPanel.add(createProfPanel());

        //Compétences
        mainPanel.add(createCompetencesPanel());

        //Divers
        mainPanel.add(createDiversPanel());

        return mainPanel;
    }

    private JPanel createBasePanel(String name) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder(name));
        Border border = panel.getBorder();
        Border margin = new EmptyBorder(10,10,10,10);
        panel.setBorder(new CompoundBorder(border, margin));
        return panel;
    }

    //---Panel principaux---

    private JPanel createIdentitePanel() {
        JPanel panel = createBasePanel("Identitée");
        {
            prenom = new JTextField(50);
            JPanel p = new JPanel(leftFlowLayout);
            {
                p.add(new JLabel("Prénom :"));
                p.add(prenom);
            }
            panel.add(p);

            nom = new JTextField(50);
            p = new JPanel(leftFlowLayout);
            {
                p.add(new JLabel("Nom :"));
                p.add(nom);
            }
            panel.add(p);

        }
        return panel;
    }

    private JPanel createObjectifPanel() {
        JPanel panel = createBasePanel("Objectif");
        {
            ButtonGroup objectifChoice = new ButtonGroup();
            rbStage = new JRadioButton("Stage",true);
            rbEmploi = new JRadioButton("Emploi",false);
            objectifChoice.add(rbStage);
            objectifChoice.add(rbEmploi);
            JPanel p = new JPanel(leftFlowLayout);
            {
                p.add(rbStage);
                p.add(rbEmploi);
            }
            panel.add(p);

            objectif = new JTextField(50);
            p = new JPanel(leftFlowLayout);
            {
                p.add(new JLabel("Objectif :"));
                p.add(objectif);
            }
            panel.add(p);

        }
        return panel;
    }

    private JPanel createProfPanel() {
        JPanel panel = createBasePanel("Expériences professionnelles");

        JPanel p = new JPanel(new BorderLayout());
        {
            //--Debut liste des experiences
            expeListModel = new DefaultListModel<Cvi.Prof.Expe>();
            expeList = new JList<Cvi.Prof.Expe>(expeListModel);

            p.add(expeList,BorderLayout.CENTER);
            JPanel q = new JPanel(new BorderLayout()); {
                JButton addExpeButton = new JButton("Ajouter");
                addExpeButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Cvi.Prof.Expe tmpExpe = new Cvi.Prof.Expe();
                        try {
                            String expeDateDeb = JOptionPane.showInputDialog(null, "Entrer une date de début(*) :", "Entrée d'une expérience professionnelle", JOptionPane.PLAIN_MESSAGE);
                            if (expeDateDeb == null) throw new NullPointerException();
                            tmpExpe.setDatedeb(expeDateDeb);

                            String expeDateFin = JOptionPane.showInputDialog(null, "Entrer une date de fin :", "Entrée d'une expérience professionnelle", JOptionPane.PLAIN_MESSAGE);
                            tmpExpe.setDatefin(expeDateFin);

                            String expeDescript = JOptionPane.showInputDialog(null, "Entrer une description(*) :", "Entrée d'une expérience professionnelle", JOptionPane.PLAIN_MESSAGE);
                            if (expeDescript == null) throw new NullPointerException();
                            tmpExpe.setDescript(expeDescript);
                        } catch (NullPointerException e1) {
                            JOptionPane.showMessageDialog(null, "Vous devez saisir tous les champs obligatoire", "Impossible d'ajouter une expérience professionnelle", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        expeListModel.addElement(tmpExpe);
                    }
                });
                q.add(addExpeButton,BorderLayout.EAST);
                JButton removeExpeButton = new JButton("Supprimer");
                removeExpeButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(expeList.getSelectedIndex() != -1) expeListModel.remove(expeList.getSelectedIndex());
                    }
                });
                q.add(removeExpeButton,BorderLayout.WEST);
            }
            p.add(q,BorderLayout.SOUTH);
            //---Fin liste des expériences
        }
        panel.add(p);

        return panel;
    }

    private JPanel createCompetencesPanel() {
        JPanel panel = createBasePanel("Compétences");

        panel.add(createDiplomePanel());
        panel.add(createCertifPanel());
        panel.add(createLangLevelPanel());
        panel.add(createInfo());

        return panel;
    }

    private JPanel createDiversPanel() {
        JPanel panel = createBasePanel("Divers");

        JPanel p = new JPanel(new BorderLayout());
        {
            //--Debut liste des experiences
            diversListModel = new DefaultListModel<Cvi.Divers>();
            diversList = new JList<Cvi.Divers>(diversListModel);

            p.add(diversList,BorderLayout.CENTER);
            JPanel q = new JPanel(new BorderLayout()); {
                JButton addExpeButton = new JButton("Ajouter");
                addExpeButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Cvi.Divers tmp = new Cvi.Divers();
                        try {
                            String desc = JOptionPane.showInputDialog(null, "Entrer une description(*) :", "Entrée d'information complémentaire", JOptionPane.PLAIN_MESSAGE);
                            if (desc == null) throw new NullPointerException();
                            tmp.setDescript(desc);
                        } catch (NullPointerException e1) {
                            JOptionPane.showMessageDialog(null, "Vous devez saisir tous les champs obligatoire", "Impossible d'ajouter une information complémentaire", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        diversListModel.addElement(tmp);
                    }
                });
                q.add(addExpeButton,BorderLayout.EAST);
                JButton removeExpeButton = new JButton("Supprimer");
                removeExpeButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(diversList.getSelectedIndex() != -1) diversListModel.remove(diversList.getSelectedIndex());
                    }
                });
                q.add(removeExpeButton,BorderLayout.WEST);
            }
            p.add(q,BorderLayout.SOUTH);
            //---Fin liste des expériences
        }
        panel.add(p);

        return panel;
    }

    //---Panels inclu dans les principaux---

    private JPanel createDiplomePanel() {
        JPanel diplomePanel = createBasePanel("Diplomes");
        {
            JPanel p = new JPanel(new BorderLayout());
            {
                //--Debut liste des diplomes
                diplomeListModel = new DefaultListModel<Cvi.Competences.Diplome>();
                diplomeList = new JList<Cvi.Competences.Diplome>(diplomeListModel);

                p.add(diplomeList, BorderLayout.CENTER);
                JPanel q = new JPanel(new BorderLayout());
                {
                    JButton addExpeButton = new JButton("Ajouter");
                    addExpeButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (diplomeListModel.size() < 5) {
                                Cvi.Competences.Diplome tempDiplome = new Cvi.Competences.Diplome();
                                try {
                                    String date = JOptionPane.showInputDialog(null, "Entrer une date(*) :", "Entrée d'un diplome", JOptionPane.PLAIN_MESSAGE);
                                    if(date == null) throw new NullPointerException();
                                    tempDiplome.setDate(date);

                                    String desc = JOptionPane.showInputDialog(null, "Entrer une description(*) :", "Entrée d'un diplome", JOptionPane.PLAIN_MESSAGE);
                                    if(desc == null) throw new NullPointerException();
                                    tempDiplome.setDescript(desc);

                                    String institut = JOptionPane.showInputDialog(null, "Entrer un institut(*) :", "Entrée d'un diplome", JOptionPane.PLAIN_MESSAGE);
                                    if(institut == null) throw new NullPointerException();
                                    tempDiplome.setInstitut(institut);

                                    NiveauDiplome niv = (NiveauDiplome) JOptionPane.showInputDialog(null, "Entrer un niveau de diplome(*) :", "Entrée d'un diplome", JOptionPane.PLAIN_MESSAGE, null, NiveauDiplome.values(), NiveauDiplome.values()[0]);
                                    if(niv == null) throw new NullPointerException();
                                    tempDiplome.setNiveau(niv);
                                } catch (NullPointerException e1) {
                                    JOptionPane.showMessageDialog(null, "Vous devez saisir tous les champs obligatoire", "Impossible d'ajouter un diplome", JOptionPane.ERROR_MESSAGE);
                                    return;
                                }
                                diplomeListModel.addElement(tempDiplome);
                            } else {
                                JOptionPane.showMessageDialog(null, "Vous ne pouvez pas ajouter plus de 5 diplome.", "Impossible d'ajouter un diplome supplémentaire", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    });
                    q.add(addExpeButton, BorderLayout.EAST);
                    JButton removeExpeButton = new JButton("Supprimer");
                    removeExpeButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (diplomeList.getSelectedIndex() != -1)
                                diplomeListModel.remove(diplomeList.getSelectedIndex());
                        }
                    });
                    q.add(removeExpeButton, BorderLayout.WEST);
                }
                p.add(q, BorderLayout.SOUTH);
                //---Fin liste des diplomes
            }
            diplomePanel.add(p);
        }
        return diplomePanel;
    }

    private JPanel createCertifPanel() {
        JPanel diplomePanel = createBasePanel("Certifications");
        {
            JPanel p = new JPanel(new BorderLayout());
            {
                //--Debut liste des diplomes
                certifListModel = new DefaultListModel<Cvi.Competences.Certif>();
                certifList = new JList<Cvi.Competences.Certif>(certifListModel);

                p.add(certifList, BorderLayout.CENTER);
                JPanel q = new JPanel(new BorderLayout());
                {
                    JButton addExpeButton = new JButton("Ajouter");
                    addExpeButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Cvi.Competences.Certif certif = new Cvi.Competences.Certif();
                            try {
                                String expeDateDeb = JOptionPane.showInputDialog(null, "Entrer une date de début(*) :", "Entrée d'une expérience professionnelle", JOptionPane.PLAIN_MESSAGE);
                                if (expeDateDeb == null) throw new NullPointerException();
                                certif.setDatedeb(expeDateDeb);

                                String expeDateFin = JOptionPane.showInputDialog(null, "Entrer une date de fin :", "Entrée d'une expérience professionnelle", JOptionPane.PLAIN_MESSAGE);
                                certif.setDatefin(expeDateFin);

                                String expeDescript = JOptionPane.showInputDialog(null, "Entrer une description(*) :", "Entrée d'une expérience professionnelle", JOptionPane.PLAIN_MESSAGE);
                                if (expeDescript == null) throw new NullPointerException();
                                certif.setDescript(expeDescript);
                            } catch (NullPointerException e1) {
                                JOptionPane.showMessageDialog(null, "Vous devez saisir tous les champs obligatoire", "Impossible d'ajouter une expérience professionnelle", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                            certifListModel.addElement(certif);
                        }
                    });
                    q.add(addExpeButton, BorderLayout.EAST);
                    JButton removeExpeButton = new JButton("Supprimer");
                    removeExpeButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (certifList.getSelectedIndex() != -1)
                                certifListModel.remove(certifList.getSelectedIndex());
                        }
                    });
                    q.add(removeExpeButton, BorderLayout.WEST);
                }
                p.add(q, BorderLayout.SOUTH);
                //---Fin liste des diplomes
            }
            diplomePanel.add(p);
        }
        return diplomePanel;
    }

    private JPanel createLangLevelPanel() {
        JPanel panel = createBasePanel("Langues vivantes");

        {
            JPanel p = new JPanel(new BorderLayout());
            {
                //--Debut liste des diplomes
                lvListModel = new DefaultListModel<Cvi.Competences.Lv>();
                lvList = new JList<Cvi.Competences.Lv>(lvListModel);

                p.add(lvList, BorderLayout.CENTER);
                JPanel q = new JPanel(new BorderLayout());
                {
                    JButton addExpeButton = new JButton("Ajouter");
                    addExpeButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (lvListModel.size() < 5) {
                                Cvi.Competences.Lv tmpLv = new Cvi.Competences.Lv();
                                try {
                                    Langues iso = (Langues) JOptionPane.showInputDialog(null, "Entrer une description de la langue(*) :", "Entrée d'une langue vivante", JOptionPane.PLAIN_MESSAGE,null, Langues.values(), Langues.values()[0]);
                                    if(iso == null) throw new NullPointerException();
                                    tmpLv.setIso(iso);

                                    String cert = JOptionPane.showInputDialog(null, "Entrer le nom de la certification(*) :", "Entrée d'une langue vivante", JOptionPane.PLAIN_MESSAGE);
                                    if(cert == null) throw new NullPointerException();
                                    tmpLv.setCert(cert);

                                    int optionSelect = JOptionPane.showConfirmDialog(null,"Voulez vous entrer le niveau selon l'echelle de valeur ?","Entrée d'une langue vivante",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                                    if(optionSelect == JOptionPane.YES_OPTION) {
                                        NiveauCertif nivs = (NiveauCertif)JOptionPane.showInputDialog(null, "Entrer un niveau selon l'echelle de valeur(*) :", "Entrée d'une langue vivante", JOptionPane.PLAIN_MESSAGE,null, NiveauCertif.values(), NiveauCertif.values()[0]);
                                        if(nivs == null) throw new NullPointerException();
                                        tmpLv.setNivs(nivs);
                                    } else {
                                        String nivi = JOptionPane.showInputDialog(null, "Entrer un niveau selon l'echelle numerique(*) :", "Entrée d'une langue vivante", JOptionPane.PLAIN_MESSAGE);
                                        if(nivi == null) throw new NullPointerException();
                                        Integer inivi;
                                        try {
                                            inivi = Integer.parseInt(nivi);
                                        }catch (NumberFormatException e1) {
                                            JOptionPane.showMessageDialog(null, "Vous devez saisir un nombre", "Impossible d'ajouter une langue vivante", JOptionPane.ERROR_MESSAGE);
                                            return;
                                        }
                                        tmpLv.setNivi(inivi);
                                    }

                                } catch (NullPointerException e1) {
                                    JOptionPane.showMessageDialog(null, "Vous devez saisir tous les champs obligatoire", "Impossible d'ajouter une langue vivante", JOptionPane.ERROR_MESSAGE);
                                    return;
                                }
                                lvListModel.addElement(tmpLv);
                            } else {
                                JOptionPane.showMessageDialog(null, "Vous ne pouvez pas ajouter plus de 5 langue vivante.", "Impossible d'ajouter une langue vivante supplémentaire", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    });
                    q.add(addExpeButton, BorderLayout.EAST);
                    JButton removeExpeButton = new JButton("Supprimer");
                    removeExpeButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (lvList.getSelectedIndex() != -1)
                                lvListModel.remove(lvList.getSelectedIndex());
                        }
                    });
                    q.add(removeExpeButton, BorderLayout.WEST);
                }
                p.add(q, BorderLayout.SOUTH);
                //---Fin liste des diplomes
            }
            panel.add(p);
        }

        return panel;
    }

    private JPanel createInfo() {
        JPanel panel = createBasePanel("Liste des languages de programmation");

        JPanel p = new JPanel(new BorderLayout());
        {
            //--Debut liste des experiences
            infoListModel = new DefaultListModel<Cvi.Competences.Info.Langage>();
            infoList = new JList<Cvi.Competences.Info.Langage>(infoListModel);

            p.add(infoList,BorderLayout.CENTER);
            JPanel q = new JPanel(new BorderLayout()); {
                JButton addExpeButton = new JButton("Ajouter");
                addExpeButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Cvi.Competences.Info.Langage tmp = new Cvi.Competences.Info.Langage();
                        try {
                            String nom = JOptionPane.showInputDialog(null, "Entrer un nom(*) :", "Entrée d'un language de programmation", JOptionPane.PLAIN_MESSAGE);
                            if (nom == null) throw new NullPointerException();
                            tmp.setNom(nom);

                            String niveau = JOptionPane.showInputDialog(null, "Entrer un niveau selon l'echelle numerique(*) :", "Entrée d'un language de programmation", JOptionPane.PLAIN_MESSAGE);
                            if(niveau == null) throw new NullPointerException();
                            Integer inivi;
                            try {
                                inivi = Integer.parseInt(niveau);
                            }catch (NumberFormatException e1) {
                                JOptionPane.showMessageDialog(null, "Vous devez saisir un nombre", "Impossible d'ajouter un language de programmation", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                            tmp.setNiveau(inivi);
                        } catch (NullPointerException e1) {
                            JOptionPane.showMessageDialog(null, "Vous devez saisir tous les champs obligatoire", "Impossible d'ajouter un language de programmation", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        infoListModel.addElement(tmp);
                    }
                });
                q.add(addExpeButton,BorderLayout.EAST);
                JButton removeExpeButton = new JButton("Supprimer");
                removeExpeButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(infoList.getSelectedIndex() != -1) infoListModel.remove(infoList.getSelectedIndex());
                    }
                });
                q.add(removeExpeButton,BorderLayout.WEST);
            }
            p.add(q,BorderLayout.SOUTH);
            //---Fin liste des expériences
        }
        panel.add(p);

        return panel;
    }

}
