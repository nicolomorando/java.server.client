/**
 * @author Morando Nicolò, morandonicolo@email.it, RunnableEchoServer.java
 */

import java.net.ServerSocket;
import java.net.Socket;
import java.net.InetAddress;
import java.io.*;
import echo.src.config;

public class RunnableEchoServer {
    public static void main(String[] argv) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(14);
        } catch(IOException ex){
            ex.printStackTrace();
            System.exit(-1);
        }
        System.out.println(">> SERVER AVVIATO. <<");
        while(true) {
	try {
            Socket client = server.accept();
            running running = new running(client);
            Thread worker = new Thread(running);
            worker.start();
	} catch(IOException ex)
	{
            ex.printStackTrace();
	}
    }}
}