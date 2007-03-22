package tp;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

public abstract class Parser
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
	
	public static boolean Escribir(String ruta, int n,  List<Integer> valores)
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
		
		return true;
	}

}
