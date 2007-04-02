package tp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//import java.util.Collections;


public class Ej1
{
	private static long op_may;
	private static long op_bus;
	private static long op_orl;
	private static long op_ord;
	private static long op_val;
	static String ruta_estadisticas = "Tp1Ej1.dat";
	
	public static void Ejecutar()
	{
		System.out.println("Ejecutando Ej1:");
		System.out.println("===============");
				
		Datos conjuntos = Parser.Leer("salida0.txt");
		//System.out.println(conjuntos.S.toString());
		//System.out.println(conjuntos.T.toString());
		
		int n = conjuntos.S.size();
		
		List<List<Integer>> mayores = Mayores(conjuntos.S, conjuntos.T);
		//System.out.println(mayores.toString() + "\n");
		long operaciones = op_val+op_may+op_bus+op_orl+op_ord;
		System.out.println(operaciones);
		Parser.EscribirEstadisticas(ruta_estadisticas, n, operaciones);
		
	}
	
	public static List<List<Integer>> Mayores(final List<Integer> A, final List<Integer> B)
	{
		List<List<Integer>> ret = new ArrayList<List<Integer>>(); op_may++;
		
		Integer i = 0; op_may++;
		
		Integer n = A.size(); op_may++;
		
		while (n > 0)
		{
			System.out.println(n);
			op_may++;
			List<Integer> temp = new ArrayList<Integer>();op_may++;
			temp.add(A.get(i));op_may++;
			temp.add(B.get(i));op_may++;
			ret.add(temp);op_may++;
			n--;op_may++;
			
			Integer valor = A.get(i) + B.get(i+1);op_may++;
			
			List<List<Integer>> mayores = new ArrayList<List<Integer>>();op_may++;
			mayores = BuscoMayor(valor,A,B,i);op_may++;
			int valor1 = A.get(i+1) + B.get(i+1);op_may++;
			List<List<Integer>> menores = new ArrayList<List<Integer>>();op_may++;
			menores = BuscoMayor(valor1,A,B,i);op_may++;
			List<List<Integer>> menores1 = new ArrayList<List<Integer>>();op_may++;
			menores1 = BuscoMayor2(valor1, B, A, i);op_may++;
			List<List<Integer>> ingresar = new ArrayList<List<Integer>>();op_may++;
			List<Integer> temp1 = new ArrayList<Integer>();op_may++;
			temp1.add(A.get(i));op_may++;
			temp1.add(B.get(i+1));op_may++;
			mayores.add(temp1);op_may++;
			ingresar = OrdenarListas(Ordenar(mayores),Ordenar(menores),Ordenar(menores1),ret);op_may++;op_may++;op_may++;op_may++;
			
			int f = 0;op_may++;
			while(n > 0 && f < ingresar.size()){
				op_may++;
				op_may++;
				ret.add(ingresar.get(f));op_may++;
				f++;op_may++;
				n--;op_may++;
			}
			i++;op_may++;
		}
		
		/*List<Integer> Sumas = new ArrayList<Integer>();
		
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
		}*/
		
		//Collections.sort(SumasTotales);
		//Collections.reverse(SumasTotales);
		//System.out.println(ret);
		//System.out.println(SumasTotales);
		//System.out.println(Sumas);
		
		op_may++;
		return ret;	
	}
	
	private static List<List<Integer>> BuscoMayor(int valor,final List<Integer> A, final List<Integer> B, Integer i)
	{
		List<List<Integer>> ret = new ArrayList<List<Integer>>();op_bus++;
		
		int k = 0;op_bus++;
		
		while(k <= i){
			
			op_bus++;
			int j = i+1;op_bus++;			
			while(j < A.size())
			{	
				op_bus++;
				int g = A.get(j);op_bus++;
				int h = B.get(k);op_bus++;
				
				if (g+h >= valor)
				{
					op_bus++;
					List<Integer> ret1 = new ArrayList<Integer>();op_bus++;
					ret1.add(A.get(j));op_bus++;
					ret1.add(B.get(k));op_bus++;
					ret.add(ret1);op_bus++;
					j++;op_bus++;
				}else{
					j++;op_bus++;
				}
			}	
			k++;op_bus++;
		}
		op_bus++;
		return ret;
	}
	
