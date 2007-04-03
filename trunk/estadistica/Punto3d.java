package estadistica;

public class Punto3d
{
	public Long x,y,z;
	
	public Punto3d(Long x, Long y, Long z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public String toString()
	{
		return x + " " + y + " " + z;
	}
}
