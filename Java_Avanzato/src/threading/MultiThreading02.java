package threading;

public class MultiThreading02 {
	
	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
		Classe02 c1 = new Classe02();
		Classe02 c2 = new Classe02();
		Classe02 c3 = new Classe02();
		c1.messaggio = "classe 1";
		c2.messaggio = "classe 2";
		c3.messaggio = "classe 3";
		
		System.out.println("chiamo i metodi");
		c1.start();
		c2.start();
		c3.start();
		System.out.println("finito di chiamare i metodi");
		System.out.println(System.currentTimeMillis());
	}

}
