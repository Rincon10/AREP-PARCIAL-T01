package edu.escuelaing.arep;

import edu.escuelaing.arep.server.HttpServer;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        try {
            new HttpServer().start();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