	private static List<List<Integer>> BuscoMayor2(int valor,final List<Integer> A, final List<Integer> B, Integer i)
	{
		List<List<Integer>> ret = new ArrayList<List<Integer>>();op_bus++;
		
		int k = 0;op_bus++;
		
		while(k <= i){
			
			op_bus++;
			int j = i+1;op_bus++;			
			while(j < A.size())
			{	
				op_bus++;
				int g = A.get(j);op_bus++;
				int h = B.get(k);op_bus++;
				
				if (g+h >= valor)
				{
					op_bus++;
					List<Integer> ret1 = new ArrayList<Integer>();op_bus++;
					ret1.add(B.get(k));op_bus++;
					ret1.add(A.get(j));op_bus++;
					ret.add(ret1);op_bus++;
					j++; op_bus++;
				}else{
					j++;op_bus++;
				}
			}	
			k++;op_bus++;
		}
		op_bus++;
		return ret;
	}
	
	private static List<List<Integer>> OrdenarListas(List<List<Integer>>a,List<List<Integer>>b,List<List<Integer>>c,List<List<Integer>>r){
		
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		
		while(a.size() > 0 || b.size() > 0 || c.size()>0)	
		{	
			op_orl++;
			if (a.size() > 0 && b.size() > 0 && c.size()>0){
				op_orl++;op_orl++;op_orl++;
				if (valor(a.get(0)) > valor(b.get(0))){
					op_orl++;
					if (valor(a.get(0)) > valor(c.get(0))){
						op_orl++;
						if(!ret.contains(a.get(0))&&!r.contains(a.get(0))){
							op_orl++;op_orl++;
							ret.add(a.get(0));op_orl++;
						}
						a.remove(0);op_orl++;
					} else {
						if(!ret.contains(c.get(0))&&!r.contains(c.get(0))){
							op_orl++;op_orl++;
							ret.add(c.get(0));op_orl++;
						}
						c.remove(0);op_orl++;
					}
				} else {
					if (valor(b.get(0)) > valor(c.get(0))){
						op_orl++;
						if(!ret.contains(b.get(0))&&!r.contains(b.get(0))){
							op_orl++;op_orl++;
							ret.add(b.get(0));op_orl++;
						}
						b.remove(0);op_orl++;
					} else {
						if(!ret.contains(c.get(0))&&!r.contains(c.get(0))){
							op_orl++;op_orl++;
							ret.add(c.get(0));op_orl++;
						}
						c.remove(0);op_orl++;
					}					
				} 
			} else {
				op_orl++;op_orl++;op_orl++;
				if(a.size() > 0 && b.size()>0 && c.size() == 0){
					op_orl++;op_orl++;op_orl++;
					if (valor(a.get(0)) > valor(b.get(0))){
						op_orl++;
						if(!ret.contains(a.get(0))&&!r.contains(a.get(0))){
							op_orl++;op_orl++;
							ret.add(a.get(0));op_orl++;
						}
						a.remove(0);op_orl++;
					} else {
						if(!ret.contains(b.get(0))&&!r.contains(b.get(0))){
							op_orl++;op_orl++;
							ret.add(b.get(0));op_orl++;
						}
						b.remove(0);op_orl++;					
					}		
				} else if(a.size() > 0 && b.size() == 0 && c.size() > 0){
					op_orl++;op_orl++;op_orl++;op_orl++;op_orl++;op_orl++;
					if (valor(a.get(0)) > valor(c.get(0))){
						op_orl++;
						if(!ret.contains(a.get(0))&&!r.contains(a.get(0))){
							op_orl++;op_orl++;
							ret.add(a.get(0));op_orl++;
						}
						a.remove(0);op_orl++;
					} else {
						if(!ret.contains(c.get(0))&&!r.contains(c.get(0))){
							op_orl++;op_orl++;
							ret.add(c.get(0));op_orl++;
						}
						c.remove(0);op_orl++;	
					}	
				} else if(a.size() == 0 && b.size() > 0 && c.size() > 0){
					op_orl++;op_orl++;op_orl++;op_orl++;op_orl++;op_orl++;
					if (valor(b.get(0)) > valor(c.get(0))){
						op_orl++;
						if(!ret.contains(b.get(0))&&!r.contains(b.get(0))){
							op_orl++;op_orl++;
							ret.add(b.get(0));op_orl++;
						}
						b.remove(0);op_orl++;
					} else {
						if(!ret.contains(c.get(0))&&!r.contains(c.get(0))){
							op_orl++;op_orl++;
							ret.add(c.get(0));op_orl++;
						}
						c.remove(0);op_orl++;	
					}					
				} else if(a.size() > 0 && b.size() == 0 && c.size() == 0){
					op_orl++;op_orl++;op_orl++;op_orl++;op_orl++;op_orl++;
					int i = a.size();op_orl++;
					while(i > 0){
						op_orl++;
						if(!ret.contains(a.get(0))&&!r.contains(a.get(0))){
							op_orl++;op_orl++;
							ret.add(a.get(0));op_orl++;
						}
						a.remove(0);op_orl++;
						i--;op_orl++;
					}
				} else if(a.size() == 0 && b.size() > 0 && c.size() == 0){
					op_orl++;op_orl++;op_orl++;op_orl++;op_orl++;op_orl++;
					int i = b.size();op_orl++;
					while(i > 0){
						op_orl++;
						if(!ret.contains(b.get(0))&&!r.contains(b.get(0))){
							op_orl++;op_orl++;
							ret.add(b.get(0));op_orl++;
						}
						b.remove(0);op_orl++;
						i--;op_orl++;
					}					
				} else if(a.size() == 0 && b.size() == 0 && c.size() > 0){
					op_orl++;op_orl++;op_orl++;op_orl++;op_orl++;op_orl++;
					int i = c.size();op_orl++;
					while(i > 0){
						op_orl++;
						if(!ret.contains(c.get(0))&&!r.contains(c.get(0))){
							op_orl++;op_orl++;
							ret.add(c.get(0));op_orl++;
						}
						c.remove(0);op_orl++;
						i--;op_orl++;
					}				
				}
			}
		}
		return ret;
	}

