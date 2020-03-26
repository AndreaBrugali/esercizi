package threading;

public class MultiThreading05 {

	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
		Classe04 c1 = new Classe04();
		Classe04 c2 = new Classe04();
		Classe04 c3 = new Classe04();

		System.out.println("chiamo i metodi");
		// quarto approccio:l'implementazione anonima e "in loco" viene "sintentizzata" usando una
		// nuova sintassi di Java 8 => la lambda expression
		// come è ottenuto tutto ciò?
		// 1. uso l'inferenza di tipo del compilatore
		//   1.1 posso omettere il nome dell'interfaccia
		//	 1.2 posso omettere la dichiarazione dell'unico metodo che c'era nell'interfaccia
		
		// le espressioni lambda si posso applicare solo a interfacce che hanno UN SOLO METODO
		// queste interfacce vengono dette interfacce funzionali (e sono di solito annotate
		// con l'annotazione @FunctionalInterface)
		Thread t1 = new Thread(() -> c1.metodo("classe 1"));
		t1.start();
		
		// l'utilizzo di una anonymous inner implementaion di un'interfaccia, costituisce una struttura di programma
		// (o tecnica di programmazione) detta closure
		new Thread(() -> c2.metodo("classe 2")).start();
		new Thread(() -> c3.metodo("classe 3")).start();
		
		System.out.println("finito di chiamare i metodi");
		System.out.println(System.currentTimeMillis());
	}

}
