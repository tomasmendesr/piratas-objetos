package pdep;

public abstract class Victima {
	/* En esta clase abstracta puedo DEFINIR metodos. Es decir
	 * que las clases que hereden de esta, van a entender esos m�todos
	 * y van a poseer el comportamiento definido ac� (en la super clase).
	 * A menos que RE-DEFINAN el m�todo. En ese caso tendr�n su propia implementaci�n.
	 * 
	 * Tambi�n se pueden DECLARAR m�todos sin implementaci�n, y las clases que hereden
	 * deber�n obligatoriamente definir una implementaci�n del mismo. Este caso
	 * es similar al funcionamiento de las interfaces.
	 */
	
	public abstract boolean puedeSerSaqueadaPor(Pirata unPirata);

	public abstract boolean esVulnerableA(Barco barco);

}
