package DAO_AUTOMOBILI;

import java.util.Date;

public class Automobili {
	private int PKauto;
	private int FKmarca;
	private int FKmodello;
	private float cilindrata;
	private String data_imm;
	private int n_posti;
	public int getPKauto() {
		return PKauto;
	}
	public void setPKauto(int pKauto) {
		PKauto = pKauto;
	}
	public int getFKmarca() {
		return FKmarca;
	}
	public void setFKmarca(int fKmarca) {
		FKmarca = fKmarca;
	}
	public int getFKmodello() {
		return FKmodello;
	}
	public void setFKmodello(int fKmodello) {
		FKmodello = fKmodello;
	}
	public float getCilindrata() {
		return cilindrata;
	}
	public void setCilindrata(float cilindrata) {
		this.cilindrata = cilindrata;
	}
	public String getData_imm() {
		return data_imm;
	}
	public void setData_imm(String data_imm) {
		this.data_imm = data_imm;
	}
	public int getN_posti() {
		return n_posti;
	}
	public void setN_posti(int n_posti) {
		this.n_posti = n_posti;
	}
	
	@Override
	public String toString() {
		return "Automobili [PKauto=" + PKauto + ", FKmarca=" + FKmarca + ", FKmodello=" + FKmodello + ", cilindrata="
				+ cilindrata + ", data_imm=" + data_imm + ", n_posti=" + n_posti + "]";
	}
	
	
	
}
