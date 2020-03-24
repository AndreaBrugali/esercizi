package DAO_PERSONA;

public class MyMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonaDao dao =new PersonaDao();
		
		//VISUALIZZO TUTTI I RECORD DELLA TABELLA persona
		for (Persona p: dao.lista())
		{
			System.out.println(p);
		}
		
		//VISUALIZZO IL RECORD PER CHIAVE
		System.out.println();
		System.out.println("VISUALIZZO IL RECORD PER CHIAVE 3");
		System.out.println(dao.perChiave(3));
		
		//MODIFICO IL RECORD PER CHIAVE
		Persona modPersona = dao.perChiave(5);
		modPersona.setNome("Brenda");
		modPersona.setCognome("Cano");
		dao.modifica(modPersona);
		System.out.println();
		System.out.println("MODIFICO IL RECORD PER CHIAVE 5");
		for (Persona p: dao.lista())
		{
			System.out.println(p);
		}
		
		//INSERISCO NUOVI RECORD
		
		Persona newPersona = new Persona();
		newPersona.setNome("Mounir");
		newPersona.setCognome("El Omri");
		newPersona.setPesoInKg(65);
		dao.crea(newPersona);
		
		System.out.println();
		System.out.println("ELENCO CON RECORD APPENA INSERITI");
		for (Persona p: dao.lista())
		{
			System.out.println(p);
		}
		
		//CANCELLO RECORD
		dao.cancella(7);
		System.out.println();
		System.out.println("ELENCO CON RECORD CHIAVE 7 CANCELLATO");
		for (Persona p: dao.lista())
		{
			System.out.println(p);
		}
	}

}
