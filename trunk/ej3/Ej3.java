package ej3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import estadistica.Estadistica;
import estadistica.Punto2d;
import estadistica.Punto3d;

public abstract class Ej3
{
	// Nombres de los archivos
	static String ruta_entrada = "Tp1Ej3.in";
	static String ruta_salida = "Tp1Ej3.out";
	static String ruta_contar_ejecutar = "ej3\\dat\\Tp1Ej3.dat";
	static String ruta_contar_mul = "ej3\\dat\\Tp1Ej3(multiplicar).dat";
	static String ruta_contar_cant_mul = "ej3\\dat\\Tp1Ej3(cant_mul).dat";
	static String ruta_contar_pot = "ej3\\dat\\Tp1Ej3(potenciar).dat";
	static String ruta_contar_pot_fb = "ej3\\dat\\Tp1Ej3(potenciar_fb).dat";
	
	// Contadores de operaciones
	private static long op_mul;
	private static long op_pot;
	private static long cant_mul;
	
	public static void Ejecutar()
	{
		System.out.println("Ejecutando Ej3:");
		System.out.println("===============");
		
		List<Instancia> entradas = Parser.Leer(ruta_entrada);
		Matriz potencia;
		List<Punto3d> estadistica = new LinkedList<Punto3d>();
		
		Parser.AgregarValor(ruta_salida, entradas.size(), false);
		for(Instancia instancia : entradas)
		{
			op_mul = 0; op_pot = 0;
			potencia = instancia.matriz.Potenciar(instancia.n);
			System.out.println(instancia.matriz.toString() + "^" + instancia.n + ":\n" + potencia.toString());
			Parser.Escribir(ruta_salida, instancia.n, potencia.Tam(), potencia);
			estadistica.add(new Punto3d((long)instancia.matriz.Tam(), (long)instancia.n, op_mul + op_pot));
		}
		Parser.AgregarValor(ruta_salida, 0, true);
		Estadistica.GuardarDatos(ruta_contar_ejecutar, estadistica);
	}
	
	public static void Contar_Multiplicar()
	{
		System.out.println("Contando operaciones de Multiplicar:");
		System.out.println("====================================");
		
		Matriz prueba;
		List<Punto2d> estadistica = new LinkedList<Punto2d>();
		long t = 0;
		
		for(int k = 2; k <= 150; ++k)
		{
			prueba = new Matriz(k);
			prueba.Identidad();
			op_mul = 0;
			prueba = prueba.Multiplicar(prueba);
			System.out.println("k = " + k + " ---> " + op_mul);
			estadistica.add(new Punto2d((long)t, op_mul));
		}
		Estadistica.GuardarDatos(ruta_contar_mul, estadistica);
	}
	
	public static void Contar_CantMul()
	{
		System.out.println("Contando cantidad de multiplicaciones de Potenciar:");
		System.out.println("===================================================");
		
		Matriz prueba = new Matriz(2);
		prueba.Identidad();
		List<Punto2d> estadistica = new LinkedList<Punto2d>();
		
		for(int n = 1; n <= 3000; ++n)
		{
			cant_mul = 0;
			prueba = prueba.Potenciar(n);
			System.out.println("n = " + n + " ---> " + cant_mul);
			estadistica.add(new Punto2d((long)n, cant_mul));
		}
		Estadistica.GuardarDatos(ruta_contar_cant_mul, estadistica);
	}
	
	public static void Contar_Potenciar()
	{
		System.out.println("Contando operaciones de Potenciar:");
		System.out.println("==================================");
		
		Matriz prueba;
		List<Punto3d> estadistica = new LinkedList<Punto3d>();
		
		for(int k = 2; k <= 40; ++k)
		{
			prueba = new Matriz(k);
			for(int n = 1; n <= 40; ++n)
			{
				op_mul = 0; op_pot = 0;
				prueba = prueba.Potenciar(n);
				System.out.println("(k = " + k + ") n = " + n + " ---> " + (op_mul + op_pot));
				estadistica.add(new Punto3d((long)k, (long)n, op_mul + op_pot));
			}
		}
		Estadistica.GuardarDatos(ruta_contar_pot, estadistica);
	}
	
