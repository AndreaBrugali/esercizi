package threading;

public class MultiThreading03 {
	
	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
		Classe03 c1 = new Classe03();
		Classe03 c2 = new Classe03();
		Classe03 c3 = new Classe03();
		c1.messaggio = "classe 1";
		c2.messaggio = "classe 2";
		c3.messaggio = "classe 3";
		
		System.out.println("chiamo i metodi");
		// non posso più usare start su c1, c2 e c3 => perché non sono dei Thread, ma sono Runnable (lanciabili)
		// e dove li lancio?? => li lancio in un Thread
		Thread t1 = new Thread(c1);
		t1.start();
		
		new Thread(c2).start();
		new Thread(c3).start();
		
		System.out.println("finito di chiamare i metodi");
		System.out.println(System.currentTimeMillis());
	}

}
