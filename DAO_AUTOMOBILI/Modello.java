package DAO_AUTOMOBILI;

public class Modello {
	private int PKmodello;
	private String modello;
	public int getPKmodello() {
		return PKmodello;
	}
	public void setPKmodello(int pKmodello) {
		PKmodello = pKmodello;
	}
	public String getModello() {
		return modello;
	}
	public void setModello(String modello) {
		this.modello = modello;
	}
	@Override
	public String toString() {
		return "Modello [PKmodello=" + PKmodello + ", modello=" + modello + "]";
	}
	
	
}
