package pdep;

public interface Mision {
	/* En la interface solo declaro metodos 
	* que deben ser definidos por la clase que implemente
	* la interfaz 
	*/
	
	boolean leEsUtil(Pirata unPirata);

	boolean puedeSerRealizadaPor(Barco barco);

}
