package tp;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
	
	private static class Parser
	{
		public static List<Integer> Leer(String ruta)
		{
			List<Integer> ret = new ArrayList<Integer>();
			ruta = System.getProperty("java.class.path") + System.getProperty("file.separator") + ruta;
			
		    try
		    {
		        BufferedReader in = new BufferedReader(new FileReader(ruta));
		        Integer actual;
		        	        
		        while ((actual = Integer.valueOf(in.readLine().trim())) != 0)
		        {
		        	ret.add(actual);
		        }
		        
		        in.close();
		    } 
		    catch (IOException e)
		    {
		    	System.out.println("Error leyendo el archivo de entrada: ");
		    	e.printStackTrace();
		    }
		    
		    return ret;
		}
		
		public static void Escribir(String ruta, int n,  List<Integer> valores)
		{
			ruta = System.getProperty("java.class.path") + System.getProperty("file.separator") + ruta;
			
			try
			{
				BufferedWriter out = new BufferedWriter(new FileWriter(ruta));
		        String salida;
		        
		        salida = Integer.toString(n) + "\n";	        
		        for(Integer val : valores)
		        {
		        	salida += Integer.toString(val) + " ";
		        }
				salida += "\n0";
		        
				out.write(salida);
		        out.close();
			}
			catch (IOException e)
			{
		    	System.out.println("Error escribiendo el archivo de salida: ");
		    	e.printStackTrace();
			}
		}
	}
}