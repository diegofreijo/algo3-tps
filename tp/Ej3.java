package tp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Ej3
{
	public static void Ejecutar()
	{
		System.out.println("Ejecutando Ej3:");
		System.out.println("===============");
		
		Datos datos = Parser.Leer("Tp1Ej3.in");
		Matriz potencia = datos.matriz.Potenciar(datos.n);
		System.out.println(datos.matriz.toString() + "^" + datos.n + ":\n" + potencia.toString());
		Parser.Escribir("Tp1Ej3.out", datos.n, potencia.Tam(), potencia);
	}

	private static class Matriz
	{
		private int[][] matriz;
		private int k;
		
		public Matriz(int tam)
		{
			k = tam;
			matriz = new int[k][k];
		}
		
		public Matriz(Matriz a)
		{
			k = a.Tam();
			matriz = new int[k][k];
			
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
			Matriz ret;
			
			if(n <= 0)
			{
				ret = new Matriz(k);
				ret.Identidad();
			}
			else
			{
				ret = new Matriz(this);
				Matriz pot2 = new Matriz(this);
				--n;
				
				while(n >= 1)
				{
					if(n % 2 == 0)
					{
						n /= 2;
					}
					else
					{
						--n;
						n /= 2;
						ret = ret.Multiplicar(pot2);
					}
					pot2 = pot2.Multiplicar(pot2);
				}
				
			}	
			
			return ret;
		}
		
		public void Identidad()
		{
			for(int i = 0; i < k; ++i)
			{
				for(int j = 0; j < k; ++j)
				{
					if(i == j)
					{
						matriz[i][i] = 1;
					}
					else
					{
						matriz[i][j] = 0;
					}
				}
			}
		}

		public Matriz Multiplicar(Matriz b)
		{
			Matriz ret = new Matriz(k);
			int valor;
			
			for(int i = 0; i < k; ++i)
			{
				for(int j = 0; j < k; ++j)
				{
					valor = 0;
					for(int t = 0; t < k; ++t)
					{
						valor += this.Leer(i,t) * b.Leer(t,j);
					}
					ret.Escribir(i,j,valor);
				}
			}
			
			return ret;
		}
		
		public void Escribir(int i, int j, int valor)
		{
			matriz[i][j] = valor;
		}

		public int Leer(int i, int j)
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
					ret += matriz[i][j] + "	";
				}
				ret += "\n";
			}
			
			return ret;		
		}
		
	}
	
	private static class Datos
	{
		public Matriz matriz;
		public Integer n;
	}
	
	private static class Parser
	{
		public static Datos Leer(String ruta)
		{
			ruta = System.getProperty("java.class.path") + System.getProperty("file.separator") + ruta;
			Matriz matriz;
			int n, k;
			Datos ret = new Datos();
			
		    try
		    {
		        BufferedReader in = new BufferedReader(new FileReader(ruta));
		        List<Integer> linea = new ArrayList<Integer>();
		        
		        linea = LeerLinea(in.readLine().trim());
		        n = linea.get(0);
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
		        
		        if(Integer.valueOf(in.readLine()) != 0) throw new IOException("Falta el cero del final");
		        in.close();
		        
		        ret.matriz = matriz;
			    ret.n = n;
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
	
		public static void Escribir(String ruta, int n,  int k, Matriz potencia)
		{
			ruta = System.getProperty("java.class.path") + System.getProperty("file.separator") + ruta;
			
			try
			{
				BufferedWriter out = new BufferedWriter(new FileWriter(ruta));
		        String salida;
		        
		        salida = Integer.toString(n) + " " + Integer.toString(k) + "\n";	        
		        salida += potencia.toString();
				salida += "0";
		        
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