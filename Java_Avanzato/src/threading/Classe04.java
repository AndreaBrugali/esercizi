package threading;

public class Classe04 {
	
	// ritorno ad una normale classe
	// questa classe non deve più avere alcuna caratteristica specifica
	// che la renda eseguibile in un thread

	public void metodo(String msg) {
		System.out.println("chiamata al metodo => " + msg);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("finito il metodo => " + msg);
	}
}
