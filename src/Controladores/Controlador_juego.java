package Controladores;

import Juego.Azar;
import Juego.Croupier;
import Juego.Mesa;
import Jugadores.Jugadores;

public class Controlador_juego {
	
	private Controlador_jugadores Cju;
	private Azar az;
	
	public Controlador_juego(Controlador_jugadores Cju, Azar az) {
		this.Cju = Cju;
		this.az = az;
	}
	
	public void primeraRonda() {
		Croupier Croupier = new Croupier(0);
		Cju.añadirJugadores();
		
		
		for (Jugadores jug : Cju.getLista()) {
			
			Juego.Croupier.repartir(jug.getMano());		
		}
		
		
		//Preflop
		Cju.accionPrimeraRonda();
		Cju.finRonda();
		
		//Flop
		if (Cju.getFinPartida()==false) {
		Juego.Croupier.comunidad(Mesa.getComunidad(),3);
		
		Cju.accionRonda();
		Cju.finRonda();
		}
		
		//no se
		if (Cju.getFinPartida()==false) {
		Juego.Croupier.comunidad(Mesa.getComunidad(),1);
		
		Cju.accionRonda();
		Cju.finRonda();
		}
		
		//river
		if (Cju.getFinPartida()==false) {
		Juego.Croupier.comunidad(Mesa.getComunidad(),1);
		}
		
		
		
	}
	
	public void rondaMedia() {
		
	}
	
	public void finPartida() {
		
	}

}
