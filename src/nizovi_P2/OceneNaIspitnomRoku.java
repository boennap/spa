package nizovi_P2;

public class OceneNaIspitnomRoku {

	int[] ocene = new int[100];
	int brojac = 0; 
	
	void unosOcene(int ocena) {
		ocene[brojac] = ocena;
		brojac++;
	}
	
	void ispisOcena() {
		for(int i = 0; i < brojac; i++) {
			System.out.print(ocene[i] + " ");
		}
	}
	
}
