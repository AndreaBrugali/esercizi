package threading;

public class Classe03 implements Runnable {
	
	// seconda possibilità x multithreading => implementare Runnable
	// => implementare il metodo run() e metterci quello che voglio che venga fatto dal thread
	
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
