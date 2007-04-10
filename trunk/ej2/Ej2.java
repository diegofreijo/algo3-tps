package tp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;



public class Ej2
{
	private static Integer cantOp;
	
	public static void Ejecutar()
	{
		System.out.println("Ejecutando Ej2:");
		System.out.println("===============");

		List<Datos> paresEnemistados = Parser.Leer("Tp1Ej2.in");
		
		List<Integer> ListaDeResultados = new LinkedList<Integer>();
		Integer cantInvitados = 0;
		
		int j = 0;
		for(Datos i : paresEnemistados)
		{	
			++j;
			cantInvitados = TimeForParty(i);
			
			System.out.println("Cantidad de Invitados para el caso " + j + ": " + cantInvitados.toString());
			System.out.println("--------------------------------------------------------------------------");
			
			ListaDeResultados.add(cantInvitados);

		}
		Parser.Escribir("Tp1Ej2.out", ListaDeResultados);
		
		System.out.println("Escribi en el archivo de salida :)");
	}

	public static void EjecutarCantOp()
	{
		System.out.println("Contando Operaciones Ej2:");
		System.out.println("=========================");

		List<Datos> paresEnemistados = Parser.Leer("Tp1Ej2.in");
		
		List<Integer> ListaDeCantOp = new LinkedList<Integer>();
		Integer cantInvitados = 0;
		
		int j = 0;
		for(Datos i : paresEnemistados)
		{	
			++j;
			cantInvitados = TimeForParty(i);
			
			System.out.println("Cantidad de Operaciones para el caso " + j + ": " + cantOp);
			System.out.println("--------------------------------------------------------------------------");
			
			ListaDeCantOp.add(i.n);
			ListaDeCantOp.add((Integer)cantOp);
		}

		Parser.Escribir2("Tp1Ej2.dat", ListaDeCantOp);
		
		System.out.println("Escribi en el archivo de salida :)");
	}
	
	private static class Datos
	{
		public Integer n;
		public Integer m;
		public List<List<Integer>> paresEnemistados; 
	}
	
	private static class Parser
	{
		static String fs = System.getProperty("file.separator");
		
