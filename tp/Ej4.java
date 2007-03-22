package tp;

import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

public abstract class Ej4
{
	public static void Ejecutar()
	{
		Integer n = Parser.Leer("Tp1Ej4.in").get(0);
		List<Integer> factorizacion = new ArrayList<Integer>();
		factorizacion = Factorizacion(n);
		System.out.println(n + ":  " + factorizacion.toString());
		Parser.Escribir("Tp1Ej4.out", n, factorizacion);
	}
	
	public static List<Integer> Factorizacion(Integer n)
	{
		List<Integer> primos = new ArrayList<Integer>();
		List<Integer> ret = new ArrayList<Integer>();
		int p = 2;
		
		while(n > 1)
		{
			if(EsPrimo(p, primos))
			{
				primos.add(p);
				while(n % p == 0)
				{
					n = n / p;
					ret.add(p);
				}
			}
			++p;
		}
		
		return ret;
	}

	private static boolean EsPrimo(int n, final List<Integer> primos)
	{
		boolean ret = true;
		int r = (int)Math.round(Math.sqrt(n)) + 1;
		
		for (Integer p : primos)
		{
			if(p >= r) break; 
			if(n % p == 0)
			{
				ret = false;
				break;
			}
		}
		
		return ret;
	}

}