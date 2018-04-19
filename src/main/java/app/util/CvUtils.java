package app.util;

import app.model.Cvi;
import app.panel.ActionType;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.ws.http.HTTPException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CvUtils {

    private static String SERVICE_PATH = "https://cvi-manager.herokuapp.com/";

    public static String getServicePath() {
        return SERVICE_PATH;
    }

    public static void setServicePath(String servicePath) throws MalformedURLException {
        new URL(servicePath);
        SERVICE_PATH = servicePath;
    }

    public static String doAction(ActionType type) throws IOException, HTTPException {
        String url = SERVICE_PATH+type.getPath();
        System.out.println("["+type.getMethod().name()+"]"+url);
        return sendRequest(url,type.getMethod().name());
    }

    public static String doAction(ActionType type, String id) throws IOException, HTTPException {
        String url = SERVICE_PATH+type.getPath()+"/"+id;
        System.out.println("["+type.getMethod().name()+"]"+url);
        return sendRequest(url,type.getMethod().name());
    }

    public static String doAction(ActionType type, FileReader xml) throws IOException, HTTPException {
        String url = SERVICE_PATH+type.getPath();
        String strXml = "";
        int c;
        while ( (c = xml.read()) != -1 ) {
            strXml += (char)c;
        }

        System.out.println("["+type.getMethod().name()+"]"+url);
        return sendRequest(url,type.getMethod().name(),"application/xml",strXml);
    }

    public static String doAction(ActionType type, StringWriter xml) throws IOException, HTTPException {
        String url = SERVICE_PATH+type.getPath();
        String strXml = xml.toString();

        System.out.println("["+type.getMethod().name()+"]"+url);
        return sendRequest(url,type.getMethod().name(),"application/xml",strXml);
    }

    public static String doAction(ActionType type, String id, StringWriter xml) throws IOException, HTTPException {
        String url = SERVICE_PATH+type.getPath()+"/"+id;
        String strXml = xml.toString();

        System.out.println("["+type.getMethod().name()+"]"+url);
        return sendRequest(url,type.getMethod().name(),"application/xml",strXml);
    }

    /**
     * Methode de base permettant le requêtage
     * @param url URL de la requête
     * @param method GET/POST/PUT/DELETE ...
     * @return Contenu de la réponse
     * @throws IOException,HTTPException
     */
    private static String sendRequest(String url, String method) throws IOException, HTTPException {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        try {
            con.setRequestMethod(method);
            con.setDoInput(true);

            int responseCode = con.getResponseCode();
            System.out.println("Response Code : " + responseCode);
            if(responseCode == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                return response.toString();
            } else {
                throw new HTTPException(responseCode);
            }
        } finally {
            con.disconnect();
        }
    }

    /**
     * Methode de base permettant le requêtage
     * @param url URL de la requête
     * @param method GET/POST/PUT/DELETE ...
     * @return Contenu de la réponse
     * @throws IOException,HTTPException
     */
    private static String sendRequest(String url, String method, String contentType, String xml) throws IOException, HTTPException {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        try {
            con.setRequestMethod(method);

            con.setRequestProperty("Content-Type", contentType);

            con.setDoOutput(true);
            OutputStream output = new BufferedOutputStream(con.getOutputStream());
            output.write(xml.getBytes());
            output.flush();
            System.out.println(xml);

            int responseCode = con.getResponseCode();
            System.out.println("Response Code : " + responseCode);
            if (responseCode == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                return response.toString();
            } else {
                throw new HTTPException(responseCode);
            }
        } finally {
            con.disconnect();
        }
    }

    public static StringWriter marshal(Cvi cv) throws JAXBException {
        StringWriter stringWriter = new StringWriter();

        JAXBContext jaxbContext = JAXBContext.newInstance(Cvi.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);

        QName qName = new QName("http://univ.fr/cvi", "cvi");
        JAXBElement<Cvi> root = new JAXBElement<Cvi>(qName, Cvi.class, cv);

        jaxbMarshaller.marshal(root, stringWriter);

        return stringWriter;
    }

    public static String format(String xml, Boolean ommitXmlDeclaration) throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = db.parse(new InputSource(new StringReader(xml)));

        OutputFormat format = new OutputFormat(doc);
        format.setIndenting(true);
        format.setIndent(2);
        format.setOmitXMLDeclaration(ommitXmlDeclaration);
        format.setLineWidth(Integer.MAX_VALUE);
        Writer outxml = new StringWriter();
        XMLSerializer serializer = new XMLSerializer(outxml, format);
        serializer.serialize(doc);

        return outxml.toString();
    }

}
