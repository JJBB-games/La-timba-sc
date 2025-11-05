package Juego;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Azar {
	
	public static float prob() {
        Random random = new Random();
        double probabilidad = random.nextDouble();
        return (float) probabilidad;
		
	}
	
	public static boolean xPorciento (int x){
		if (prob() <= x/100.0)
			return true;
		
		return false;
	}
	
	public static int repartir(int N) {
        Random random = new Random();
        double probabilidad = random.nextInt(N);
        return (int) probabilidad;
	}

	public static String personaje(List<String> listaPersonajes) {
		
		List<String> a = listaPersonajes;
		int z = repartir(a.size());
		String w = a.get(z);
		a.remove(z);
		
		return w;
	}

	

	public static int Apuesta(int pts, int n) {
		
		if (n == 1) {
			
			if(pts >20 ) {
				if(xPorciento(70) == true)
					return 2;
				else if (xPorciento(90) == true)
					return 1;
				else 
					return 0;
			}
			
			if(pts >15 ) {
				if(xPorciento(50) == true)
					return 2;
				else if (xPorciento(70) == true)
					return 1;
				else 
					return 0;
			}	
			
			if(pts >10 ) {
				if(xPorciento(30) == true)
					return 2;
				else if (xPorciento(50) == true)
					return 1;
				else 
					return 0;
			}
			
			if(pts <=10 ) {
				if(xPorciento(5) == true)
					return 2;
				else if (xPorciento(25) == true)
					return 1;
				else 
					return 0;
			}
		}
			
			
		
			else if(n == 2) {
				if(pts >= 100 ) {
					if(xPorciento(70) == true)
						return 3;
					else if (xPorciento(95) == true)
						return 1;
					else if (xPorciento(100) == true)
						return 1;
					else 
						return 0;
				}
				
				if(pts >=50 ) {
					if(xPorciento(50) == true)
						return 3;
					else if (xPorciento(80) == true)
						return 2;
					else if (xPorciento(100) == true)
						return 1;
					else 
						return 0;
				}	
				
				if(pts >=30 ) {
					if(xPorciento(30) == true)
						return 3;
					else if (xPorciento(50) == true)
						return 2;
					else if (xPorciento(70) == true)
						return 1;
					else 
						return 0;
				}
				
				if(pts <=30 ) {
					if(xPorciento(5) == true)
						return 2;
					else if (xPorciento(25) == true)
						return 1;
					else 
						return 0;
				}
			}
		
		
		
		return 0;
	}
		
	
	
}
