package vers2_83;

import java.util.ArrayList;
import java.util.Scanner;

public class vers2_83 {

	static Scanner entrada = new Scanner(System.in);
	static ArrayList<Clientes2>llistaClients = new ArrayList<Clientes2>();

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int opcio;
		
		do {
		
			System.out.println("Introdueix l´opció desitjada: "
					+ "\n1. Crear Client"
					+ "\n2. Veure Client"
					+ "\n3. Eliminar Client"
					+ "\n4. Crear compte client"
					+ "\n5. Ingressar diners en compte"
					+ "\n6. Retirar diners del compte"
					+ "\n0. Sortir");
			
			opcio = entrada.nextInt();
			
				switch(opcio) {
				
					case 0:
						System.out.println("Adéu!");
						break;
					case 1:	crearClient();
						break;
					case 2:	veureCliente();
						break;
					case 3:	eliminarClient();
						break;
					case 4:	crearCompteClient();
						break;
					case 5: ingSaldo();
						break;
					case 6:	retSaldo();
						break;
					default:
						System.out.println("L´opció escollida no és válida; si us plau escolliu"
								+ " una opció válida, gràcies!");
						System.out.println("");
				}
			
		}while(opcio != 0);
	}
	
	public static void crearClient() {
		
		String nom;
		String cognom;
		int i = 0;
		boolean end = false;
		
		System.out.println("Introdueixi el nom del nou client: ");
		nom = entrada.next();
		System.out.println("Introdueixi el cognom del nou client: ");
		cognom = entrada.next();
		
		while(i < llistaClients.size() && !end) {
			Clientes2 cliTrovat = llistaClients.get(i);
			if(nom.equalsIgnoreCase(cliTrovat.getNom()) && 
					cognom.equalsIgnoreCase(cliTrovat.getCognom())){
				end = true;
			}i++;	
		}
		if(end) {
			System.out.println("El client ja es trova als nostres sistemes!");
			System.out.println("");
		}else {
			Clientes2 cliente0 = new Clientes2(nom,cognom);
			llistaClients.add(cliente0);
			
			System.out.println("Client introduit al sistema amb èxit!");
			System.out.println("");
		}
	}
	
	public static void veureCliente() {
		
		String nom;
		String cognom;
		boolean end = false;
		int posClient = -1;
		int i = 0;
	
		System.out.println("Introdueixi el nom del client a cercar: ");
		nom = entrada.next();
		System.out.println("Introdueixi el cognom del client a cercar :");
		cognom = entrada.next();
		
		while(i < llistaClients.size() && !end) {
			Clientes2 cliTrovat = llistaClients.get(i);
			if(nom.equalsIgnoreCase(cliTrovat.getNom()) && 
					cognom.equalsIgnoreCase(cliTrovat.getCognom())){
				posClient = i;
				end = true;
			}i++;	
		}
		
		if(end) {
			
			
			System.out.println(llistaClients.get(posClient).toString());
			System.out.println("");
			
			for(int k = 0; k < llistaClients.get(posClient).getLlistaComptes().size();k++) {
				System.out.println("Compte client:  " + llistaClients.get(posClient).getLlistaComptes().get(k).getNumCompte());
			}
			System.out.println("");
			
			
		}else {
				System.out.println("El client cercat no s´ha trovat!");
		}

		}
	
	public static void eliminarClient() {
		
		String nom;
		String cognom;
		boolean end = false;
		int posClient = -1;
		int i =0;
		String resposta;
		
		System.out.println("Introdueixi el nom del client a cercar: ");
		nom = entrada.next();
		System.out.println("Introdueixi el cognom del client a cercar :");
		cognom = entrada.next();
		
		while(i < llistaClients.size() && !end) {
			Clientes2 cliTrovat = llistaClients.get(i);
			if(nom.equalsIgnoreCase(cliTrovat.getNom()) && 
					cognom.equalsIgnoreCase(cliTrovat.getCognom())){
				posClient = i;
				end = true;
			}i++;	
		}
		
		if(end) {
			System.out.println(llistaClients.get(posClient).toString());
			System.out.println("");
			System.out.println("Vols eliminar definitivament aquest client? S/N: ");
			resposta = entrada.next();
			if(resposta.equalsIgnoreCase("s")) {
				llistaClients.remove(posClient);
				System.out.println("Eliminació executada amb èxit");
				System.out.println("");
			}else {
				System.out.println("Eliminació avortada!");
				System.out.println("");
			}
		}else {
				System.out.println("El client cercat no s´ha trovat!");
		}
		
	}
	
	public static void crearCompteClient() {
		
		String nom;
		String cognom;
		boolean end = false;
		int posClient = -1;
		int i = 0;
		int numCompte = (int)Math.round(Math.random()*1000);
		String resposta;
	
		System.out.println("Introdueixi el nom del client a cercar: ");
		nom = entrada.next();
		System.out.println("Introdueixi el cognom del client a cercar :");
		cognom = entrada.next();
		
		while(i < llistaClients.size() && !end) {
			Clientes2 cliTrovat = llistaClients.get(i);
			if(nom.equalsIgnoreCase(cliTrovat.getNom()) && 
					cognom.equalsIgnoreCase(cliTrovat.getCognom())){
				posClient = i;
				end = true;
			}i++;	
		}
		
		if(end) {
			
			System.out.println(llistaClients.get(posClient).toString());
			System.out.println("");
			System.out.println("Nombre de comptes del client. " + llistaClients.get(posClient).getLlistaComptes().size());
				
			for(int k = 0; k < llistaClients.get(posClient).getLlistaComptes().size();k++) {
				System.out.println("Compte client:  " + llistaClients.get(posClient).getLlistaComptes().get(k).getNumCompte());
			}
			System.out.println("");
			
			System.out.println("Vols crear un compte per aquest client: S/N");
			resposta = entrada.next();
			if(resposta.equalsIgnoreCase("s")) {
				
				Cuentas2 cuenta0 = new Cuentas2(numCompte,0);
				llistaClients.get(posClient).setLlistaComptes(cuenta0);
				System.out.println("S´ha creat el compte de client amb èxit!");
				System.out.println("Número de compte associat al client: " + cuenta0.getNumCompte());
				System.out.println("");
			}else {
				System.out.println("Creació de compte avortada");
				System.out.println("");
			}
				
		}else {
				System.out.println("El client cercat no s´ha trovat!");
				System.out.println("");
		}
		
	}
	
	public static void ingSaldo() {
		
		String nom;
		String cognom;
		int numCompte;
		boolean end = false;
		int posClient = -1;
		int i = 0;
		String resposta;
		int  j = 0;
		int posCompte = -1;
		float quantitat;
	
		System.out.println("Introdueixi el nom del client a cercar: ");
		nom = entrada.next();
		System.out.println("Introdueixi el cognom del client a cercar :");
		cognom = entrada.next();
		
		while(i < llistaClients.size() && !end) {
			Clientes2 cliTrovat = llistaClients.get(i);
			if(nom.equalsIgnoreCase(cliTrovat.getNom()) && 
					cognom.equalsIgnoreCase(cliTrovat.getCognom())){
				posClient = i;
				end = true;
			}i++;	
		}
		
		if(end) {
			
			
			System.out.println(llistaClients.get(posClient).toString());
			System.out.println("");
		
			System.out.println("Vols realitzar un ingres en compte: S/N");
			resposta = entrada.next();
			
			if(resposta.equalsIgnoreCase("s")) {
				
				System.out.println("Nombre de comptes del client: " + llistaClients.get(posClient).getLlistaComptes().size());
				
				for(int k = 0; k < llistaClients.get(posClient).getLlistaComptes().size();k++) {
					System.out.println("Compte client:  " + llistaClients.get(posClient).getLlistaComptes().get(k).getNumCompte());
				}
				System.out.println("");
				System.out.println("Introdueix el número de compte a ingressar diners: ");
				numCompte = entrada.nextInt();
				
				while(j < llistaClients.get(posClient).getLlistaComptes().size() && end) {
					Cuentas2 compteTrovada = llistaClients.get(posClient).getLlistaComptes().get(j);
					
					if(numCompte == compteTrovada.getNumCompte()) {
						posCompte = j;
						end = false;
					}	
				j++;	
				}
				if(!end) {
					
					
					System.out.println(llistaClients.get(posClient).getLlistaComptes().get(posCompte).toStrang());
					System.out.println("");
					System.out.println("Introdueix la quantitat a ingressar: ");
					quantitat = entrada.nextFloat();
					
					llistaClients.get(posClient).getLlistaComptes().get(posCompte).ingDiners(quantitat);
					System.out.println(llistaClients.get(posClient).getLlistaComptes().get(posCompte).tonewStrang());
					System.out.println("");
					
					
				}else {
					System.out.println("El numero de compte no es vàlid");
					System.out.println("");
				}
			}
					
		}else {
				System.out.println("El client cercat no s´ha trovat!");
		}
	}
	
	public static void retSaldo() {;
	
		String nom;
		String cognom;
		int numCompte;
		boolean end = false;
		int posClient = -1;
		int i = 0;
		String resposta;
		int  j = 0;
		int posCompte = -1;
		float quantitat;
	
		System.out.println("Introdueixi el nom del client a cercar: ");
		nom = entrada.next();
		System.out.println("Introdueixi el cognom del client a cercar :");
		cognom = entrada.next();
		
		while(i < llistaClients.size() && !end) {
			Clientes2 cliTrovat = llistaClients.get(i);
			if(nom.equalsIgnoreCase(cliTrovat.getNom()) && 
					cognom.equalsIgnoreCase(cliTrovat.getCognom())){
				posClient = i;
				end = true;
			}i++;	
		}
		
		if(end) {
			
			
			System.out.println(llistaClients.get(posClient).toString());
			System.out.println("");
			
			System.out.println("Vols realitzar una retirada de un compte: S/N");
			resposta = entrada.next();
			
			if(resposta.equalsIgnoreCase("s")) {
				
				System.out.println("Nombre de comptes del client. " + llistaClients.get(posClient).getLlistaComptes().size());
				
				for(int k = 0; k < llistaClients.get(posClient).getLlistaComptes().size();k++) {
					System.out.println("Compte client:  " + llistaClients.get(posClient).getLlistaComptes().get(k).getNumCompte());
				}
				System.out.println("");
				System.out.println("Introdueix el número de compte a retirar diners: ");
				numCompte = entrada.nextInt();
				
				while(j < llistaClients.get(posClient).getLlistaComptes().size() && end) {
					Cuentas2 compteTrovada = llistaClients.get(posClient).getLlistaComptes().get(j);
					
					if(numCompte == compteTrovada.getNumCompte()) {
						posCompte = j;
						end = false;
					}	
				j++;	
				}
				if(!end) {
					
					
					System.out.println(llistaClients.get(posClient).getLlistaComptes().get(posCompte).toStrang());
					System.out.println("");
					System.out.println("Introdueix la quantitat a retirar: ");
					quantitat = entrada.nextFloat();
					
					llistaClients.get(posClient).getLlistaComptes().get(posCompte).retDiners(quantitat);
					System.out.println(llistaClients.get(posClient).getLlistaComptes().get(posCompte).tonewStrang());
					System.out.println("");
					
					
				}else {
					System.out.println("El numero de compte no es vàlid");
					System.out.println("");
				}
			}
					
		}else {
				System.out.println("El client cercat no s´ha trovat!");
		
		}
	}
}
