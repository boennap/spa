package nizovi_P2;

public class NizBrojeva {

	int[] niz = new int[10];
	int brojac = 0;
	
	void dodajElement(int broj) {
		niz[brojac] = broj;
		brojac++;
	}
	
	void ispisiPrviElement() {
		System.out.println("Prvi element niza: " + niz[0]);
	}
	
	void ispisiDesetiElement() {
		System.out.println("Deseti element niza: " + niz[9]);
	}
	
	void ispisiElement(int indeks) {
		System.out.println("niz[" + indeks + "] = " + niz[indeks]);
	}
	
	void ispisiElemente() {
		for(int i = 0; i < brojac; i++) {
			System.out.println(niz[i]);
		}
	}
	
	int zbirElemenata() {
		int zbir = 0;
		
		for(int i = 0; i < brojac; i++){
			zbir = zbir + niz[i];
		}
		
		return zbir;
	}
	
	int proizvodElemenata() {
		int proizvod = 1;
		
		for(int i = 0; i < brojac; i++) {
			proizvod = proizvod * niz[i];
		}
		
		return proizvod;
	}
	
	int vratiMinimalni() {
		int minimalni = niz[0];
		
		for (int i = 1; i < brojac; i++) {
			if(niz[i] < minimalni) {
				minimalni = niz[i];
			}
		}
		
		return minimalni;
	}
	
	int vratiMaksimalni() {
		int maksimalni = niz[0];
		
		for(int i = 1; i < brojac; i++) {
			if(niz[i] > maksimalni) {
				maksimalni = niz[i];
			}
		}
		
		return maksimalni;
	}
	
	boolean postoji(int broj) {
		for(int i = 0; i < brojac; i++) {
			if(niz[i] == broj) {
				return true;
			}
		}
		
		return false;
	}
	
}
