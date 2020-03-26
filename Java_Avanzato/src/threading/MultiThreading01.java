package threading;

public class MultiThreading01 {

	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
		Classe01 c1 = new Classe01();
		Classe01 c2 = new Classe01();
		Classe01 c3 = new Classe01();
		
		System.out.println("chiamo i metodi");
		c1.metodo("classe 1");
		c2.metodo("classe 2");
		c3.metodo("classe 3");
		System.out.println("finito di chiamare i metodi");
		System.out.println(System.currentTimeMillis());
	}


}
