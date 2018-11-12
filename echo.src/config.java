/**
 * @author Morando Nicolò, morandonicolo@email.it, config.java
 */
 
import java.net.Socket;
import java.io.*;

public class running implements Runnable
{
    private Socket client = null;
    private String clientIp = null;
    public running(Socket client) {
	this.client = client;
	clientIp = this.client.getInetAddress().getHostAddress();
	System.out.println("| " + clientIp + " |" +
            ": >> CONNESSIONE IN ENTRATA DA UTENTE INDEFINITO. <<");
	}
	public void run() {
            BufferedReader reader = null;
            Writer writer = null;
            try {
		reader = new BufferedReader(new InputStreamReader(this.client.getInputStream()));
		writer = new OutputStreamWriter(this.client.getOutputStream());
                while(true) {
                    String response = reader.readLine();
                    if(response == null ||
                        response.equalsIgnoreCase("quit"))
			break;
                    String output = "| " + clientIp + " |: " + response;
		    System.out.println(output);
                    writer.write(response + "\n");
                    writer.flush();
		}
		} catch(IOException ex) {
			// possibile disconnessione del nodo
			// ignoro
		}
		finally {
                    try {
                            reader.close();
                            writer.close();
                            this.client.close();
			} catch(IOException ex) {
                            ex.printStackTrace();
			}		
			System.out.println("| " + clientIp + " |" +
                            ": >> CONNESSIONE TERMINATA DA UTENTE INDEFINITO. <<");
		}
	}
}