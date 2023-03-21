package vers2_83;

public class Cuentas2 {

	int numCompte;
	float saldo;
	
	public Cuentas2 (int numCompte,float saldo) {
		this.numCompte = numCompte;
		this.saldo = 0;
	}
	
	public int getNumCompte() {
		return this.numCompte;
	}
	public float getSaldo() {
		return this.saldo;
	}
	
	public void setNumCompte(int numCompte) {
		this.numCompte = numCompte;
	}
	public void setSaldo(float saldo) {
		this.saldo =saldo;
	}
	
	public String toStrang() {
		
		return "Número de compte: " + this.numCompte + " / Saldo " + this.saldo;
	}
	
	public String tonewStrang() {
		
		return "Número de compte: " + this.numCompte + " / Nou Saldo " + this.saldo;
	}
	
	public float ingDiners(float quantitat) {
		
		if(quantitat > 0) {
			setSaldo(this.saldo + quantitat);
		}else {
			System.out.println("La quantitat a ingressar no és vàlida");
		}
		
		return saldo;
	}
	
public float retDiners(float quantitat) {
		
		if(quantitat <= this.saldo) {
			setSaldo(this.saldo - quantitat);
		}else {
			System.out.println("La quantitat a retirar no és vàlida");
		}
		
		return saldo;
	
}
}
