package app.panel;

import app.model.*;
import app.util.CvUtils;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.ws.http.HTTPException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;

public class CvFormPanel extends JPanel{

    private static final FlowLayout leftFlowLayout = new FlowLayout(FlowLayout.LEFT);

    private JTextField id;
    private JTextField prenom;
    private JTextField nom;
    private JRadioButton rbStage;
    private JRadioButton rbEmploi;
    private JTextField objectif;

    private final ActionType actionType;
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

    public CvFormPanel(final ActionType actionType) {
        if(actionType != ActionType.ADD && actionType != ActionType.MODIFY) throw new IllegalArgumentException("CvFormPanel ne peux avoir que ADD ou MODIFY en action.");
        this.actionType = actionType;

        JScrollPane jScrollPane = new JScrollPane(initializeForm());
        jScrollPane.getVerticalScrollBar().setUnitIncrement(16);
        setLayout(new BorderLayout());
        add(jScrollPane,BorderLayout.CENTER);
        actionButton = new JButton("Envoyer");
        actionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(actionType == ActionType.ADD) {
                    Cvi cvi = getCvi();
                    try {
                        StringWriter xml = CvUtils.marshal(cvi);
                        try {
                            String response = CvUtils.doAction(ActionType.ADD,xml);
                            try {
                                response = CvUtils.format(response,true);
                            } catch (SAXException | ParserConfigurationException e1) {
                                System.err.println("Fail lors du parsing de la réponse XML.");
                            }
                            JEditorPane view = new JEditorPane();
                            view.setEditable(false);
                            view.setContentType("application/xml");
                            view.setText(response);
                            JScrollPane jsp = new JScrollPane(view);
                            jsp.setPreferredSize(new Dimension(600,300));
                            JOptionPane.showMessageDialog(null,jsp,"Réponse de la requête",JOptionPane.INFORMATION_MESSAGE);
                        } catch (HTTPException e1) {
                            JOptionPane.showMessageDialog(null,"Code de retour : "+e1.getStatusCode(),"Erreur lors de la requête",JOptionPane.ERROR_MESSAGE);
                        } catch (IOException e1) {
                            JOptionPane.showMessageDialog(null,"Impossible de lire la réponse","Erreur lors de l'envoi du formulaire",JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (JAXBException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    Cvi cvi = getCvi();
                    try {
                        StringWriter xml = CvUtils.marshal(cvi);
                        try {
                            String response = CvUtils.doAction(ActionType.MODIFY,id.getText(),xml);
                            try {
                                response = CvUtils.format(response,true);
                            } catch (SAXException | ParserConfigurationException e1) {
                                System.err.println("Fail lors du parsing de la réponse XML.");
                            }
                            JEditorPane view = new JEditorPane();
                            view.setEditable(false);
                            view.setContentType("application/xml");
                            view.setText(response);
                            JScrollPane jsp = new JScrollPane(view);
                            jsp.setPreferredSize(new Dimension(600,300));
                            JOptionPane.showMessageDialog(null,jsp,"Réponse de la requête",JOptionPane.INFORMATION_MESSAGE);
                        } catch (HTTPException e1) {
                            JOptionPane.showMessageDialog(null,"Code de retour : "+e1.getStatusCode(),"Erreur lors de la requête",JOptionPane.ERROR_MESSAGE);
                        } catch (IOException e1) {
                            JOptionPane.showMessageDialog(null,"Impossible de lire la réponse","Erreur lors de l'envoi du formulaire",JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (JAXBException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        add(actionButton,BorderLayout.SOUTH);
    }

    private JPanel initializeForm() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));

        if(actionType == ActionType.MODIFY) {
            mainPanel.add(createIdPanel());
        }

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
    private JPanel createIdPanel() {
        JPanel panel = createBasePanel("Id");
        {
            id = new JTextField(50);
            JPanel p = new JPanel(leftFlowLayout);
            {
                p.add(new JLabel("Id :"));
                p.add(id);
            }
            panel.add(p);

        }
        return panel;
    }

    private JPanel createIdentitePanel() {
        JPanel panel = createBasePanel("Identitée (*)");
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
        JPanel panel = createBasePanel("Objectif (*)");
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
            expeList.setCellRenderer(new DefaultListCellRenderer() {
                @Override
                public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                    Component c =  super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                    setText( CvFormPanel.toString((Cvi.Prof.Expe) value) );
                    return c;
                }
            });

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
            diversList.setCellRenderer(new DefaultListCellRenderer() {
                @Override
                public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                    Component c =  super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                    setText( CvFormPanel.toString((Cvi.Divers) value) );
                    return c;
                }
            });

            p.add(diversList,BorderLayout.CENTER);
            JPanel q = new JPanel(new BorderLayout()); {
                JButton addExpeButton = new JButton("Ajouter");
                addExpeButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(diversListModel.size() < 5) {
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
                        } else {
                            JOptionPane.showMessageDialog(null, "Vous ne pouvez pas ajouter plus de 5 informations complémentaires.", "Impossible d'ajouter une information complémentaire supplémentaire", JOptionPane.ERROR_MESSAGE);
                        }
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
        JPanel diplomePanel = createBasePanel("Diplomes (*)");
        {
            JPanel p = new JPanel(new BorderLayout());
            {
                //--Debut liste des diplomes
                diplomeListModel = new DefaultListModel<Cvi.Competences.Diplome>();
                diplomeList = new JList<Cvi.Competences.Diplome>(diplomeListModel);
                diplomeList.setCellRenderer(new DefaultListCellRenderer() {
                    @Override
                    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                        Component c =  super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                        setText( CvFormPanel.toString((Cvi.Competences.Diplome) value) );
                        return c;
                    }
                });

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
                certifList.setCellRenderer(new DefaultListCellRenderer() {
                    @Override
                    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                        Component c =  super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                        setText( CvFormPanel.toString((Cvi.Competences.Certif) value) );
                        return c;
                    }
                });

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
        JPanel panel = createBasePanel("Langues vivantes (*)");

        {
            JPanel p = new JPanel(new BorderLayout());
            {
                //--Debut liste des diplomes
                lvListModel = new DefaultListModel<Cvi.Competences.Lv>();
                lvList = new JList<Cvi.Competences.Lv>(lvListModel);
                lvList.setCellRenderer(new DefaultListCellRenderer() {
                    @Override
                    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                        Component c =  super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                        setText( CvFormPanel.toString((Cvi.Competences.Lv)value) );
                        return c;
                    }
                });

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
        JPanel panel = createBasePanel("Liste des languages de programmation (*)");

        JPanel p = new JPanel(new BorderLayout());
        {
            //--Debut liste des experiences
            infoListModel = new DefaultListModel<Cvi.Competences.Info.Langage>();
            infoList = new JList<Cvi.Competences.Info.Langage>(infoListModel);
            infoList.setCellRenderer(new DefaultListCellRenderer() {
                @Override
                public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                    Component c =  super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                    setText( CvFormPanel.toString((Cvi.Competences.Info.Langage)value) );
                    return c;
                }
            });

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

    public static String toString(Cvi.Competences.Lv lv) {
        if(lv.getNivs() == null) return lv.getIso() +" - "+ lv.getCert() +"["+lv.getNivi()+"]";
        else return lv.getIso() +" - "+ lv.getCert() +"["+lv.getNivs()+"]";
    }

    public static String toString(Cvi.Prof.Expe expe) {
        return expe.getDatedeb() + " -> " + expe.getDatefin() + " : " + expe.getDescript();
    }

    public static String toString(Cvi.Competences.Diplome diplome) {
        return diplome.getDate() +" - "+ diplome.getDescript() +" ("+diplome.getInstitut()+") ["+ diplome.getNiveau()+"]";
    }

    public static String toString(Cvi.Competences.Certif certif) {
        return certif.getDatedeb() + " -> " + certif.getDatefin() + " : " + certif.getDescript();
    }

    public static String toString(Cvi.Competences.Info.Langage langage) {
        return langage.getNom() + " ("+langage.getNiveau()+")";
    }

    public static String toString(Cvi.Divers divers) {
        return divers.getDescript();
    }

    public Cvi getCvi() {
        Cvi cvi = new Cvi();

        //Identitee
        Cvi.Identite identite = new Cvi.Identite();
        identite.setNom(nom.getText());
        identite.setPrenom(prenom.getText());
        cvi.setIdentite(identite);

        //Objectif
        Cvi.Objectif obj1 = new Cvi.Objectif();
        if(rbEmploi.isSelected()) {
            obj1.setEmploi(objectif.getText());
        } else {
            obj1.setStage(objectif.getText());
        }
        cvi.setObjectif(obj1);

        //Experiences professionnelles
        Cvi.Prof prof = new Cvi.Prof();
        for (Object e: expeListModel.toArray()) {
            prof.getExpe().add((Cvi.Prof.Expe)e);
        }
        cvi.setProf(prof);

        //Competences
        Cvi.Competences competences = new Cvi.Competences();
        for (Object d: diplomeListModel.toArray()) {
            competences.getDiplome().add((Cvi.Competences.Diplome)d);
        }
        for (Object c: certifListModel.toArray()) {
            competences.getCertif().add((Cvi.Competences.Certif)c);
        }
        for (Object l: lvListModel.toArray()) {
            competences.getLv().add((Cvi.Competences.Lv)l);
        }
        Cvi.Competences.Info info = new Cvi.Competences.Info();
        for (Object l: infoListModel.toArray()) {
            info.getLangage().add((Cvi.Competences.Info.Langage)l);
        }
        competences.setInfo(info);
        cvi.setCompetences(competences);


        //Divers
        for (Object d: diversListModel.toArray()) {
            cvi.getDivers().add((Cvi.Divers)d);
        }

        return cvi;
    }
}
