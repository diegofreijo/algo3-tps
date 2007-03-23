package tp;

public class Matriz
{
	private int[][] matriz;
	private int k;
	
	public Matriz(int tam)
	{
		k = tam;
		matriz = new int[k][k];
	}
	
	public Matriz(Matriz a)
	{
		k = a.Tam();
		matriz = new int[k][k];
		
		for(int i = 0; i < k; ++i)
		{
			for(int j = 0; j < k; ++j)
			{
				matriz[i][j] = a.Leer(i,j);
			}
		}
	}
	
	public Matriz Potenciar(int n)
	{
		Matriz ret;
		
		if(n <= 0)
		{
			ret = new Matriz(k);
			ret.Identidad();
		}
		else
		{
			ret = new Matriz(this);
			Matriz pot2 = new Matriz(this);
			--n;
			
			while(n >= 1)
			{
				if(n % 2 == 0)
				{
					n /= 2;
				}
				else
				{
					--n;
					n /= 2;
					ret = ret.Multiplicar(pot2);
				}
				pot2 = pot2.Multiplicar(pot2);
			}
			
		}	
		
		return ret;
	}
	
	public void Identidad()
	{
		for(int i = 0; i < k; ++i)
		{
			for(int j = 0; j < k; ++j)
			{
				if(i == j)
				{
					matriz[i][i] = 1;
				}
				else
				{
					matriz[i][j] = 0;
				}
			}
		}
	}

	public Matriz Multiplicar(Matriz b)
	{
		Matriz ret = new Matriz(k);
		int valor;
		
		for(int i = 0; i < k; ++i)
		{
			for(int j = 0; j < k; ++j)
			{
				valor = 0;
				for(int t = 0; t < k; ++t)
				{
					valor += this.Leer(i,t) * b.Leer(t,j);
				}
				ret.Escribir(i,j,valor);
			}
		}
		
		return ret;
	}
	
	public void Escribir(int i, int j, int valor)
	{
		matriz[i][j] = valor;
	}

	public int Leer(int i, int j)
	{
		return matriz[i][j];
	}

	public int Tam()
	{
		return k;
	}
	
	public String toString()
	{
		String ret = "";
		for(int i = 0; i < k; ++i)
		{
			for(int j = 0; j < k; ++j)
			{
				ret += matriz[i][j] + "	";
			}
			ret += "\n";
		}
		
		return ret;		
	}
	
}
