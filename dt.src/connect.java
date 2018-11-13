import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author Morando Nicolò, morandonicolo@email.it, connect.java
 */

class connect extends Thread {
    Socket client;
    BufferedReader in;
    PrintWriter out;
    public connect(Socket client)
	{
            this.client = client;
            this.start();
	}
    
	public void run()
	{
            try
            {
                in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(client.getOutputStream())), true);
		System.out.println("address " + client.getInetAddress());
                in.close();
 		out.close();
                client.close();
		}
		catch(Exception e)
		{
                    e.printStackTrace();
		}
	}
}
