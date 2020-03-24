package DAO_PERSONA;

public class Persona {
	private int id;
	private String nome;
	private String cognome;
	private float pesoInKg;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public float getPesoInKg() {
		return pesoInKg;
	}
	public void setPesoInKg(float pesoInKg) {
		this.pesoInKg = pesoInKg;
	}
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", pesoInKg=" + pesoInKg + "]";
	}
	
	
}
