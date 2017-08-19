package pdep;

public class Espia extends Pirata {
	
	// Hereda los atributos

	public boolean estaPasadoDeGrog(){
		// Redefino la implementacion de la super clase
		return false;
	}
	
	public boolean seAnimaASaquearA(Victima unaVictima){
		return unaVictima.puedeSerSaqueadaPor(this) && tienePermisoDeLaCorona();
	}

	private boolean tienePermisoDeLaCorona() {
		return tengoItem("permisoDeLaCorona");
	}
	
}
