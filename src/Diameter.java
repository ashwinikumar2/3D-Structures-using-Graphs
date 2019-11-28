
public class Diameter {

	public int value;
	public Triangle t1;
	public Triangle t2;
	Diameter(int value, Triangle t1, Triangle t2)
	{
		this.value=value;
		this.t1=t1;
		this.t2=t2;
	}
	
	public int value()
	{
		return value;
	}
	
	public Triangle getT1()
	{
		return t1;
	}
	
	public Triangle getT2()
	{
		return t2;
	}
}

