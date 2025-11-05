package Jugadores;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Juego.Azar;
import Juego.Carta;
import Juego.Mesa;

public abstract class Jugadores {
	
	private List  <Carta> Mano;
	private int fondo;
	private String nombre;
	private boolean fold = false;
	private int apuesta = 0;
	private  boolean allIn = false;
	
	public Jugadores(int fondo, String nombre) {
		Mano = new ArrayList<>(); 
		this.fondo = fondo;
		this.nombre = nombre;
		this.fold = fold;
		this.apuesta = apuesta;
	}
	
	public int getFondo() {
		return fondo;
	}
	
	public String getNombre() {
		return nombre;
	}
	public List<Carta> getMano() {
		return Mano;
	}
	public int getApuesta() {
		return apuesta;
	}
	
	public boolean getFold() {
		return fold;
	}
	
	public boolean getAllin() {
		return allIn;
	}
	
	public void ciega(List<Jugadores> listaJugadores) {
		if (listaJugadores.get(0) == this) {
			fondo -= 50;
			apuesta +=50;
			Mesa.subirApuesta(50);
			System.out.print("El jugador " + getNombre() + " paga la ciega grande y se queda con " + getFondo() + "\n");
		}
		else if(listaJugadores.get(1) == this) {
			fondo -= 25;
			apuesta +=25;
			Mesa.subirApuesta(25);
			System.out.print("El jugador " + getNombre() + " paga la ciega pequeña y se queda con " + getFondo() + "\n");
		}
	}
	
	public int verMano() {
		
		int pts = 0;
		
		for (Carta a : Mano) {
			if ( Carta.esFigura(a) == true)
				pts +=10;
			if ( Carta.esAlta(a) == true)
				pts +=5;
		}
		
		if (Mano.getFirst().getValor() == Mano.getLast().getValor())
			pts +=15;
		
		if (Mano.getFirst().getPalo() == Mano.getLast().getPalo())
			pts +=15;
		
		return pts;
	}
	
	public void verApuesta() {
		int a = Mesa.getApuesta();
		
		a -=  apuesta ;
		
		if (fondo <= a) {
			allIn();
			return;
		}
		
		fondo -= a;
		apuesta += a;
			
			
		System.out.print("El jugador " + getNombre() + " paga la  apuesta de "+ a +" y se queda con " + getFondo() + "\n\n");
		
	}
	
	public void subirApuesta(int pts) {
		int a = Azar.Apuesta(pts, 1);
		int i = 0;
		int z = 0;
		switch(a) {
		
		case 2:
			i = 200;
			break;
		case 1: 
			i = 100;
			break;
		case 0:
			i = 50;
			break;
		}
		
		i += Mesa.getApuesta();
		Mesa.subirApuesta(i);
		i -= apuesta;
		
		if( fondo <= i) {
			allIn();
			return;
		}
		
		fondo -= i;
		apuesta = Mesa.getApuesta();
		System.out.print("El jugador " + getNombre() + " sube la apuesta a "+ apuesta +" y se queda con " + getFondo() + "\n\n");
		
		
	}
	
	public void foldeo() {
		fold = true;
		System.out.print("El jugador " + getNombre() + " ha foldeado  \n \n");
	}
	
	public void donar() {
		
	}
	
	public void allIn() {
		int a = fondo;
		apuesta += a;
		Mesa.subirApuesta(apuesta);
		fondo = 0;
		System.out.print("El jugador " + getNombre() + " ha hecho un all in de " + getApuesta() + "\n\n");
		modoAllin();
		Mesa.allIn(apuesta);
		
	}
	
	public  void modoAllin() {
		allIn = true;
	}
	
	public void decision(int pts, int i) {
		
		int a = 0;
		
		a= (int) Azar.Apuesta(pts, i);
		
		if(fondo<=0)
			a = 0;
		switch(a) {
		case 3:
			allIn();
			break;
		case 2:
			subirApuesta(pts);
			break;
		case 1: 
			verApuesta();
			break;
		case 0:
			foldeo();
			break;}
		}
		
	

	public int verMesa() {
		List<Carta> a = Mesa.getComunidad();
		ArrayList<Integer> escalera = new ArrayList<>();
		List<Integer> escaleraReal = Arrays.asList(1,10, 11, 12, 13);
		int pts = 0;
		int n = 0;
		int h = 0;
		int p = 0;
		int c = 0;
		int d = 0;
		int t = 0;
		int pareja = 0;
		int mono = 0;
		a.addAll(Mano);
		
		for (Carta z : a) {
			if ( Carta.esFigura(z) == true)
				pts +=5;
			if ( Carta.esAlta(z) == true)
				pts +=2;
			
			
			switch(z.getPalo()) {
			case "Corazones" : 
				c++;
				break;
			case "Diamantes" : 
				d++;
				break;
			case "Picas" : 
				p++;
				break;
			case "Tréboles" : 
				t++;
				break;
			}
			
			switch(z.getValor()) {
			case "As" : 
				escalera.add(1);
				break;
			case "K" : 
				escalera.add(13);
				break;
			case "Q" : 
				escalera.add(12);
				break;
			case "J" : 
				escalera.add(11);
				break;
			default:
				escalera.add(Integer.parseInt(z.getValor()));
			}
		
		}
		
		escalera.sort(null);
		
		for(int i = 0; i < escalera.size() - 1; i++) {
			 
			if (i>0) {
				if (escalera.get(i)== mono-1)
					h++;
				else if (escalera.get(i) == mono-2)
					n++;
				else if(escalera.get(i) == mono)
					if((i>=2)&&(escalera.get(i)== escalera.get(i-2)))
							pareja +=2;
					else
						pareja++;
				
			
			}
				
		mono = escalera.get(i);		
			
		}
		
		switch(pareja) {
		case 1:
			pts += 15;
			break;
		case 2:
			pts += 30;
			break;
		case 3:
			pts += 50;
			break;
		case 4:
			pts += 80;
			break;
		case 5:
			pts += 90;
			break;
		}
		
		if(escalera.containsAll(escaleraReal)==true)
			pts +=150;

		else if(h>=4)
			pts += 60;
		else if ((h<=0 && n>=4)||(h>=2)||(h==1 && n>=2)) {
			pts += 35;
		}
		
		if ((c >=5)||(p >=5)||(t >=5)||(d >=5))
			pts += 70;
		else if ((c >=3)||(p >=3)||(t >=3)||(d >=3))
			pts += 20;
		return pts;
	}

	public void ganador() {
		fondo += Mesa.getBote();
		Mano.removeAll(Mano);
		
	}

	public void reiniciarApuesta() {
		apuesta = 0;
		
	}
	
}	

