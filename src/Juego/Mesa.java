package Juego;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mesa {
	
	private static int bote= 0;
	private static int Allin= 0;
	private static int boteAllin= 0;
	private static  List <Carta> cartasMesa = new ArrayList<>();;
	private Croupier cu;
	private static int apuesta = 0;
	private static boolean allIn = false;

	
	public Mesa (int bote, int Allin, int boteAllin, Croupier cu, int apuesta) {
		Mesa.bote = bote;
		this.boteAllin = boteAllin;
		this.Allin = Allin;
		this.cu = cu;
		this.apuesta = apuesta;
		
	}
	
	public static void subirApuesta(int i) {
		apuesta = i;
		
	}
	
	public static int getApuesta() {
		return apuesta;
	}
	
	public static int getBote() {
		return bote;
	}

	public static  List <Carta> getComunidad() {
		
		return cartasMesa;
	}

	public static void reiniciarApuesta() {
		bote = apuesta;
		apuesta = 0;
		
	}

	public static void finPartida() {
		bote = 0;
		cartasMesa.removeAll(cartasMesa);
	}

	public static void allIn(int a) {
		allIn = true;
		Allin= a;
		
	}
	
	
}
