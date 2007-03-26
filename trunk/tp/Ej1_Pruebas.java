package tp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Ej1_Pruebas {

	public static void Probar()
	{
		System.out.println("Probando Ej1:");
		System.out.println("=============");
		
		int i = 0;
		
		//while(i<50){
			
			String archivo = "salida";
			String numero =String.valueOf(i);
			archivo = archivo.concat(numero);
			archivo = archivo.concat(".txt");
			
			Datos conjuntos = Parser.Leer(archivo);
			
			System.out.println(conjuntos.S);
			System.out.println(conjuntos.T);
			
			List<List<Integer>> mayores = Ej1.Mayores(conjuntos.S, conjuntos.T);
			
			System.out.println(mayores);
			//System.out.println(mayores.size());
			
			List<Integer> Sumas = new ArrayList<Integer>();
			
			int j = 0;
			
			while(j < mayores.size()){
								
				int suma = mayores.get(j).get(0) + mayores.get(j).get(1);
				Sumas.add(suma);
						
				j++;
			}
			
			List<Integer> SumasTotales = new ArrayList<Integer>();
			
			int k = 0;
			
			while (k < conjuntos.S.size()){
				
				int l = 0;
				
				while (l < conjuntos.T.size()){
					
					int sumtot = conjuntos.S.get(k) + conjuntos.T.get(l);
					SumasTotales.add(sumtot);
					
					l++;
				}
				
				k++;
			}
			
			System.out.println(Sumas);
			System.out.println(PruebaMayores(Sumas));
			//PruebaConjunto(Sumas,SumasTotales);		
				
		//i++;
			
		//}
	}	
	
	private static boolean PruebaMayores(List<Integer> Sumas){
		
		int i = 1;
		int j = 0;
		
		boolean ret = true;
		
		while(i < Sumas.size() && ret){
			
			if(Sumas.get(j) < Sumas.get(i)){
				ret = false;
			}
			
			i++;
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
