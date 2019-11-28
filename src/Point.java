

class Point implements Comparable, PointInterface{

	float X,Y,Z;
	ArrayList<Point> vertexNeighbours;
	ArrayList<Triangle> triangleNeighbours;
	Point(float X,float Y, float Z)
	{
		this.X=X;
		this.Y=Y;
		this.Z=Z;
		vertexNeighbours=new ArrayList();
		triangleNeighbours=new ArrayList();
	}
	
	@Override
	public float getX() {
		
		return X;
		// TODO Auto-generated method stub
	
	}

	@Override
	public float getY() {
		// TODO Auto-generated method stub
		return Y;
	}

	@Override
	public float getZ() {
		// TODO Auto-generated method stub
		return Z;
	}

	@Override
	public float[] getXYZcoordinate() {
		float[] a=new float[3];
		
		a[0]=X;
		a[1]=Y;
		a[2]=Z;
		
		// TODO Auto-generated method stub
		return a;
	}
	
	public ArrayList<Point> getVertexNeighbours()
	{
		return vertexNeighbours;
	}
	public ArrayList<Triangle> getTriangleNeighbours()
	{
		return triangleNeighbours;
	}
	
	public String toString()
	{
		return Float.toString(X)+", "+Float.toString(Y)+", "+Float.toString(Z);
	}
	
	public int compareTo(Point point)
	{
		if(point.getX()==X && point.getY()==Y && point.getZ()==Z)
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
