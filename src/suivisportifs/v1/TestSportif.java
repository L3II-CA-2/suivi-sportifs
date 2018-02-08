package suivisportifs.v1;

public class TestSportif {

	public static void main(String[] args) {
		// TODO Stub de la méthode généré automatiquement
		
		Sportif sp1 = new Sportif();
		
		if(sp1.setPseudo("SebLoeb1") == false) {
			return;
		}
		
		if(sp1.setNom("Loeb") == false) {
			return;
		}
		
		if(sp1.setPrenom("Sebastien&") == false) {
			return;
		}
		
		sp1.setSport("Rallye");

		

	}

}
