package pdep;

public class CiudadCostera extends Victima {
	
	// Atributos
	private Integer cantidadDeHabitantes;

	@Override
	public boolean puedeSerSaqueadaPor(Pirata unPirata) {
		return unPirata.getNivelDeEbriedad() > 50;
		// Se llama al "GETTER" del pirata para obtener el valor de su atributo "nivelDeEbriedad"
	}
	
	public void aumentarHabitantes(int i) {
		setCantidadDeHabitantes(cantidadDeHabitantes + i);
	}

	public Integer getCantidadDeHabitantes() {
		return cantidadDeHabitantes;
	}

	public void setCantidadDeHabitantes(Integer cantidadDeHabitantes) {
		this.cantidadDeHabitantes = cantidadDeHabitantes;
	}

	@Override
	public boolean esVulnerableA(Barco barco) {
		return tieneMenosHombresQue(barco) || barco.tieneTripulacionPasadDeGrog();
	}

	private boolean tieneMenosHombresQue(Barco barco) {
		return barco.cantidadDeTripulantes() > this.cantidadDeHabitantes * 0.4;
	}

}
