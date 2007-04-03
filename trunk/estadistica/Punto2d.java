package estadistica;

public class Punto2d
{
	public Long x,y;
	
	public Punto2d(Long x, Long y)
	{
		this.x = x;
		this.y = y;
	}
	
	public String toString()
	{
		return x + " " + y;
	}
}
