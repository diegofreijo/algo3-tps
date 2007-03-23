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
		Datos datos = Parser.Leer("Tp1Ej3.in");
		Matriz potencia = datos.matriz.Potenciar(datos.n);
		System.out.println(datos.matriz.toString() + "^" + datos.n + ":\n" + potencia.toString());
		Parser.Escribir("Tp1Ej3.out", datos.n, potencia.Tam(), potencia);
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