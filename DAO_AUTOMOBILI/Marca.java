package DAO_AUTOMOBILI;

public class Marca {
	private int PKmarca;
	private String marca;
	public int getPKmarca() {
		return PKmarca;
	}
	public void setPKmarca(int pKmarca) {
		PKmarca = pKmarca;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	@Override
	public String toString() {
		return "Marca [PKmarca=" + PKmarca + ", marca=" + marca + "]";
	}
	
	
}
