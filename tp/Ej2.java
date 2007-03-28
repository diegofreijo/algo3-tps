package tp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class Ej2
{
	public static void Ejecutar()
	{
		System.out.println("Ejecutando Ej2:");
		System.out.println("===============");
		
		List<Datos> paresEnemistados = Parser.Leer("Tp1Ej2.in");
		
		List<Integer> cantInvitados = TimeForParty(paresEnemistados);
		
		System.out.println("Habra esta cantidad de invitados: " + cantInvitados);

		Parser.Escribir("Tp1Ej2.out", cantInvitados);
		
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
		public static List<Datos> Leer(String ruta)
		{
			int tam = 200;
			List<Datos> ret = new ArrayList<Datos>(tam);
			ruta = System.getProperty("java.class.path") + System.getProperty("file.separator") + ruta;
			
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
			        instancia.paresEnemistados = new ArrayList<List<Integer>>(instancia.m);
			        
					for(int i = 0; i < instancia.m; ++i)
			        {
			        	linea = LeerLinea(in.readLine().trim());
			        	
			        	instancia.paresEnemistados.add(linea);
			        }
			        
			        ret.add(instancia);
			        
			        linea = LeerLinea(in.readLine().trim());
			        
		        }while(linea.get(0) != 0);
		        	
		        //if(Integer.valueOf(in.readLine()) != 0) throw new IOException("Falta el cero del final");
		        
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
			ruta = System.getProperty("java.class.path") + System.getProperty("file.separator") + ruta;
			
			try
			{
				BufferedWriter out = new BufferedWriter(new FileWriter(ruta));
		        String salida;
		        
		        salida = Integer.toString(tInst.size()) + '\n';
		        
		        for(int i = 0; i < tInst.size(); ++i)
		        {
		        	salida += Integer.toString(tInst.get(i)) + '\n';	        
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
	}

	private static List<Integer> TimeForParty(List<Datos> d)
	{	
		List<Integer> ret = new ArrayList<Integer>(d.size());
		
		for(int i = 0; i < d.size(); ++i)
		{
			List<Integer> listaProblematicos = new ArrayList<Integer>(d.get(i).n);
			Integer invitados = 0;
			
			for(int h = 1; h <= d.get(i).n; ++h)
			{				
				if(EstaEnAlgunPar(h, d.get(i).paresEnemistados))
				{
					listaProblematicos.add(h);
				}
				else
				{
					invitados++;
				}
			}
	
			List<Integer> lPQueridos = new ArrayList<Integer>(listaProblematicos.size());
			List<Integer> paraSumar =  new ArrayList<Integer>(listaProblematicos.size());
	
			invitados += MasQueridos(d.get(i).paresEnemistados, listaProblematicos,lPQueridos, paraSumar, 0);
			
			ret.add(invitados);
		}
		return ret;
	}
	
	private static boolean EstanLosPares(int k, List<Integer> Acompletar,List<List<Integer>> pE)
	{
		boolean res = false;
		
		for(int j = 0; j < Acompletar.size(); ++j)
		{
			if(EstaElPar(Acompletar.get(j), k, pE))
			{
				res = true;
				break;
			}
		}
		
		return res;
	}
	
	private static boolean EstaElPar(int h, int k, List<List<Integer>> pE)
	{
		boolean ret = false;
		
		for(int i = 0; i < pE.size(); ++i)
		{
			if( (h == pE.get(i).get(0) && k == pE.get(i).get(1)) || (h == pE.get(i).get(1) && k == pE.get(i).get(0)))
			{
				ret = true;
				break;
			}	
		}
		return ret;
	}
	
	private static boolean EstaEnAlgunPar(int h, List<List<Integer>> pE)
	{
		boolean ret = false;
	
		for(int k = 0; k < pE.size(); ++k)
		{	
			if( h == pE.get(k).get(0) || h == pE.get(k).get(1))
			{
				ret = true;
				break;
			}
		}
		return ret;
	}

	private static Integer MasQueridos(List<List<Integer>> pE, List<Integer> lP, List<Integer> Acompletar, List<Integer> res, int n)
	{
		for(int i = n; i < lP.size(); ++i)
		{
			Acompletar.add(lP.get(i));
			for(int k = i + 1; k < lP.size(); ++k)
			{
				if(!EstanLosPares(lP.get(k),Acompletar,pE))
				{
					MasQueridos(pE, lP, Acompletar, res, k);	
				}
			}
			res.add(Acompletar.size());

			Acompletar.clear();
		}
		
		int ret = 0;
		for(int j = 0; j < res.size(); ++j)
		{
			if(ret < res.get(j))
			{
				ret = res.get(j);
			}
		}
		
		return ret;
	}

}

	
	