package Controladores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Juego.Azar;
import Juego.Carta;
import Juego.Mesa;
import Jugadores.Jugadores;
import Jugadores.Personaje_1;
import Jugadores.Personaje_2;
import Jugadores.Personaje_3;
import Jugadores.Personaje_4;


public class Controlador_jugadores {
	
	private List<String> listaPersonajes;
	private List <Jugadores> listaJugadores;
	private boolean finPartida = false;
	
	public  Controlador_jugadores() {
		listaJugadores = new ArrayList<>();
		listaPersonajes = new ArrayList<>();
		listaPersonajes.add("Personaje 1");
		listaPersonajes.add("Personaje 2");
		listaPersonajes.add("Personaje 3");
		listaPersonajes.add("Personaje 4");


	}
	public List<Jugadores> getLista() {
		return listaJugadores;
	}
	
	public boolean getFinPartida() {
		return finPartida;
	}
	
	public void accionPrimeraRonda() {
		for(Jugadores jug : listaJugadores){
			
			
			System.out.print("\nComienza el turno de " + jug.getNombre() + "\n");
			jug.ciega(listaJugadores);
			
			List<Carta> a = jug.getMano();
			System.out.print(jug.getNombre()+" tiene en su mano un "+ a.getFirst().getNobre() + " y un " + a.getLast().getNobre() + "\n");
			
			jug.decision(jug.verMano(),1);
			
			
		}
		
		System.out.print("\n");
		
		while( condFinRonda() == false) {
			for(Jugadores jug : listaJugadores) {
				if(jug.getFold() == false)
					jug.decision(jug.verMano(),1);
			}
				
		}
	}
	
	
	
	public void accionRonda() {
	
		
		for (Jugadores jug : listaJugadores) {
			
			if(jug.getFold() == false && jug.getAllin()== false) {
				System.out.print("\nComienza el turno de " + jug.getNombre() + "\n");
				jug.decision(jug.verMesa(),2);
			}
			
			
		}
		
		
		while( condFinRonda() == false) {
			for(Jugadores jug : listaJugadores) {
				if(jug.getFold() == false && jug.getAllin()== false)
					jug.decision(jug.verMano(),2);
			}
				
		}
		
		
	}
	
	
	
	
	public void finPartida(Jugadores jug) {
		jug.ganador();
		Mesa.finPartida();
		quitarJugador();
		finPartida = true;
		
		System.out.print("El jugador"+ jug.getNombre() + "ha ganado la partida!!!!");
	}
	
	public boolean condFinRonda() {
		int i = 0;
		for(Jugadores jug : listaJugadores) {
			if ((jug.getFold() == true) ||(jug.getAllin() == true) || (jug.getApuesta()==Mesa.getApuesta()))
				i +=1;
		}
		
		if (i == listaJugadores.size())
			return true;
		return false;
	}
	
	public void añadirJugadores() {
		
		for(int i=0;i<4;i++) {
		Jugadores jug = null;
		String a = Azar.personaje(listaPersonajes);
		
		switch(a) {
			case "Personaje 1":
				jug = new Personaje_1(1000,"P1");
				break;
			case "Personaje 2":
				jug = new Personaje_1(1000,"P2");
				break;
			case "Personaje 3":
				jug = new Personaje_1(1000,"P3");
				break;
			case "Personaje 4":
				jug = new Personaje_1(1000,"P4");
				break;
		}
		
		listaJugadores.add(jug);
		}
		
	}
	
	public void quitarJugador() {
		
		List <Jugadores> listaArruinados = new ArrayList<>();
		
		for(Jugadores jug: listaJugadores) {
			if (jug.getFondo()<=0) {
				listaArruinados.add(jug);
				System.out.print("El jugador"+jug.getNombre()+"se ha arruinado \n");
			}
		}
		
		listaJugadores.removeAll(listaArruinados);
		
		
	}
	public void finRonda() {
		Mesa.reiniciarApuesta();
		int i=0;
		Jugadores a = null;
		for(Jugadores jug: listaJugadores) {
			jug.reiniciarApuesta();
			if(jug.getFold()==true)
				i++;
			else
				a = jug;
		}
		if (i == 3)
			finPartida(a);
		
	}
	
}
 