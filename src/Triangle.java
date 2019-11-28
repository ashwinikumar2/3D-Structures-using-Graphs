
public class Triangle implements Comparable,  TriangleInterface  {

	Point point1,point2,point3;
	public int insertionTime;
	public Edge edge1, edge2, edge3;
	boolean vis;
	Triangle(Point point1, Point point2, Point point3)
	{
		insertionTime=0;
		this.point1=point1;
		this.point2=point2;
		this.point3=point3;
		edge1=new Edge(point1, point2);
		edge2=new Edge(point1, point3);
		edge3=new Edge(point2, point3);
		vis=false;
	}
	
	public ArrayList<Triangle> getTriangleEdge1()
	{
		return edge1.getTriangles();
	}
	public ArrayList<Triangle> getTriangleEdge2()
	{
		return edge2.getTriangles();
	}
	public ArrayList<Triangle> getTriangleEdge3()
	{
		return edge3.getTriangles();
	}
	@Override
	public PointInterface[] triangle_coord() {
		PointInterface[] a=new PointInterface[3];
		
		a[0]=point1;
		a[1]=point2;
		a[2]=point3;
		// TODO Auto-generated method stub
		return a;
	}
	
	public boolean isVisited()
	{
		return vis;
	}
	public int getInsertionTime()
	{
		return insertionTime;
	}
	public String toString()
	{
		return "["+point1.getX()+","+point1.getY()+","+point1.getZ()+"] , ["+point2.getX()+","+point2.getY()+","+point2.getZ()+"] , ["+point3.getX()+","+point3.getY()+","+point3.getZ()+"]";
	}
	
	public int compareAccordingToInsertionTime(Triangle triangle)
	{
		if(insertionTime<triangle.getInsertionTime())
		{
			return -1;
		}
		else if(insertionTime>triangle.getInsertionTime())
		{
			return 1;
		}
		else 
			return 0;
	}
	public int compareTo(Triangle triangle)
	{
		if(triangle.point1.compareTo(point1)==0 && triangle.point2.compareTo(point2)==0 && triangle.point3.compareTo(point3)==0)
		{
			return 0;
			
		}
		else
			return -1;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
