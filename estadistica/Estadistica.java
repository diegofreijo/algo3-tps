package estadistica;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public abstract class Estadistica
{
	static String fs = System.getProperty("file.separator");
	
	public static void GuardarDatos(String ruta, List valores)
	{
		try
		{
			BufferedWriter out = new BufferedWriter(new FileWriter(ruta, false));
	        
			for(Object p : valores)
			{
	        	out.write(p.toString() + "\n");
			}
	        out.close();
		}
		catch (IOException e)
		{
	    	System.out.println("Error escribiendo las estadisticas: ");
	    	e.printStackTrace();
		}
	}
}