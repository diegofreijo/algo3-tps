package ej4;

import java.util.LinkedList;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Math;

public abstract class Ej4
{
	// Nombres de los archivos
	static String ruta_entrada = "Tp1Ej4.in";
	static String ruta_salida = "Tp1Ej4.out";
	static String ruta_estadisticas = "Tp1Ej4.dat";
	
	// Contadores de operaciones
	private static long op_fac;
	private static long op_ep;
	
	public static void Ejecutar()
	{
		System.out.println("Ejecutando Ej4:");
		System.out.println("===============");
	
		List<Integer> entradas = Parser.Leer(ruta_entrada);
		List<Integer> factorizacion;
		
		Parser.AgregarValor(ruta_salida, entradas.size(), false);
		for(Integer n : entradas)
		{
			op_fac = 0;	op_ep = 0;
			factorizacion = Factorizacion(n);
			System.out.println(n + ":  " + factorizacion.toString());
			Parser.Escribir(ruta_salida, n, factorizacion);
			//Parser.EscribirEstadisticas(ruta_estadisticas, n, op_fac + op_ep);
		}
		Parser.AgregarValor(ruta_salida, 0, true);
	}
	
	public static List<Integer> Factorizacion(Integer n)
	{
		List<Integer> primos = new LinkedList<Integer>(); ++op_fac;
		List<Integer> ret = new LinkedList<Integer>(); ++op_fac;
		int p = 2; ++op_fac;
		
		while(n > 1)
		{
			++op_fac;
			if(EsPrimo(p, primos))
			{
				++op_fac;
				primos.add(p); ++op_fac;
				while(n % p == 0)
				{
					++op_fac;
					n = n / p; ++op_fac;
					ret.add(p); ++op_fac;
				}
			}
			++p; ++op_fac;
		}
		
		++op_fac;
		return ret;
	}

	// Precond: primos tiene todos los primos enteros menores a n ordenados crecientemente
	public static boolean EsPrimo(int n, final List<Integer> primos)
	{
		boolean ret = true; ++op_ep;
		int r = (int)Math.round(Math.sqrt(n)) + 1; ++op_ep;
		
		for (Integer p : primos)
		{
			++op_ep;
			++op_ep;
			if(p >= r) break;
			if(n % p == 0)
			{
				 ++op_ep;
				ret = false; ++op_ep;
				break;
			}
		}
		
		++op_ep;
		return ret;
	}
	
	private static class Parser
	{
		static String fs = System.getProperty("file.separator");
		
		public static List<Integer> Leer(String ruta)
		{
			List<Integer> ret = new LinkedList<Integer>();
			ruta = System.getProperty("java.class.path") + fs + "ej4" + fs + "in" + fs + ruta;
			
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

		public static void AgregarValor(String ruta, Integer valor, Boolean agregar)
		{
			ruta = System.getProperty("java.class.path") + fs + "ej4" + fs + "out" + fs + ruta;
			
			try
			{
				BufferedWriter out = new BufferedWriter(new FileWriter(ruta, agregar));
				out.append(valor.toString() + "\n");
		        out.close();
			}
			catch (IOException e)
			{
		    	System.out.println("Error agregando valor al archivo de salida: ");
		    	e.printStackTrace();
			}
			
		}

		public static void Escribir(String ruta, int n,  List<Integer> valores)
		{
			ruta = System.getProperty("java.class.path") + fs + "ej4" + fs + "out" + fs + ruta;
			
			try
			{
				BufferedWriter out = new BufferedWriter(new FileWriter(ruta, true));
		        String salida;
		        
		        salida = Integer.toString(n) + "\n";	        
		        for(Integer val : valores)
		        {
		        	salida += Integer.toString(val) + " ";
		        }
				salida += "\n";
		        
				out.append(salida);
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