import java.net.*;
import java.io.*;

/**
 * @author Morando Nicolò, morandonicolo@email.it, server.java
 */

public class server {  
    public static void main(String[] args){
        ServerSocket daytimeServer = null;
        try{
            daytimeServer = new ServerSocket(14);
            while(true){
                Socket clientSock = daytimeServer.accept();
                System.out.println("client connected");
                OutputStream os = clientSock.getOutputStream();
                PrintStream outputPS = new PrintStream(os);
                outputPS.println(new java.util.Date().toString() + "\r\n");
                clientSock.close();
            }
        }catch(UnknownHostException e){
            System.err.println("host unknown");
        }catch (Exception e){
            System.err.println(e);
        }

    }
}

