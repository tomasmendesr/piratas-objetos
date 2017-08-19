package pdep.misiones;

import pdep.Barco;
import pdep.Mision;
import pdep.Pirata;

public class BusquedaDelTesoro implements Mision{

	@Override
	public boolean leEsUtil(Pirata unPirata) {
		return unPirata.tieneAlgunItemUtil() || unPirata.noTieneMasDe5Monedas(); // || significa OR (Ó)
	}

	@Override
	public boolean puedeSerRealizadaPor(Barco barco) {
		return barco.tieneAlgunTripulanteConLlave();
	}

}