	private static Integer valor(List<Integer> a){
		
		int ret = a.get(0) + a.get(1);op_val++;op_val++;op_val++;
		op_val++;	
		return ret;
	}
	
	private static List<List<Integer>> Ordenar(List<List<Integer>> A){
		
		List<List<Integer>> ret = new ArrayList<List<Integer>>();op_ord++;
		List<Integer> maximo = new ArrayList<Integer>();op_ord++;
		if(A.isEmpty()){
			op_ord++;
			ret = A;op_ord++;
		} else {
			op_ord++;
			int j = A.size();op_ord++;
			
			while(ret.size() < j){
				op_ord++;
				int i = 0;op_ord++;
				maximo = A.get(0);op_ord++;
				int valormax = valor(maximo);op_ord++;
				while(i < A.size()){
					op_ord++;
					if(valor(A.get(i)) > valormax){
						op_ord++;
						maximo = A.get(i);op_ord++;
						valormax = valor(maximo);op_ord++;
						i++;op_ord++;
					} else {
						op_ord++;
						i++;op_ord++;			
					}
				}
				ret.add(maximo);op_ord++;
				A.remove(maximo);op_ord++;
			}
		}
		op_ord++;
		return ret;
	}
	public static class Datos
	{
		List<Integer> S;
		List<Integer> T;
	}
	
	public static class Parser
	{
		static String fs = System.getProperty("file.separator");
		
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
		
		public static void EscribirEstadisticas(String ruta, Integer n, Long op)
        {
			ruta = System.getProperty("java.class.path") + fs + "ej1" + fs + "dat" + fs + ruta;
			
			try
			{
				BufferedWriter out = new BufferedWriter(new FileWriter(ruta, true));
		        
		        out.write(n.toString() + " " + op.toString() + "\n");
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
