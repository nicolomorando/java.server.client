import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Morando Nicolò, morandonicolo@email.it, runnableDayTime.java
 */

public class runnableDayTime {

    public static void main(String[] args) throws IOException {
        try{
            Socket s = new Socket("localhost", 14);
            InputStream is = s.getInputStream();
            InputStreamReader ir = new InputStreamReader(is);
            BufferedReader r = new BufferedReader(ir);
            String line = r.readLine();
            System.out.println(line);
        }catch (UnknownHostException e){
            System.err.println("Host unknown");
        }catch (Exception e){
            System.err.println(e);
        }
    }
    
}
