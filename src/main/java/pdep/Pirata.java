package pdep;

import java.util.List;

public class Pirata {
	private List<String> items; // Los modelo como String porque no es necesario generar una clase con comportamiento.
	private Double nivelDeEbriedad; 
	private Double cantidadDeDinero;
	
	public boolean esUtilPara(Mision unaMision){
		return unaMision.leEsUtil(this); // Es responsabilidad de la mision saber si el pirata le es util.
	}

	public boolean tieneAlgunItemUtil() {
		return tengoItem("brujula") || tengoItem("mapa") || tengoItem("botella");
	}
	
	public boolean tengoItem(String item){
		return items.contains(item);
	}

	public boolean noTieneMasDe5Monedas() {
		return cantidadDeDinero < 5;
	}

	public boolean tieneAlMenos10Items() {
		return cantidadDeItems() > 10; // cantidadDeItems es un metodo que retorna un numero
	}
	
	public int cantidadDeItems(){
		return items.size();
	}

	public boolean cuentaConMenosMonedasQue(Double cantidadDeDinero) {
		return this.cantidadDeDinero < cantidadDeDinero;
		// En este caso es necesario poner "this." para referenciar al atributo de 
		// la clase. Ya que la variable que llega por parametro posee
		// el mismo nombre. Y si no agrego el "this", se hace referencia a la segunda.
	}

	public boolean seAnimaASaquearA(Victima victima) {
		return victima.puedeSerSaqueadaPor(this);
	}

	public boolean estaPasadoDeGrog() {
		return nivelDeEbriedad > 90;
	}
	
	public boolean puedeFormarParteDe(Barco unBarco){
		return unBarco.tieneLugar() && esUtilPara(unBarco.getMision());
	}
	
	public void tomarUnTrago() {
		setNivelDeEbriedad(nivelDeEbriedad + 5);
		setCantidadDeDinero(cantidadDeDinero - 1 );
	}
	
	
	// Getters y setters
	public Double getNivelDeEbriedad(){
		return this.nivelDeEbriedad;
	}
	
	public void setNivelDeEbriedad(Double valor){
		this.nivelDeEbriedad = valor;
	}
	
	public Double getCantidadDeDinero() {
		return cantidadDeDinero;
	}

	public void setCantidadDeDinero(Double cantidadDeDinero) {
		this.cantidadDeDinero = cantidadDeDinero;
	}

	
}
