package networking;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class EmbrioneFileServerRemoto {
	
	static int esito = 0;

	// !! modificato per verifica funzionamento GIT
	public static void main(String[] args) {
		ServerSocket serverSocket;
		try {
			// mi metto in ascolto sulla porta 9000
			serverSocket = new ServerSocket(9000);
			System.out.println("Server in ascolto sulla porta 9000");

			// per ogni client accettiamo una cnx e fabbrichiamo un socket
			
			while (esito >= 0) {
				Socket socket = serverSocket.accept();
				new Thread(() -> {
					try {
						System.out.println("Un client si è connesso!");
	
						PrintWriter pw = new PrintWriter(socket.getOutputStream());
						BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	
						esito = dialogo(pw, br);
						System.out.println("Il client si è disconnesso");
	
						br.close();
						pw.close();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}).start();
			}

			System.out.println("Il server è stato chiuso");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// in prima battuta, sviluppiamo un eco
	public static int dialogo(PrintWriter pw, BufferedReader br) throws IOException {
		// il metodo dialogo termina con un nuomero
		// qusto numero lo voglio utilizzare per comandare il server
		// => se esco con un numero >= 0 => il server continua ad accettare nuovi client
		// => se esco con un numero < 0 => il server termina
		pw.println("Scrivi il nome del file che vuoi leggere):");
		pw.flush();

		String stringaLetta = null;	
		int count=0;
		do {
			
			stringaLetta = br.readLine();
			BufferedReader reader = new BufferedReader(new FileReader("C:\\AndreaBrugali\\"+stringaLetta));
			String line = reader.readLine();
			while(line!=null) {
				System.out.println(line);
				pw.println(line);
				pw.flush();
				line = reader.readLine();
			}
			reader.close();
			
			System.out.println("nome del file scelto => " + stringaLetta);

		} while (!stringaLetta.contentEquals("esci") && !stringaLetta.contentEquals("quit"));
		
		
		// stringaLetta.contentEquals("esci") => è true quando stringaLetta è uguale a
		// esci
		// il ! nega il valore di verità della condizione

		return (stringaLetta.contentEquals("quit") ? -1 : 0);
	}

}
