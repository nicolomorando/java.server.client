/**
 * @author Morando Nicolò, morandonicolo@email.it, EchoClient.java
 */
 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient {
  public static void main(String[] args) throws Exception {
    String hostname = "127.0.0.1";

    Socket theSocket = new Socket(hostname, 14);
    BufferedReader networkIn = new BufferedReader(new InputStreamReader(theSocket.getInputStream()));
    BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(theSocket.getOutputStream());
    System.out.println(">> CONNESSO AL SERVER CON UTENTE INDEFINITO. <<");

    while (true) {
      String theLine = userIn.readLine();
      if (theLine.equals("."))
        break;
      out.println(theLine);
      out.flush();
      System.out.println(networkIn.readLine() + " >> MESSAGGIO SPEDITO. ");
    }
    networkIn.close();
    out.close();
  }
}