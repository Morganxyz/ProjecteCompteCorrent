package vers2_83;

import java.util.ArrayList;

public class Clientes2 {
	
	private String nom;
	private String cognom;
	ArrayList<Cuentas2>llistaComptes;
	
	public Clientes2(String nom,String cognom) {
		
		this.nom = nom;
		this.cognom = cognom;
		this.llistaComptes = new ArrayList<Cuentas2>();
		
	}
	
	public String getNom() {
		return this.nom;
	}
	public String getCognom() {
		return this.cognom;
	}
	
	public ArrayList<Cuentas2> getLlistaComptes(){
		return this.llistaComptes;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setCognom(String cognom) {
		this.cognom = cognom;
	}
	public void setLlistaComptes(Cuentas2 llistaComptes) {
		this.llistaComptes.add(llistaComptes);
	}
	
	public String toString() {
		return "El/La Client/a " + this.nom + " " + this.cognom + " pertany a la nostra entitat.";
	}
	
	
	
}