	public static void Contar_Potenciar_FuerzaBruta()
	{
		System.out.println("Contando operaciones de Potenciar por Fuerza Bruta:");
		System.out.println("===================================================");
		
		Matriz prueba;
		List<Punto3d> estadistica = new LinkedList<Punto3d>();
		
		for(int k = 2; k <= 40; ++k)
		{
			prueba = new Matriz(k);
			for(int n = 1; n <= 40; ++n)
			{
				op_mul = 0; op_pot = 0;
				prueba = prueba.Potenciar_FuerzaBruta(n);
				System.out.println("(k = " + k + ") n = " + n + " ---> " + (op_mul + op_pot));
				estadistica.add(new Punto3d((long)k, (long)n, op_mul + op_pot));
			}
		}
		Estadistica.GuardarDatos(ruta_contar_pot_fb, estadistica);
	}

	private static class Matriz
	{
		private long[][] matriz;
		private int k;
		
		public Matriz(int tam)
		{
			k = tam;
			matriz = new long[k][k];
		}
		
		public Matriz(Matriz a)
		{
			k = a.Tam();
			matriz = new long[k][k];
			
			for(int i = 0; i < k; ++i)
			{
				for(int j = 0; j < k; ++j)
				{
					matriz[i][j] = a.Leer(i,j);
				}
			}
		}
		
		public Matriz Potenciar(int n)
		{
			Matriz ret; ++op_pot;
			
			++op_pot;
			if(n <= 0)
			{
				ret = new Matriz(k); op_pot += k*k;
				ret.Identidad(); op_pot += k*k;
			}
			else
			{
				ret = new Matriz(k); op_pot += k*k;
				ret.Identidad(); op_pot += k*k;
				Matriz pot2 = new Matriz(this); op_pot += 2*k*k;
				
				while(n >= 1)
				{
					++op_pot;
					++op_pot;
					if(n % 2 == 0)
					{
						n /= 2; ++op_pot;
					}
					else
					{
						--n; ++op_pot;
						n /= 2; ++op_pot;
						ret = ret.Multiplicar(pot2); ++op_pot; ++cant_mul;
					}
					++op_pot;
					if(n >= 1)
					{
						pot2 = pot2.Multiplicar(pot2); ++op_pot; ++cant_mul;
					}
				}
			}
			
			++op_pot;
			return ret;
		}
				
		public Matriz Potenciar_FuerzaBruta(int n)
		{
			Matriz ret; ++op_pot;
			
			if(n <= 0)
			{
				ret = new Matriz(k); op_pot += k*k;
				ret.Identidad(); op_pot += k*k;
			}
			else
			{
				ret = new Matriz(this); ++op_pot;
				
				while(n > 1)
				{
					++op_pot;
					ret = ret.Multiplicar(this); ++op_pot;
					--n; ++op_pot;
				}
			}
			
			++op_pot;
			return ret;
		}
		
		public void Identidad()
		{
			for(int i = 0; i < k; ++i)
			{
				for(int j = 0; j < k; ++j)
				{
					matriz[i][j] = (i == j ? 1 : 0);
				}
			}
		}

		public Matriz Multiplicar(Matriz b)
		{
			Matriz ret = new Matriz(k); op_mul += 2*k*k;
			int suma; ++op_mul;
			
			for(int i = 0; i < k; ++i)
			{
				++op_mul;
				for(int j = 0; j < k; ++j)
				{
					++op_mul;
					suma = 0; ++op_mul;
					for(int t = 0; t < k; ++t)
					{
						suma += this.Leer(i,t) * b.Leer(t,j); ++op_mul;
					}
					ret.Escribir(i,j,suma); ++op_mul;
				}
			}
			
			++op_mul;
			return ret;
		}
		
