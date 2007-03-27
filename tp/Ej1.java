package tp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Ej1
{

	public static void Ejecutar()
	{
		System.out.println("Ejecutando Ej1:");
		System.out.println("===============");
		
		Datos conjuntos = Parser.Leer("salida6.txt");
		System.out.println(conjuntos.S.toString());
		System.out.println(conjuntos.T.toString());
		
		List<List<Integer>> mayores = Mayores(conjuntos.S, conjuntos.T);
		//System.out.println(mayores.toString() + "\n");
	}
	
	public static List<List<Integer>> Mayores(final List<Integer> A, final List<Integer> B)
	{
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		
		Integer i = 0;
		
		Integer n = A.size();
		
		while (n > 0)
		{
			List<Integer> temp = new ArrayList<Integer>();
			temp.add(A.get(i));
			temp.add(B.get(i));
			ret.add(temp);
			n--;
			
			Integer valor = A.get(i) + B.get(i+1);
			
			List<List<Integer>> mayores = new ArrayList<List<Integer>>();
			mayores = BuscoMayor(valor,A,B,i,n);
			int valor1 = A.get(i+1) + B.get(i+1);
			List<List<Integer>> menores = new ArrayList<List<Integer>>();
			menores = BuscoMayor(valor1,A,B,i,n);
			List<List<Integer>> menores1 = new ArrayList<List<Integer>>();
			menores1 = BuscoMayor(valor1, B, A, i, n);
			
			if(n>0){
				if (!mayores.isEmpty())
				{
					int k = mayores.size();
					int m = 0;
					
					while (m < k && n > 0)
					{
						ret.add(mayores.get(m));
						m++;
						n--;
					}				
				}
				
				if (n > 0)
				{
					List<Integer> temp1 = new ArrayList<Integer>();
					temp1.add(A.get(i));
					temp1.add(B.get(i+1));
					ret.add(temp1);
					n--;
				}
				
				if (n > 0)
				{
					if (!menores.isEmpty())
					{
						int k = menores.size();
						int m = 0;
						
						while (m < k && n > 0)
						{
							ret.add(menores.get(m));
							m++;
							n--;
						}				
					}
				}
			}
			i++;
		}
		
		List<Integer> Sumas = new ArrayList<Integer>();
		
		int j = 0;
		
		while(j < ret.size()){
							
			int suma = ret.get(j).get(0) + ret.get(j).get(1);
			Sumas.add(suma);
					
			j++;
		}
		
		List<Integer> SumasTotales = new ArrayList<Integer>();
		
		int k = 0;
		
		while (k < A.size()){
			
			int l = 0;
			
			while (l < B.size()){
				
				int sumtot = A.get(k) + B.get(l);
				SumasTotales.add(sumtot);
				
				l++;
			}
			
			k++;
		}
		
		//Collections.sort(SumasTotales);
		//Collections.reverse(SumasTotales);
		System.out.println(ret);
		//System.out.println(SumasTotales);
		//System.out.println(Sumas);
		
		return ret;	
	}
	
	private static List<List<Integer>> BuscoMayor(int valor,final List<Integer> A, final List<Integer> B, Integer i, Integer n)
	{
		int j = i+1;
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		
		int k = 0;
		
		while(k < A.size()){
		
			while(j < A.size())
			{	
				int g = A.get(j);
				int h = B.get(k);
				
				if (A.get(j)+B.get(k) >= valor)
				{
					List<Integer> ret1 = new ArrayList<Integer>();
					ret1.add(A.get(j));
					ret1.add(B.get(k));
					ret.add(ret1);
					j++;
				}else{
					j++;
				}
			}	
			k++;
		}
		return ret;
	}

	private static class Datos
	{
		List<Integer> S;
		List<Integer> T;
	}
	
	private static class Parser
	{
		public static Datos Leer(String ruta)
		{
			Datos ret = new Datos();
			ret.S = new ArrayList<Integer>();
			ret.T = new ArrayList<Integer>();
			
			ruta = System.getProperty("java.class.path") + System.getProperty("file.separator") + ruta;
			
		    try
		    {
		        BufferedReader in = new BufferedReader(new FileReader(ruta));
		        
		        Integer n = Integer.valueOf(in.readLine().trim());
		        
		        for(int i = 0; i < n; ++i)
		        {
		        	ret.S.add(Integer.valueOf(in.readLine().trim()));
		        }
		        
		        for(int i = 0; i < n; ++i)
		        {
		        	ret.T.add(Integer.valueOf(in.readLine().trim()));
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
