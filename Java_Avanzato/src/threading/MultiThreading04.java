package threading;

public class MultiThreading04 {

	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
		Classe04 c1 = new Classe04();
		Classe04 c2 = new Classe04();
		Classe04 c3 = new Classe04();

		System.out.println("chiamo i metodi");
		// terzo approccio: utilizzo un'implementazione anonima e "in loco" di Runnable in cui decido
		// coda deve essere eseguido in un Thread
		// => siccome decido in loco, non ho più bisogno che la mia classe in cui c'è il metodo abbia delle
		// caratteristiche particolari

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				c1.metodo("classe 1");
				
			}
		});
		t1.start();
		
		// l'utilizzo di una anonymous inner implementaion di un'interfaccia, costituisce una struttura di programma
		// (o tecnica di programmazione) detta closure
		new Thread(new Runnable() {
			@Override
			public void run() {
				c2.metodo("classe 2");
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				c3.metodo("classe 3");
			}
		}).start();
		
		System.out.println("finito di chiamare i metodi");
		System.out.println(System.currentTimeMillis());
	}

}