		public static List<Datos> Leer(String ruta)
		{
			List<Datos> ret = new ArrayList<Datos>();
			ruta = System.getProperty("java.class.path") + fs + "ej2" + fs + "in" + fs + ruta;
			
			try
		    {
		        BufferedReader in = new BufferedReader(new FileReader(ruta));
		        List<Integer> linea = new ArrayList<Integer>();

		        linea = LeerLinea(in.readLine().trim());
		        
		        do
		        {
		        	Datos instancia = new Datos();

			        instancia.n = linea.get(0);
			        instancia.m = linea.get(1);
			        instancia.paresEnemistados = new LinkedList<List<Integer>>();
			        
					for(int i = 0; i < instancia.m; ++i)
			        {
			        	linea = LeerLinea(in.readLine().trim());
			        	
			        	instancia.paresEnemistados.add(linea);
			        }
			        
			        ret.add(instancia);
			        
			        linea = LeerLinea(in.readLine().trim());
			        
		        }while(linea.get(0) != 0);
		        
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
	
		public static void Escribir(String ruta, List<Integer> tInst)
		{
			ruta = System.getProperty("java.class.path") + fs + "ej2" + fs + "out" + fs + ruta;

			try
			{
				BufferedWriter out = new BufferedWriter(new FileWriter(ruta));
		        String salida;
		        
		        salida = Integer.toString(tInst.size()) + '\n';
		        
		        for(int i : tInst)
		        {
		        	salida += Integer.toString(i) + '\n';	        
		        }
		        
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
		
		public static void Escribir2(String ruta, List<Integer> tInst)
		{
			ruta = System.getProperty("java.class.path") + fs + "ej2" + fs + "dat" + fs + ruta;

			try
			{
				BufferedWriter out = new BufferedWriter(new FileWriter(ruta));
				String salida = "";
		        
		        int tam = tInst.size();
		        for(int i = 0; i < tam; ++i)
		        {
		        	salida += Integer.toString(tInst.get(i)) + " ";
		        	salida += Integer.toString(tInst.get(i+1)) + '\n';
		        	++i;
		        }
		        
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
	

	private static Integer TimeForParty(Datos dato)
	{	
		cantOp = 0;
		
		List<Integer> listaProblematicos = new LinkedList<Integer>();	 ++cantOp;
		Integer invitados = 0;											 ++cantOp;
			
		for(int h = 1; h <= dato.n; ++h)
		{																 ++cantOp;
			if(EstaEnAlgunPar(h, dato.paresEnemistados))
			{
				listaProblematicos.add(h);							 	 ++cantOp;
			}
			else
			{
				invitados++;											 ++cantOp;
			}
		}
			
		boolean[][] matriz = new boolean[dato.n + 1][dato.n + 1];		 cantOp += (dato.n+1)*(dato.n+1);

		for(int i = 0; i < dato.m; ++i)
		{																 ++cantOp;
			matriz[dato.paresEnemistados.get(i).get(0)][dato.paresEnemistados.get(i).get(1)] = true; ++cantOp;
			matriz[dato.paresEnemistados.get(i).get(1)][dato.paresEnemistados.get(i).get(0)] = true; ++cantOp;
			
		}
		
		int temp = listaProblematicos.size();							 cantOp += temp;
		List<Integer> lPQueridos = new LinkedList<Integer>();			 ++cantOp;
		List<Integer> paraSumar =  new LinkedList<Integer>();			 ++cantOp;
		int mayor = 0;													 ++cantOp;
		int mayorAnt= 0;												 ++cantOp;
		
		for(int i = 0; i < temp; ++i)
		{																 ++cantOp;
			if((temp - i) > mayorAnt)
			{															 ++cantOp;
				mayor = MasQueridos(matriz, listaProblematicos,lPQueridos, paraSumar, i);
																		 ++cantOp;					
				if(mayor > mayorAnt)
				{														 ++cantOp;
					mayorAnt = mayor;									 ++cantOp;
				}
			}
			else
			{															 ++cantOp;
				break;
			}
		}
		
		invitados += mayorAnt;											 ++cantOp;
																		 ++cantOp;
		return invitados;
	}

	private static boolean EstaEnAlgunPar(int h, List<List<Integer>> pE)
	{
		boolean ret = false;							++cantOp;

		for(List<Integer> k : pE)
		{												++cantOp;
			if( h == k.get(0) || h == k.get(1))			++cantOp;++cantOp;++cantOp;
			{
				ret = true;								++cantOp;++cantOp;
				break;
			}
		}												++cantOp;

		return ret;
	}

	private static Integer MasQueridos(boolean[][] matriz, List<Integer> lP, List<Integer> aCompletar, List<Integer> /*Integer*/ res, int n)
	{

		int tam = lP.size();														cantOp += tam;
		aCompletar.add(lP.get(n));													++cantOp;
		
		for(int k = n + 1; k < tam; ++k)
		{	
			if(!TieneEnemigos(lP.get(k),aCompletar,matriz) && (tam-(k)+ aCompletar.size()) > Maximo(res))
			{	
				List<Integer> aCompletar2 = new LinkedList<Integer>(aCompletar);	cantOp += aCompletar.size();

				MasQueridos(matriz, lP, aCompletar2, res, k);					
			}
		}
		res.add(aCompletar.size());													cantOp += aCompletar.size();
		aCompletar.clear();															++cantOp;

		int ret = Maximo(res);														++cantOp;

		return ret;
	}

	private static boolean TieneEnemigos(Integer enDuda, List<Integer> aCompletar, boolean[][] matriz)
	{
		boolean ret = false;								++cantOp;
		
		for(int i : aCompletar)
		{													++cantOp;
			if(matriz[enDuda][i])
			{												++cantOp;
				ret = true;									++cantOp;++cantOp;
				break;
			}
		}													++cantOp;
		return ret;
	}

	private static int Maximo(List<Integer> res)
	{	
		int ret = 0;										++cantOp;
		for(int j : res)
		{													++cantOp;
			if(ret < j)
			{												++cantOp;
				ret = j;									++cantOp;
			}
		}
															++cantOp;
		return ret;
	}
	
}

	
	