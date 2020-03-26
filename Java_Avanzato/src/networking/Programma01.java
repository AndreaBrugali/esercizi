package networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Programma01 {

	public static void main(String[] args) {
		ServerSocket serverSocket;
		try {
			// mi metto in ascolto sulla porta 9000
			serverSocket = new ServerSocket(9000);
			System.out.println("Server in ascolto sulla porta 9000");
			Socket socket = serverSocket.accept();
			
			// a questo punto è arrivata una connessione => posso usare il socket e i suoi stream
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			pw.println("ciao");
			
			pw.flush(); 
			// svouto il buffer di scrittura (altrimenti quello che c'è nel buffer non
			// raggiungerà la destinazione
			
			// buffered reader legge un input stream una "riga" alla volta
			// cioè aspetta che dall'altro capo dello stream venga digitato un INVIO
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String stringaLetta = br.readLine();
			
			System.out.println(stringaLetta);
			
			br.close();
			// indica all'OS che questo reader e lo stream ad esso associato non mi servono più
			pw.close();
			// indica all'OS che questo writer e lo stream ad esso associato non mi servono più
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
