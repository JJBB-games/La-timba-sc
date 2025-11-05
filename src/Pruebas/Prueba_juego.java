package Pruebas;

import Controladores.Controlador_juego;
import Controladores.Controlador_jugadores;
import Juego.Azar;

public class Prueba_juego {
	
	public static void main(String[] args) {
		
		Azar az = new Azar();
		Controlador_jugadores Cju = new Controlador_jugadores();
		
		Controlador_juego Cj = new Controlador_juego(Cju, az);
		
		
		Cj.primeraRonda();
		
		
		
	}
}
