package tp;

import java.util.ArrayList;
import java.util.List;

public abstract class Ej4_Pruebas
{
	public static void Probar()
	{
		System.out.println("Probando Ej4:");
		System.out.println("=============");
		
		List<Integer> factorizacion = new ArrayList<Integer>();
		Integer productoria;
		int errores = 0;
		
		for(int n = 2; n <= 1000000; ++n)
		{
			factorizacion = Ej4.Factorizacion(n);
			System.out.print(n + ":  " + factorizacion.toString());
			productoria = Probar_Productoria(factorizacion);
			if(n != productoria) 
			{
				++errores;
				System.out.println("	MAL!!!!! [" + errores + "]");
			}
			else
			{
				System.out.println("	BIEN!");
			}
		}
		System.out.println("Fin de las pruebas, errores: " + errores);
	}
	
	private static Integer Probar_Productoria(List<Integer> factorizacion)
	{
		Integer ret = 1;
		for(Integer i : factorizacion)
		{
			ret *= i;
		}
		return ret;
	}

	public static void ProbarPrimos()
	{
		System.out.println("Probando primos:");
		System.out.println("================");
		
		List<Integer> primos = new ArrayList<Integer>();
		
		for(int i = 2; i <= 55503787; ++i)
		{
			if(Ej4.EsPrimo(i,primos))
			{
				primos.add(i);
				System.out.println(i);
			}
		}
	}
}
