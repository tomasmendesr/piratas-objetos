package pdep.misiones;

import pdep.Barco;
import pdep.Mision;
import pdep.Pirata;
import pdep.Victima;

public class Saqueo implements Mision {
	private Double cantidadDeMonedas;
	private Victima victima;
	
	@Override
	public boolean leEsUtil(Pirata unPirata) {
		return unPirata.cuentaConMenosMonedasQue(cantidadDeMonedas) 
				|| unPirata.seAnimaASaquearA(victima);
	}

	@Override
	public boolean puedeSerRealizadaPor(Barco barco) {
		return barco.tieneComoVictimaVulnerableA(victima);
	}
}
