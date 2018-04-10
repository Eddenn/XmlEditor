package app.util;

import app.panel.ActionType;

import javax.xml.ws.http.HTTPException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CvUtils {

    private static int PORT = 8080;
    private static String HOST_URL = "http://localhost";
    private static String SERVICE_PATH = "/restcvi";

    public static int getPort() {
        return PORT;
    }

    public static void setPort(int PORT) {
        CvUtils.PORT = PORT;
    }

    public static String getHostUrl() {
        return HOST_URL;
    }

    public static void setHostUrl(String hostUrl) throws MalformedURLException {
        new URL(hostUrl);
        HOST_URL = hostUrl;
    }

    public static String getServicePath() {
        return SERVICE_PATH;
    }

    public static void setServicePath(String servicePath) {
        SERVICE_PATH = servicePath;
    }

    public static String doAction(ActionType type) throws IOException, HTTPException {
        String url = HOST_URL+":"+PORT+SERVICE_PATH+type.getPath();
        System.out.println("["+type.getMethod().name()+"]"+url);
        return sendRequest(url,type.getMethod().name());
    }

    public static String doAction(ActionType type, String id) throws IOException, HTTPException {
        String url = HOST_URL+":"+PORT+SERVICE_PATH+type.getPath()+"/"+id;
        System.out.println("["+type.getMethod().name()+"]"+url);
        return sendRequest(url,type.getMethod().name());
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

        // optional default is GET
        con.setRequestMethod(method);

        //add request header
        //con.setRequestProperty("Accept", "application/xml");

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
    }

}
