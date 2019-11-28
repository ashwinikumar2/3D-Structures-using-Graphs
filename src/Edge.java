
public class Edge implements 	EdgeInterface {

	float X1;
	float Y1;
	float Z1;
	float X2;
	float Y2;
	float Z2;
	Point point1;
	Point point2;
	float dis=(X1-X2)*(X1-X2)+ (Y1-Y2)*(Y1-Y2)+ (Z1-Z2)*(Z1-Z2);
	public ArrayList<Triangle> triangles;
	Edge(Point point1, Point point2)
	{
		triangles=new ArrayList<Triangle>();
//		this.X1=X1;
//		this.Y1=Y1;
//		this.Z1=Z1;
//		this.X2=X2;
//		this.Y2=Y2;
//		this.Z2=Z2;
//		point1=new Point(X1, Y1, Z1);
//		point2=new Point(X2, Y2, Z2);
		this.point1=point1;
		this.point2=point2;
	}
	
	public Point getPoint1()
	{
		return point1;
	}
	public Point getPoint2()
	{
		return point2;
	}
	
	public int compareTo(Edge edge)
	{
		
		if(edge.getPoint1().compareTo(point1)==0 && edge.getPoint2().compareTo(point2)==0)
		{
			return 0;
		}
		else return -1;
	}
	public int compared(Edge edge)
	{
		Point p1=edge.point1;
		Point p2=edge.point2;
		float dis1=(p1.getX()-p2.getX())*(p1.getX()-p2.getX())+ (p1.getY()-p2.getY())*(p1.getY()-p2.getY())+ (p1.getZ()-p2.getZ())*(p1.getZ()-p2.getZ());
		if(dis==dis1)
		{
			return 0;
		}
		else if(dis<dis1)
		{
			return -1;
		}
		else
			return 1;
	}
	@Override
	public PointInterface[] edgeEndPoints() {
		PointInterface[] a=new PointInterface[2];
		
		a[0]=point1;
		a[1]=point2;
		
		
		// TODO Auto-generated method stub
		return a;
	}
	
	public ArrayList<Triangle> getTriangles()
	{
		return triangles;
	}
	
	public String toString()
	{
		return ("edge is (["+point1+"], ["+point2+"] )");
	}

	
	
}
