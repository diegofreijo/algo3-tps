package tp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ej1
{

	public static void Ejecutar()
	{
		System.out.println("Ejecutando Ej1:");
		System.out.println("===============");
		
		Integer n = Parser.Leer("Tp1Ej1.in").get(0);
		Integer i = 1;
		
		List<Integer> A = new ArrayList<Integer>();
		while(i <= n)
		{
			A.add(Parser.Leer("Tp1Ej1.in").get(i));
			i++;
		}
		
		System.out.println(A.toString());
		
		i = n + 1;
		Integer j = n*2;
		List<Integer> B = new ArrayList<Integer>();
		
		while( i <= j)
		{
			B.add(Parser.Leer("Tp1Ej1.in").get(i));
			i++;
		}
		System.out.println(B.toString());
		System.out.println(Mayores(A,B,n).toString() + "\n");
	}
	
	public static List<List<Integer>> Mayores(final List<Integer> A, final List<Integer> B, Integer n)
	{
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
	
		List<Integer> temp = new ArrayList<Integer>();
		temp.add(A.get(0));
		temp.add(B.get(0));
		ret.add(temp);
		
		Integer i = 0;
		
		n--;
		
		while (n > 0)
		{
			Integer valor = A.get(i) + B.get(i+1);
			
			List<List<Integer>> mayores = new ArrayList<List<Integer>>();
			mayores = BuscoMayor(valor,A,B,i,n);
			
			if (mayores.isEmpty())
			{
				List<Integer> temp1 = new ArrayList<Integer>();
				temp1.add(A.get(i));
				temp1.add(B.get(i+1));
				ret.add(temp1);
				n--;
				
			} else {
				int k = mayores.size();
				int m = 0;
				
				while (m < k && n > 0)
				{
					ret.add(mayores.get(m));
					m++;
					n--;
				}
				
				if (n > 0)
				{
				List<Integer> temp1 = new ArrayList<Integer>();
				temp1.add(A.get(i));
				temp1.add(B.get(i+1));
				ret.add(temp1);
				n--;
				}
			}
			i++;
		}
		
		return ret;	
	}
	
	private static List<List<Integer>> BuscoMayor(int valor,final List<Integer> A, final List<Integer> B, Integer i, Integer n)
	{
		int j = 1;
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		
		while(j <= n)
		{	
			if (A.get(j)+B.get(i) > valor)
			{
				List<Integer> ret1 = new ArrayList<Integer>();
				ret1.add(A.get(j));
				ret1.add(B.get(i));
				ret.add(ret1);
				j++;
			}else{
				j++;
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
