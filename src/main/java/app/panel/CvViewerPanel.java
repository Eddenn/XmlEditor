package app.panel;

import app.util.CvUtils;

import javax.swing.*;
import javax.xml.ws.http.HTTPException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CvViewerPanel extends JPanel {

    private JTextField textField;
    private JButton button;
    private JEditorPane view;
    private final ActionType type;

    public CvViewerPanel(final ActionType type) {
        this.type = type;
        setLayout(new BorderLayout());

        view = new JEditorPane();
        view.setEditable(false);
        if(type == ActionType.RESUME) view.setContentType("application/xml");
        else view.setContentType("text/html");
        textField = new JTextField();
        button = new JButton("Envoyer");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = textField.getText();
                String cv = "";
                try {
                    cv = CvUtils.doAction(type,id);
                } catch (HTTPException e1) {
                    JOptionPane.showMessageDialog(null,"Code de retour : "+e1.getStatusCode(),"Erreur lors de la requête",JOptionPane.ERROR_MESSAGE);
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(null,"Connection au service impossible","Erreur lors de la connection au service",JOptionPane.ERROR_MESSAGE);
                }
                view.getEditorKit().createDefaultDocument();
                view.setText("<html>"+cv+"</html>");
            }
        });

        JPanel p = new JPanel(new BorderLayout()); {
            p.add(textField,BorderLayout.CENTER);
            p.add(button,BorderLayout.EAST);
        }
        add(p, BorderLayout.NORTH);

        add(new JScrollPane(view), BorderLayout.CENTER);
    }

}
