package DAO_AUTOMOBILI;

import java.util.ArrayList;
import java.util.Scanner;

public class MyMain {
	static private AutomobiliDao dao =new AutomobiliDao();
	static private MarcaDao mDao=new MarcaDao();
	static private ModelloDao moDao=new ModelloDao();
	static private Marca m=new Marca();
	static private Modello mod=new Modello();
	static private Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		int scelta=0;
		
		while(scelta!=999)
		{
			System.out.println("\n1)\t Visualizza auto\n2)\t Visualizza auto per id\n3)\t modifica auto\n4)\t inserisci nuova auto\n5)\t elimina auto\n6)\t visualizza Marche disponibili\n7)\t visualizza Marca per id\n8)\t modifica marca\n9)\t inserisci nuova marca\n10)\t elimina marca\n11)\t visualizza Modelli disponibili\n12)\t visualizza Modello per id\n13)\t modifica modello\n14)\t inserisci nuovo modello\n15)\t elimina modello\n999)\t esci");
			String scan=in.nextLine();
			scelta =Integer.parseInt(scan);
			
			switch(scelta)
			{
			case 1:
			{
				
				read(dao);
				break;
			}
			case 2:
			{
				//VISUALIZZO IL RECORD PER CHIAVE
				read(dao);
				System.out.println("\n"+"Per quale ID vuoi cercare?");
				String sca=in.nextLine();
				int id=Integer.parseInt(sca);
				Automobili a=dao.perChiave(id);
				
				if(controlla(a))
				{
					System.out.println(a);
				}else
				{
					System.out.println("codice non trovato !");
					break;
				}
				break;
			}
			case 3:
			{
				m=new Marca();
				mod=new Modello();
				
				read(dao);
				System.out.println("\n"+"Per quale ID vuoi modificare?");
				String sca =in.nextLine();
				int id=Integer.parseInt(sca);
				Automobili modAuto = dao.perChiave(id);
				if(controlla(modAuto))
				{
					if(input(modAuto)!=null)
					{
						dao.modifica(input(modAuto));
						System.out.println("Auto modificata");
					}
					else
					{
						break;
					}
				}else
				{
					System.out.println("Automobile inesistente, ciao");
					break;
				}
					break;
			}
			case 4:
			{
				m=new Marca();
				mod=new Modello();
				read(dao);
				//INSERISCO NUOVI RECORD
				Automobili newAuto = new Automobili();
				newAuto=input(newAuto);
				if(newAuto!=null)
				{
					dao.crea(newAuto);
					System.out.println("Auto inserita");
				}
				else
				{
					break;
				}
				
				break;
			}
			
			case 5:
			{
				read(dao);
				System.out.println("\n"+"Per quale ID vuoi eliminare?");
				String sca =in.nextLine();
				int id=Integer.parseInt(sca);
				Automobili delete = dao.perChiave(id);
				if(controlla(delete))
				{
					dao.cancella(id);
					System.out.println("auto cancellata");
					
				}else
				{
					System.out.println("Automobile inesistente, ciao");
					break;
				}
					break;
				
			}
			case 6:
			{
				read(mDao);
				break;
			}
			case 7:
			{
				read(mDao);
				System.out.println("per quale id vuoi cercare?");
				String idS=in.nextLine();
				int id=Integer.parseInt(idS);
				m=mDao.perChiave(id);
				if(controlla(m))
				{
					System.out.println(m);
				}
				else
				{
					System.out.println("Marca non disponibile, ciao");
					break;
				}
				break;
			}
			case 8:
			{
				read(mDao);
				System.out.println("per quale id vuoi modificare?");
				String idS=in.nextLine();
				int id=Integer.parseInt(idS);
				m=mDao.perChiave(id);
				if(controlla(m))
				{
					System.out.println("inserisci marca");
					String marca=in.nextLine();
					m.setMarca(marca);
					mDao.modifica(m);
					System.out.println("elemento modificato");
				}
				else
				{
					System.out.println("Marca non disponibile, ciao");
					break;
				}
				break;
			}
			case 9:
			{
				read(mDao);
				Marca newMarca = new Marca();
				System.out.println("inserisci marca");
				String marca=in.nextLine();
				newMarca.setMarca(marca);
				mDao.crea(newMarca);
				System.out.println("elemento inserito");
				break;
			}
			case 10:
			{
				read(mDao);
				System.out.println("per quale id vuoi cancellare?");
				String idS=in.nextLine();
				int id=Integer.parseInt(idS);
				m=mDao.perChiave(id);
				if(controlla(m))
				{
					mDao.cancella(id);
					System.out.println("elemento cancellato");
				}
				else
				{
					System.out.println("Marca non disponibile, ciao");
					break;
				}
				
				
				break;
			}
			case 11:
			{
				read(moDao);
				break;
			}
			case 12:
			{
				read(moDao);
				System.out.println("per quale id vuoi cercare?");
				String idS=in.nextLine();
				int id=Integer.parseInt(idS);
				mod=moDao.perChiave(id);
				if(controlla(mod))
				{
					System.out.println(mod);
				}
				else
				{
					System.out.println("Modello non disponibile, ciao");
					break;
				}
				break;
			}
			case 13:
			{
				read(moDao);
				System.out.println("per quale id vuoi modificare?");
				String idS=in.nextLine();
				int id=Integer.parseInt(idS);
				mod=moDao.perChiave(id);
				if(controlla(mod))
				{
					System.out.println("inserisci modello");
					String modello=in.nextLine();
					mod.setModello(modello);
					moDao.modifica(mod);
					System.out.println("elemento modificato");
				}
				else
				{
					System.out.println("Modello non disponibile, ciao");
					break;
				}
				break;
			}
			case 14:
			{
				read(moDao);
				Modello newModello = new Modello();
				System.out.println("inserisci modello");
				String modello=in.nextLine();
				newModello.setModello(modello);
				moDao.crea(newModello);
				System.out.println("elemento inserito");
				break;
			}
			case 15:
			{
				read(moDao);
				System.out.println("per quale id vuoi cancellare?");
				String idS=in.nextLine();
				int id=Integer.parseInt(idS);
				mod=moDao.perChiave(id);
				if(controlla(mod))
				{
					moDao.cancella(id);
					System.out.println("elemento cancellato");
				}
				else
				{
					System.out.println("Modello non disponibile, ciao");
					break;
				}
				
				
				break;
			}
			case 98:
			{
				
				//VISUALIZZA
				read(moDao);
				
				//VISUALIZZA PER CHIAVE
				System.out.println("\nVISUALIZZO PER CHIAVE 2\n"+moDao.perChiave(2));
				
				//MODIFICA
				mod=moDao.perChiave(3);
				mod.setModello("Clio");
				moDao.modifica(mod);
				System.out.println("\nELENCO MODIFICATO");
				read(moDao);
				
				//CREA
				Modello newModello = new Modello();
				newModello.setModello("Fiesta");
				moDao.crea(newModello);
				System.out.println("\nELENCO CON NUOVO ELEMENTO");
				read(moDao);
				
				//DELETE
				moDao.cancella(6);
				System.out.println("\nELENCO CON ELEMENTO CANCELLATO");
				read(moDao);
				break;

			}
			default:
			{
				if(scelta==999)
				{
					System.out.println("Arrivederci, grazie");
					break;
				}
				System.out.println("scegli un opzione disponibile");
				break;
			}
		}

		}
		in.close();
	}
	private static void read(AutomobiliDao dao)
	{
		ArrayList<String> arr=new ArrayList();
		//VISUALIZZO TUTTI I RECORD DELLA TABELLA auto
		for (Automobili p: dao.lista())
		{
			MarcaDao daoM =new MarcaDao();
			Marca m=daoM.lista(p.getFKmarca());
			ModelloDao daoMod=new ModelloDao();
			Modello mod=daoMod.lista(p.getFKmodello());

			arr.add("Automobili [PKauto=" + p.getPKauto() + ", marca=" + m.getMarca() + ", modello=" + mod.getModello() + ", cilindrata="
					+ p.getCilindrata() + ", data_imm=" + p.getData_imm() + ", n_posti=" + p.getN_posti() + "]");
		}

		for(String a :arr)
		{
			System.out.println(a);
		}
	}
	private static void read(MarcaDao mDao)
	{
		
		for(Marca m :mDao.lista())
		{
			System.out.println(m);
		}
	}
	private static void read(ModelloDao mDao)
	{
		
		for(Modello m :mDao.lista())
		{
			System.out.println(m);
		}
	}
	private static boolean controlla(Automobili check)
	{
		if(check==null)
		{
			return false;
		}
		else
		{
			return true;
		}
		
	}
	private static boolean controlla(Marca check)
	{
		if(check==null)
		{
			return false;
		}
		else
		{
			return true;
		}
		
	}
	private static boolean controlla(Modello check)
	{
		if(check==null)
		{
			return false;
		}
		else
		{
			return true;
		}
		
	}
	private static Automobili input(Automobili auto)
	{
		//Scanner in2=new Scanner(System.in);
		int idMarca=0;
		int idModello=0;
		System.out.println("Inserisci marca");
		String marcaS =in.nextLine();
		m= mDao.perChiave(marcaS);
		if(controlla(m))
		{
			idMarca=m.getPKmarca();
		}
		else
		{
			System.out.println("marca inesistente, ciao");
			return null;
		}
		System.out.println("Inserisci modello");
		String modelloS =in.nextLine();
		mod= moDao.perChiave(modelloS);
		if(controlla(mod))
		{
			idModello=mod.getPKmodello();
		}
		else
		{
			System.out.println("modello inesistente, ciao");
			return null;
		}
		
		System.out.println("Inserisci cilindrata");
		String cilindrataS =in.nextLine();
		float cil=Float.parseFloat(cilindrataS);
		
		System.out.println("Inserisci data immatricolazione");
		String data =in.nextLine();

		System.out.println("Inserisci n posti");
		String postiS =in.nextLine();
		int posti=Integer.parseInt(postiS);
		auto.setFKmarca(idMarca);
		auto.setFKmodello(idModello);
		auto.setCilindrata(cil);
		auto.setData_imm(data);
		auto.setN_posti(posti);
		
		return auto;
	}
}
