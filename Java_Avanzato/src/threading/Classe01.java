package threading;

public class Classe01 {
	
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
