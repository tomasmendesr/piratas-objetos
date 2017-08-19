package pdep;

public abstract class Victima {
	/* En esta clase abstracta puedo DEFINIR metodos. Es decir
	 * que las clases que hereden de esta, van a entender esos métodos
	 * y van a poseer el comportamiento definido acá (en la super clase).
	 * A menos que RE-DEFINAN el método. En ese caso tendrán su propia implementación.
	 * 
	 * También se pueden DECLARAR métodos sin implementación, y las clases que hereden
	 * deberán obligatoriamente definir una implementación del mismo. Este caso
	 * es similar al funcionamiento de las interfaces.
	 */
	
	public abstract boolean puedeSerSaqueadaPor(Pirata unPirata);

	public abstract boolean esVulnerableA(Barco barco);

}
