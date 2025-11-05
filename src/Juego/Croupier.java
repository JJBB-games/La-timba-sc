package Juego;

import java.util.ArrayList;
import java.util.List;

import Jugadores.Jugadores;

public class  Croupier {
	
	private static List <Carta> baraja;
	private int donaciones;
	
	public Croupier(int donaciones){
		this.donaciones = donaciones;
		baraja = new ArrayList<>();
		 String[] palos = {"Corazones", "Diamantes", "Picas", "Tréboles"};
	     String[] valores = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "As"};
	     
	     for (String palo : palos) {
	            for (String valor : valores) {
	                baraja.add(new Carta(palo,valor));
	            }
	        }
		
		
	}
	
	
	public static void repartir(List<Carta> Mano) {
		
		for (int i = 0;i<2;i++){
		int a = Azar.repartir(baraja.size());
		Carta e = baraja.get(a);
		baraja.remove(a);
		Mano.add(e);
		}
		
		
		
		
	}
	
	public static void comunidad(List<Carta> cartasMesa, int i) {
		String z = "";
		for (int x = 0; x < i ;x++) {
			int a = Azar.repartir(baraja.size());
			Carta e = baraja.get(a);
			baraja.remove(a);
			cartasMesa.add(e);
			
			z += e.getNobre() + " ,";
		}
		
		System.out.print("El croupier saca a la mesa las cartas " + z +"\n\n");
	}
}
