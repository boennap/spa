package js_liste;

public class JSLista {
	
	Cvor prvi;
	
	// neparametarski konstruktor
	public JSLista() {}
	
	// parametarski konstruktor
	public JSLista(int... niz) {
		
		for(int i = 0; i < niz.length; i++) {
			ubaciNaKraj(niz[i]);
		}

	}

	// ispisivanje svih elemenata liste
	void ispisi(){
		
		if(prvi == null) {
			System.out.println("\nLista je prazna");
			return;
		}
		
		Cvor pom = prvi;
		System.out.print("\nLista: ");
		
		while(pom != null) {
			System.out.print(pom.podatak + " ");
			pom = pom.sledeci;
		}
		
	}

	// ubacivanje elementa na pocetak liste
	void ubaciNaPocetak(int noviPodatak) {
	
		Cvor noviCvor = new Cvor();
		noviCvor.podatak = noviPodatak;
		noviCvor.sledeci = prvi;
		prvi = noviCvor;
	}
	
	// ubacivanje elementa na kraj liste
	void ubaciNaKraj(int noviPodatak) {
		
		Cvor noviCvor = new Cvor();
		noviCvor.podatak = noviPodatak;
		
		if(prvi == null) {
			prvi = noviCvor;
			return;
		}
		
		Cvor pom = prvi;
		
		while(pom.sledeci != null) {
			pom = pom.sledeci;
		}
		
		pom.sledeci = noviCvor;
	}

	// izbacivanje elementa sa pocetka liste
	int izbaciSaPocetka() {
		
		if(prvi == null) {
			throw new RuntimeException("Greška: Lista je prazna");
		}
		
		int izbacenPodatak = prvi.podatak;
		
		prvi = prvi.sledeci;
		
		return izbacenPodatak;
		
	}
	
	// izbacivanje elementa sa kraja liste
	int izbaciSaKraja() {
		
		int izbacenPodatak;
		
		if(prvi == null) {
			throw new RuntimeException("Greška: Lista je prazna");
		}
		
		if(prvi.sledeci == null) {
			izbacenPodatak = prvi.podatak;
			prvi = null;
			return izbacenPodatak;
		}
		
		Cvor pom = prvi;
		
		while (pom.sledeci.sledeci != null) {
			pom = pom.sledeci;
		}
		
		izbacenPodatak = pom.sledeci.podatak;
		pom.sledeci = null;
		
		return izbacenPodatak;
	}
	
	// prebrojavanje elemenata u listi
	int brojElemenata() {
		Cvor pom = prvi;
		int brojac = 0;
	
		while(pom != null) {
			brojac++;
			pom = pom.sledeci;
		}
		
		System.out.println("Broj elemenata u listi: " + brojac);
		
		return brojac;
	}

	// vrati element iz liste sa odredjenog indeksa (ponovo predji) // get
	int vratiElement(int indeks) {
		
		if(prvi == null) {
			throw new RuntimeException("Greška: Lista je prazna");
		}

		if(indeks < 0 || indeks >= brojElemenata()) {
			throw new RuntimeException("Greška: Izabran je nepostojeći indeks");
		}
		
		Cvor pom = prvi;
		
		for(int i = 0; i < indeks; i++) {
			pom = pom.sledeci;
		}
		
		System.out.println("Indeks: " + indeks + ", vrednost podatka: " + pom.podatak);
		
		return pom.podatak;
	}

	// upisivanje određene vrednosti na dati indeks - ne cuva se stara vrednost // set
	void upisiVrednostNaIndeks(int vrednost, int indeks) {
		if(prvi == null) {
			throw new RuntimeException("Greška: Lista je prazna");
		}
		
		if(indeks < 0 || indeks >= brojElemenata()) {
			throw new RuntimeException("Greška: Izabran je nepostojeći indeks");
		}
		
		Cvor pom = prvi;
		
		for(int i = 0; i < indeks; i++) {
			pom = pom.sledeci;
		}
		
		pom.podatak = vrednost;
	}

	// provera da li u listi postoji odredjen broj (nacin 1)
	boolean sadrziVrednost1(int vrednost) {

		for(int i = 0; i < brojElemenata(); i++) {
			if(vratiElement(i) == vrednost) {
				System.out.println("Postoji");
				return true;
			}
		}
		
		System.out.println("Ne postoji");
		return false;
	}

	// provera da li u listi postoji odredjen broj (nacin 2)
	boolean sadrziVrednost2(int vrednost) {
		
		Cvor pom = prvi;
		
		while(pom != null) {
			if(pom.podatak == vrednost) {
				return true;
			}
			pom = pom.sledeci;
		}
		
		return false;
	}

	// dodavanje novog elementa na odredjeni indeks - stara vrednost prelazi na naredni indeks
	void ubaciNoviNaIndeks(int vrednost, int indeks) {
		Cvor noviCvor = new Cvor();
		Cvor pom = prvi;
		
		if(indeks < 0 || indeks >= brojElemenata()) {
			throw new RuntimeException("Greška: Izabran je nepostojeći indeks");
		}
		
		if(indeks == 0) {
			ubaciNaPocetak(vrednost);
			return;
		}
		
		for(int i = 0; i < indeks-1; i++) {
			pom = pom.sledeci;
		}
		
		noviCvor.podatak = vrednost;
		noviCvor.sledeci = pom.sledeci;
		pom.sledeci = noviCvor;
	}

	// izbacivanje elementa sa određenog indeksa
	int izbaciElementSaIndeksa(int indeks) {
		
		if(indeks < 0 || indeks >= brojElemenata()) {
			throw new RuntimeException("Greška: Izabran je nepostojeći indeks");
		}
		
		if(indeks == 0) {
			int izbacenaVrednost = prvi.podatak;
			izbaciSaPocetka();
			return izbacenaVrednost;
		}
		
		Cvor pom = prvi;
		
		for(int i = 0; i < indeks - 1; i++) {
			pom = pom.sledeci;
		}
		
		pom.sledeci = pom.sledeci.sledeci;
		
		int izbacenaVrednost = pom.podatak;
		
		
		return izbacenaVrednost;
	}

	// selection sort liste (ponovo predji)
	void selectionSort() {
		Cvor pom1 = prvi;
		Cvor pom2 = prvi.sledeci;
		
		while(pom1.sledeci != null) {
			while(pom2 != null) {
				
				if(pom1.podatak > pom2.podatak) {
					int temp = pom1.podatak;
					pom1.podatak = pom2.podatak;
					pom2.podatak = temp;
				}
				
				pom2 = pom2.sledeci;
			}
			
			pom1 = pom1.sledeci;
			pom2 = pom1.sledeci;
		}
		
		
		
		
	}

	// 17 i 18 klip
}
