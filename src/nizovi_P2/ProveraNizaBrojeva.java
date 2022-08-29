package nizovi_P2;

public class ProveraNizaBrojeva {

	public static void main(String[] args) {
		NizBrojeva n1 = new NizBrojeva();
		NizBrojeva n2 = new NizBrojeva();
		
		n1.dodajElement(4);
		n1.dodajElement(7);
		n2.dodajElement(3);
		n2.dodajElement(5);
		n2.dodajElement(10);
		
		System.out.println(n1.zbirElemenata());
		System.out.println(n2.vratiMinimalni());
		
	}
	
	
	
}
