package app.panel;

import app.util.CvUtils;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.ws.http.HTTPException;
import java.awt.*;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

public class CvBasicViewerPanel extends JPanel{

    private ActionType type;
    private JEditorPane view;

    public CvBasicViewerPanel(ActionType type) {
        setLayout(new BorderLayout());

        this.type = type;
        view = new JEditorPane();
        view.setEditable(false);
        if(type == ActionType.RESUME) view.setContentType("application/xml");
        else view.setContentType("text/html");

        add(new JScrollPane(view), BorderLayout.CENTER);
    }

    public void load() {
        view.setText("");
        String content = "";
        try {
            content = CvUtils.doAction(type);
        } catch (HTTPException e1) {
            JOptionPane.showMessageDialog(null,"Code de retour : "+e1.getStatusCode(),"Erreur lors de la requête",JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Connection au service impossible","Erreur lors de la connection au service",JOptionPane.ERROR_MESSAGE);
        }

        if(type == ActionType.RESUME) {
            try {
                content = CvUtils.format(content, true);
                view.setText(content);
            } catch (IOException | SAXException | ParserConfigurationException e) {
                view.setText(content);
            }
        } else {
            view.setText(content);
        }
    }
}