		public void Escribir(int i, int j, long valor)
		{
			matriz[i][j] = valor;
		}

		public long Leer(int i, int j)
		{
			return matriz[i][j];
		}

		public int Tam()
		{
			return k;
		}
		
		public String toString()
		{
			String ret = "";
			for(int i = 0; i < k; ++i)
			{
				for(int j = 0; j < k; ++j)
				{
					ret += matriz[i][j] + " ";
				}
				ret += "\n";
			}
			
			return ret;
		}
		
	}
		
	private static class Instancia
	{
		public Matriz matriz;
		public Integer n;
	}
	
	private static class Parser
	{
		static String fs = System.getProperty("file.separator");
		
		public static List<Instancia> Leer(String ruta)
		{
			ruta = System.getProperty("java.class.path") + fs + "ej3" + fs + "in" + fs + ruta;
			List<Instancia> ret = new ArrayList<Instancia>();
			
			Instancia actual;
			int n, k;
			Matriz matriz;
			
		    try
		    {
		        BufferedReader in = new BufferedReader(new FileReader(ruta));
		        List<Integer> linea = new ArrayList<Integer>();
		        
		        linea = LeerLinea(in.readLine().trim());
		        n = linea.get(0);		 		        
		        while(n != 0)
		        {
			        k = linea.get(1);
			 		matriz = new Matriz(k);
			        for(int i = 0; i < k; ++i)
			        {
			        	linea = LeerLinea(in.readLine().trim());
			        	for(int j = 0; j < k; ++j)
			        	{
			        		matriz.Escribir(i,j,linea.get(j));
			        	}
			        }
			        
			        actual = new Instancia();
			        actual.matriz = matriz;
			        actual.n = n;
			        ret.add(actual);
		        
			        linea = LeerLinea(in.readLine().trim());
			        n = linea.get(0);
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

		private static List<Integer> LeerLinea(String linea)
		{
			List<Integer> valores = new ArrayList<Integer>();
			char[] ca = linea.toCharArray();
			String actual = "";
			
			for(int i = 0; i < ca.length; ++i)
			{
				if(ca[i] != ' ')
				{
					do
					{
						actual += ca[i];
						++i;
					}
					while((i < ca.length) && (ca[i] != ' '));
					valores.add(Integer.valueOf(actual));
					actual = "";
				}
			}
			
			return valores;
		}
		
		public static void AgregarValor(String ruta, Integer valor, Boolean agregar)
		{
			ruta = System.getProperty("java.class.path") + fs + "ej3" + fs + "out" + fs + ruta;
			
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
	
		public static void Escribir(String ruta, int n,  int k, Matriz potencia)
		{
			ruta = System.getProperty("java.class.path") + fs + "ej3" + fs + "out" + fs + ruta;
			
			try
			{
				BufferedWriter out = new BufferedWriter(new FileWriter(ruta, true));
		        String salida;
		        
		        salida = Integer.toString(n) + " " + Integer.toString(k) + "\n";	        
		        salida += potencia.toString();
		        
				out.write(salida);
		        out.close();
			}
			catch (IOException e)
			{
		    	System.out.println("Error escribiendo el archivo de salida: ");
		    	e.printStackTrace();
			}
		}
		
		public static void EscribirEstadisticas(String ruta, Integer n, Integer k, Long op)
        {
			ruta = System.getProperty("java.class.path") + fs + "ej3" + fs + "dat" + fs + ruta;
			
			try
			{
				BufferedWriter out = new BufferedWriter(new FileWriter(ruta, true));
		        
		        out.write(n.toString() + " " + k.toString() + " " + op.toString() + "\n");
		        out.close();
			}
			catch (IOException e)
			{
		    	System.out.println("Error escribiendo las estadisticas: ");
		    	e.printStackTrace();
			}
        }
	
	}
}