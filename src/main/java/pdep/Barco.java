package pdep;

import java.util.Comparator;
import java.util.List;

public class Barco extends Victima {
	// Atributos
	private List<Pirata> tripulacion;
	private Mision mision;
	private Integer cantidadMaximaDeTripulantes;
	
	public boolean tieneLugar() {
		return cantidadDeTripulantes() * 0.9 < cantidadMaximaDeTripulantes;
	}

	public double cantidadDeTripulantes() {
		return tripulacion.size();
	}
	
	public void incorporarA(Pirata unPirata){
		if(sePuedeIntegrarA(unPirata)){
			tripulacion.add(unPirata);
		}
		else{
			throw new RuntimeException("El pirata no puede ser incorporado");
		}
	}
	
	public boolean sePuedeIntegrarA(Pirata unPirata) {
		return unPirata.puedeFormarParteDe(this);
	}
	
	public void cambiarDeMisionA(Mision misionNueva){
		setMision(misionNueva);
		echarTripulantesInutilesPara(misionNueva);
	}
	
	public void echarTripulantesInutilesPara(Mision misionNueva) {
		tripulacion.forEach(pirata -> { // Recorro la lista de piratas uno por uno
			if(!pirata.esUtilPara(misionNueva)){ // El "!" niega la sentencia. Entonces se lee "si no es util para..."
				tripulacion.remove(pirata);
			}
		});
	}
	
	public Pirata obtenerTripulanteMasEbrio(){
		/* Para obtener el pirata con mayor nivel de ebriedad
		 * se debe definir un "Comparator" (utilidad de Java)
		 * donde se indique por cual atributo se debe comparar.
		 */
        Comparator<Pirata> comparator = Comparator.comparing(Pirata::getNivelDeEbriedad);
		return tripulacion.stream()
				.max(comparator)
				.get();
	}
	
	public void anclateEn(CiudadCostera unaCiudad){
		tripulacionSeTomaUnTrago();
		sePierdeElMasEbrioEn(unaCiudad); 
	}
	
	public void sePierdeElMasEbrioEn(CiudadCostera unaCiudad){
		tripulacion.remove(obtenerTripulanteMasEbrio());
		unaCiudad.aumentarHabitantes(1);
	}

	public void tripulacionSeTomaUnTrago() {
		tripulacion.forEach(pirata -> pirata.tomarUnTrago());
	}
	
	public boolean esTemible(){
		return puedeRealizar(this.mision); // No hace falta poner el "this".
	}
	
	public boolean puedeRealizar(Mision unaMision){
		return unaMision.puedeSerRealizadaPor(this);
	}

	public boolean tieneAlgunTripulanteConLlave() {
		return tripulacion.stream()
				.anyMatch(pirata -> pirata.tengoItem("llave"));
	}

	public boolean tieneComoVictimaVulnerableA(Victima victima) {
		return victima.esVulnerableA(this);
	}
	
	// Getters y Setters
	public Mision getMision() {
		return mision;
	}
	public void setMision(Mision mision) {
		this.mision = mision;
	}

	@Override
	public boolean puedeSerSaqueadaPor(Pirata unPirata) {
		return unPirata.estaPasadoDeGrog();
	}

	@Override
	public boolean esVulnerableA(Barco otroBarco) {
		return tieneMitadDeTripulantesQue(otroBarco);
	}
	
	public boolean tieneMitadDeTripulantesQue(Barco otroBarco){
		return cantidadDeTripulantes() < (otroBarco.cantidadDeTripulantes() / 2);
	}

	public boolean tieneTripulacionPasadDeGrog() {
		return tripulacion.stream().allMatch(pirata -> pirata.estaPasadoDeGrog());
	}
}
