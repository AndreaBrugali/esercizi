package threading;

public class Classe02 extends Thread {
	
	// prima possibilità x multithreading => estendere Thread
	// => implementare (fare l'override) il metodo run() e metterci quello che voglio che venga fatto dal thread
	
	public String messaggio;
	
	public void metodo(String msg) {
		System.out.println("chiamata al metodo => " + msg);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("finito il metodo => " + msg);
	}

	@Override
	public void run() {
		metodo(this.messaggio);
	}
	
	

}
