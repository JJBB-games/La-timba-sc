package Juego;

import java.util.List;

public class Carta {
	
	private String palo;
	private String valor;
	public Carta(String palo, String valor) {
		
		this.palo = palo;
		this.valor = valor;
	}
	
	public String getNobre() {
		return valor + " de " + palo;
	}
	
	public String getValor() {
		return valor;
	}
	public String getPalo() {
		return palo;
	}

	public static boolean esFigura(Carta carta) {
		
		if ((carta.getValor() == "J")||(carta.getValor() == "K")||(carta.getValor() == "Q")||(carta.getValor() == "As"))
			return true;
		return false;
	}

	public static boolean esAlta(Carta carta) {
		if ((carta.getValor()== "9") || (carta.getValor()== "10"))
			return true;
		return false;
	}
}
