package networking;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Chat_02 {

	static int esito = 0;
	static int stop = 0;
	static String path="C:\\AndreaBrugali\\chat.txt";
	static File file = new File(path);
	//static String nick;
	// !! modificato per verifica funzionamento GIT
	public static void main(String[] args) {
		ServerSocket serverSocket;
		try {
			// mi metto in ascolto sulla porta 9000
			serverSocket = new ServerSocket(9000);
			System.out.println("Server in ascolto sulla porta 9000");

			// per ogni client accettiamo una cnx e fabbrichiamo un socket
			file.createNewFile();
			FileWriter writer = new FileWriter(file);
			while (esito <= 0) {
				Socket socket = serverSocket.accept();
				new Thread(() -> {
					try {
						System.out.println("Un client si è connesso!");

						PrintWriter pw = new PrintWriter(socket.getOutputStream());
						BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

						esito = dialogo(pw, br,writer);

						System.out.println("Il client si è disconnesso");

						br.close();
						pw.close();
					} catch (IOException ex) {
						ex.printStackTrace();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}).start();
			}

			System.out.println("Il server è stato chiuso");
			stop=1;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// in prima battuta, sviluppiamo un eco
	public static int dialogo(PrintWriter pw, BufferedReader br,FileWriter writer) throws IOException, InterruptedException {
		// il metodo dialogo termina con un nuomero
		// qusto numero lo voglio utilizzare per comandare il server
		// => se esco con un numero >= 0 => il server continua ad accettare nuovi client
		// => se esco con un numero < 0 => il server termina
		int prima=0;
		String stringaLetta = null;	


		pw.println("Scrivi il tuo nickname:");
		pw.flush();
		String nick2=br.readLine();

		stringaLetta="nada";
		prima=1;

		int count=0;
		new Thread(() -> {
			try {
				leggi(pw,nick2);
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}).start();
		do {
			if(prima==0)
			{

			}
			else
			{
				pw.println("Scrivi messaggio (se si vuole inviare un messaggio privato, scrivi all'inizio => @destinatario:");
				pw.flush();
				stringaLetta = br.readLine();
				writer.write(nick2+": "+stringaLetta+"\n");
				writer.flush();
			}





		} while (!stringaLetta.contentEquals("esci") && !stringaLetta.contentEquals("quit"));

		writer.close();




		// stringaLetta.contentEquals("esci") => è true quando stringaLetta è uguale a
		// esci
		// il ! nega il valore di verità della condizione
		if(stringaLetta.contentEquals("quit"))
		{
			esito =1;
		}
		return (stringaLetta.contentEquals("quit") ? -1 : 0);
	}
	public static void leggi(PrintWriter pw,String nick) throws FileNotFoundException
	{

		BufferedReader reader = new BufferedReader(new FileReader("C:\\AndreaBrugali\\chat.txt"));
		String line;
		try {
			while(stop!=1)
			{
				line = reader.readLine();
				while(line!=null) {

					if(line.contains("@"+nick))
					{
						pw.println(line);
						pw.flush();
						System.out.println("siiiiiiiiiiiiiiii");
					}
					else if(line.contains("@"))
					{

					}
					else
					{
						pw.println(line);
						pw.flush();
						System.out.println("nooooooooooooooooooo");
					}
					line = reader.readLine();
				}

				
			}


			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}

}
