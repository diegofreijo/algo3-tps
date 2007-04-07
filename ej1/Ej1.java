package ej1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//import java.util.Collections;

//import ej4.Ej4.Parser;

//import ej4.Ej4.Parser;


public class Ej1
{
	private static long op_may;
	private static long op_bus;
	private static long op_orl;
	private static long op_ord;
	private static long op_val;
	static String ruta_estadisticas = "Tp1Ej1BM.dat";
	static String ruta_salida = "Tp1Ej1.out";
	//static String ruta_entrada = "Tp1Ej1.in";
	static String ruta_entrada = "Tp1Ej1pruebas.in";
	
	public static void Ejecutar()
	{
		System.out.println("Ejecutando Ej1:");
		System.out.println("===============");
		
		List<Instancia> entradas = Parser.Leer(ruta_entrada);
		List<List<Integer>> mayores; 
		
		System.out.println(entradas.size());
		Parser.AgregarValor(ruta_salida, entradas.size(), false);
		for(Instancia i : entradas)
		{
			System.out.println(i.Datos.S.size());
			op_may=0;op_bus=0;op_orl=0;op_ord=0;op_val=0;
			mayores = Mayores(i.Datos.S, i.Datos.T);
			//System.out.println(mayores);
			Parser.Escribir(ruta_salida, entradas.size(), mayores);
			long operaciones = op_may;
			//long operaciones = op_val+op_may+op_bus+op_orl+op_ord;
			Parser.EscribirEstadisticas(ruta_estadisticas, i.Datos.S.size(), operaciones);
		}
		System.out.println(op_val + " " + op_may + " " + op_bus + " " + op_orl + " " + op_ord);
	}
	
	public static List<List<Integer>> Mayores(final List<Integer> A, final List<Integer> B)
	{
		List<List<Integer>> ret = new ArrayList<List<Integer>>(); op_may++;
		
		Integer i = 0; op_may++;
		
		Integer n = A.size(); op_may++;
		
		while (n > 0)
		{
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
			
			ingresar = OrdenarListas(OrdenarQS(mayores),OrdenarQS(menores),OrdenarQS(menores1),ret);op_may++;op_may++;op_may++;op_may++;
			//ingresar = OrdenarListas(Ordenar(mayores),Ordenar(menores),Ordenar(menores1),ret);op_may++;op_may++;op_may++;op_may++;
			
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
					break;
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
					break;
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
	
/*	private static List<List<Integer>> Ordenar(List<List<Integer>> A){
		
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
	}*/
	
	
	private static List<List<Integer>> OrdenarQS(List<List<Integer>> A){
		
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		
		if (A.size() > 0){
			op_ord++;
			List<Integer> pivot = new ArrayList<Integer>();op_ord++; 
			pivot = A.get(0);op_ord++;
			
			List<List<Integer>> mayores = new ArrayList<List<Integer>>();op_ord++;
			List<List<Integer>> menores = new ArrayList<List<Integer>>();op_ord++;
			
			int i = 1;op_ord++;
			while(i < A.size()){
				op_ord++;
				if (valor(A.get(i)) >= valor(pivot)){
					op_ord++;
					mayores.add(A.get(i));op_ord++;
				} else {
					op_ord++;
					menores.add(A.get(i));op_ord++;
				}
				i++;op_ord++;
			}
			
			if(mayores.size() > 0){
				op_ord++;
				ret.addAll(OrdenarQS(mayores));op_ord++;
			}
			
			ret.add(pivot);op_ord++;
			
			if(menores.size() > 0){
				op_ord++;
				ret.addAll(OrdenarQS(menores));op_ord++;
			}
		} else {
			op_ord++;
			ret = A;op_ord++;
		}
		
		op_ord++;
		return ret;
		
	}
	
	public static class Datos
	{
		private List<Integer> S;
		private List<Integer> T;
		
		public Datos() {
			super();
			S = new ArrayList<Integer>();
			T = new ArrayList<Integer>();
		}
	}
	
	private static class Instancia
	{
		Datos Datos;
		Integer n;
	}
	
	public static class Parser
	{
		static String fs = System.getProperty("file.separator");
		
		public static List<Instancia> Leer(String ruta)
		{
			List<Instancia> ret = new ArrayList<Instancia>();	
			ruta = System.getProperty("java.class.path") + System.getProperty("file.separator") + fs + "tp" + fs + "in" + fs + ruta;
			Integer actual;
		    Instancia temporal;
		    Datos temp;
			
		    try
		    {
		    	
		        BufferedReader in = new BufferedReader(new FileReader(ruta));
		        
    	        while ((actual = Integer.valueOf(in.readLine().trim())) != 0){
		        	
			        Integer n = actual;
			        temp = new Datos();
			        
			        for(int i = 0; i < n; ++i)
			        {			        	
			        	temp.S.add(Integer.valueOf(in.readLine().trim()));
			        }
			        
			        for(int i = 0; i < n; ++i)
			        {
			        	temp.T.add(Integer.valueOf(in.readLine().trim()));
			        }
			        
			        temporal = new Instancia();
			        temporal.Datos = temp;
			        temporal.n = actual;
			        
			        ret.add(temporal);
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
		
		public static void Escribir(String ruta, int n,  List<List<Integer>> valores)
		{
			ruta = System.getProperty("java.class.path") + System.getProperty("file.separator") + fs + "tp" + fs + "out" + fs + ruta;
			
			try
			{
				BufferedWriter out = new BufferedWriter(new FileWriter(ruta,true));
		        String salida;
		        salida = "";
		        	        
		        for(List<Integer> val : valores)
		        {
		        	salida += Integer.toString(val.get(0)) + " " + Integer.toString(val.get(1)) + "\n";
		        }
				salida += "0\n";
		        
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
			ruta = System.getProperty("java.class.path") + fs + "tp" + fs + "dat" + fs + ruta;
			
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
		
		public static void AgregarValor(String ruta, Integer valor, Boolean agregar)
		{
			ruta = System.getProperty("java.class.path") + fs + "tp" + fs + "out" + fs + ruta;
			
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

		
	}

}
