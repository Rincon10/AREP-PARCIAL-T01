package edu.escuelaing.arep.server;


import edu.escuelaing.arep.services.impl.HttpConnectionService;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static edu.escuelaing.arep.utils.Constants.TYPES;

/**
 * @author Iván Camilo Rincón Saavedra
 * @version 1.0 2/23/2022
 * @project OpenWeather
 */
public class HttpServer {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private URI resourceURI;
    private String city;
    public static OutputStream outputStream;

    public final static Map<String, String> typesMap = new HashMap<String, String>();

    public HttpServer() {
        setTypes();
    }

    /**
     * Method that prepares all possible types of a file
     */
    private void setTypes() {
        for (String[] type : TYPES) {
            typesMap.put(type[0], type[1]);
        }
    }

    /**
     * Method that return the port number that gonna be used by the connection
     *
     * @return int, port number
     */
    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 35000;
    }

    public static String notFound() {
        return "HTTP/1.1 200 OK\r\n"
                + "Content-Type: text/html\r\n"
                + "\r\n"
                + "<!DOCTYPE html>"
                + "<html>"
                + "<head>"
                + "<meta charset=\"UTF-8\">"
                + "<title>Not found</title>\n"
                + "</head>"
                + "<body>"
                + "<div>"
                + "<h1>404 Error</h1>"
                + "</div>"
                + "<h2>Oops! This Page Could Not Be Found</h2>"
                + "<p>"
                + "Sorry but the page you are looking for does not exist or have been removed. name changed or is temporarily unavailable"
                + "</p>"
                + "</body>"
                + "</html>";
    }

    /**
     * Method that return a default html page
     *
     * @return String, that represents the html page
     */
    private String getDefaultHTML() {
        return "HTTP/1.1 200 OK\r\n"
                + "Content-Type: text/html\r\n"
                + "\r\n"
                + "<!DOCTYPE html>"
                + "<html>"
                + "<head>"
                + "<meta charset=\"UTF-8\">"
                + "<title>Default Page</title>\n"
                + "</head>"
                + "<body>"
                + "<h1>Default Page</h1>"
                + "</body>"
                + "</html>";
    }

    /**
     * Method that establish a connection with a specific socket client
     *
     * @param clientSocket, client socket with who gonna establish a connection
     * @throws IOException
     * @throws URISyntaxException
     */
    public void serverConnection(Socket clientSocket) throws IOException, URISyntaxException {
        this.clientSocket = clientSocket;
        try {
            serverConnection();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method that establish a connection between client and server
     *
     * @throws IOException
     * @throws URISyntaxException
     */
    public void serverConnection() throws IOException, URISyntaxException, InvocationTargetException, IllegalAccessException {
        outputStream = clientSocket.getOutputStream();
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(
                new InputStreamReader(
                        clientSocket.getInputStream()));
        String inputLine, outputLine;
        ArrayList<String> request = new ArrayList<>();

        while ((inputLine = in.readLine()) != null) {
            System.out.println("Received: " + inputLine);
            request.add(inputLine);
            if (!in.ready()) {
                break;
            }
        }

        // Example: 0= "GET /public/css/index.css HTPP/1.1"
        String file = request.get(0).split(" ")[1];
        resourceURI = new URI(file);
        if (file.startsWith("/Clima/")) {
            outputLine = outputLine = getDefaultHTML();
            ;
        } else if (file.startsWith("/Consulta")) {
            //this petition works only with the paramas lat and lon
            String[] petition = file.replace("/Consultas?", "").split("&");
            for (String value : petition) {
                String[] param = value.split("=");
                if (param[0].contains("q")) {
                    this.city = param[1];
                    break;
                }
            }
            outputLine = "HTTP/1.1 200 OK \r\n"
                    + "Content-Type: " + HttpServer.typesMap.get("json") + "\r\n"
                    + "\r\n"
                    + HttpConnectionService.startConnection(city);
        } else {
            outputLine = notFound();
        }
        out.println(outputLine);
    }

    /**
     * Method that close the connection between the client and the server
     *
     * @throws IOException
     */
    public void closeConnection() throws IOException {
        out.close();
        in.close();
        clientSocket.close();
    }

    /**
     * Method that start running the HttpServer
     *
     * @throws IOException
     */
    public void start() throws IOException, URISyntaxException {
        serverSocket = null;
        try {
            serverSocket = new ServerSocket(getPort());
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }

        boolean running = true;
        while (running) {
            clientSocket = null;

            System.out.println("Listo para recibir ...");
            clientSocket = serverSocket.accept();

            serverConnection(clientSocket);
            closeConnection();
        }
        serverSocket.close();
    }


}
