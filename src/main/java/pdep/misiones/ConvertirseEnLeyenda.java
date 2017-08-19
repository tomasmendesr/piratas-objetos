package pdep.misiones;

import pdep.Barco;
import pdep.Mision;
import pdep.Pirata;

public class ConvertirseEnLeyenda implements Mision {
	// Atributos
	private String itemObligatorio;
	
	@Override
	public boolean leEsUtil(Pirata unPirata) {
		return unPirata.tieneAlMenos10Items() 
				|| unPirata.tengoItem(itemObligatorio); // Le mando por parametro a la mision convertirsEnLeyenda
	}

	@Override
	public boolean puedeSerRealizadaPor(Barco barco) {
		return true;
	}
	
}
