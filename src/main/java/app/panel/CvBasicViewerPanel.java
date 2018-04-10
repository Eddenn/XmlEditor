package app.panel;

import app.util.CvUtils;

import javax.swing.*;
import javax.xml.ws.http.HTTPException;
import java.io.IOException;

public class CvBasicViewerPanel extends JPanel{

    private ActionType type;

    public CvBasicViewerPanel(ActionType type) {
        this.type = type;
    }

    public void load() {
        String content = "";
        try {
            content = CvUtils.doAction(type);
        } catch (HTTPException e1) {
            JOptionPane.showMessageDialog(null,"Code de retour : "+e1.getStatusCode(),"Erreur lors de la requête",JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Connection au service impossible","Erreur lors de la connection au service",JOptionPane.ERROR_MESSAGE);
        }

        add(new JLabel(content));
    }
}
