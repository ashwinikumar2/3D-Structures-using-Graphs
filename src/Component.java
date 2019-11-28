

public class Component implements Comparable {

	public ArrayList<Triangle> triangles;
	Component()
	{
		triangles=new ArrayList<Triangle>();
	}
	
	public void add(Triangle triangle)
	{
		Point point1=triangle.point1;
		Point point2=triangle.point2;
		Point point3=triangle.point3;
		if(!contains(triangle))
		{
			int p1=0,p2=0,p3=0,index1=-1,index2=-1,index3=-1;
			
			Triangle t=new Triangle(point1, point2, point3);
			for(int i=0;i<triangles.size();i++)
			{
	//			if(t.compareTo(triangles.get(i))==0 || t2.compareTo(triangles.get(i))==0 || t3.compareTo(triangles.get(i))==0 ||t4.compareTo(triangles.get(i))==0 || t5.compareTo(triangles.get(i))==0 ||t6.compareTo(triangles.get(i))==0)
	//			{
	//				x4=1;
	//				break;
	//			}
//				System.out.println("Triangle is "+triangles.get(i));
				if(triangles.get(i).point1.compareTo(point1)==0  )
				{
					p1=1;
					index1=i;
				}
				if(triangles.get(i).point1.compareTo(point2)==0)
				{
					index2=i;
					p2=1;
				}
				if(triangles.get(i).point1.compareTo(point3)==0)
				{
					index3=i;
					p3=1;
				}
				if(triangles.get(i).point2.compareTo(point1)==0 )
				{
					index1=i;
					p1=2;
				}
				if(triangles.get(i).point2.compareTo(point2)==0)
				{
					index2=i;
					p2=2;
				}
				if(triangles.get(i).point2.compareTo(point3)==0)
				{
					index3=i;
					p3=2;
				}
				if(triangles.get(i).point3.compareTo(point1)==0)
				{
					index1=i;
					p1=3;
					
				}
				if(triangles.get(i).point3.compareTo(point2)==0)
				{
					index2=i;
					p2=3;
				}
				if(triangles.get(i).point3.compareTo(point3)==0)
				{
					index3=i;
					p3=3;
				}
			}
			
//			else if(((p1>0 && p2>0 && p3>0) && ((index1==index2) || index2==index3 ||index1==index3) ))
//			if(p1+p2+p3>=2 )
//			if(((p1>0 && p2>0 && p3==0 && index1==index2) || (p1>0 && p3>0 && p2==0 && index1==index3) || (p2>0 && p3>0 && p1==0 && index3==index2) ) || ((p1>0 && p2>0 && p3>0) && ((index1==index2) || index2==index3 ||index1==index3) ) )	
				if(((p1>0 && p2>0 && p3==0 ) || (p1>0 && p3>0 && p2==0 ) || (p2>0 && p3>0 && p1==0) ) ||((p1>0 && p2>0 && p3>0) ))
			{
				if(p1>0)
				{
					if(p1==1)
					{
					
					triangles.get(index1).point1.triangleNeighbours.add(t);
					t.point1=triangles.get(index1).point1;
					}
					if(p1==2)
					{
					
					triangles.get(index1).point2.triangleNeighbours.add(t);
					t.point1=triangles.get(index1).point2;
					}
					if(p1==3)
					{
						
						triangles.get(index1).point3.triangleNeighbours.add(t);
						t.point1=triangles.get(index1).point3;
					}
				}
				if(p2>0)
				{
					if(p2==1)
					{
						
						triangles.get(index2).point1.triangleNeighbours.add(t);
						t.point2=triangles.get(index2).point1;
					}
					if(p2==2)
					{
					
					triangles.get(index2).point2.triangleNeighbours.add(t);
					t.point2=triangles.get(index2).point2;
					}
					if(p2==3)
					{
					
					triangles.get(index2).point3.triangleNeighbours.add(t);
					t.point2=triangles.get(index2).point3;
					}
				}
				if(p3>0)
				{
					if(p3==1)
					{
						
						triangles.get(index3).point1.triangleNeighbours.add(t);
						t.point3=triangles.get(index3).point1;
					}
					if(p3==2)
					{
						
						triangles.get(index3).point2.triangleNeighbours.add(t);
						t.point3=triangles.get(index3).point2;
					}
					if(p3==3)
					{	
						
						triangles.get(index3).point3.triangleNeighbours.add(t);
						t.point3=triangles.get(index3).point3;
					}
				
				}
				triangles.add(t);
				
			}
			else if(p1==0 && p2==0 && p3==0)
			{
				triangles.add(triangle);
			}
		}
		
	}
	
	public boolean contains(Triangle triangle)		//for triangle already existing
	{
		Point point1=triangle.point1;
		Point point2=triangle.point2;
		Point point3=triangle.point3;
		
		Triangle t=new Triangle(point1, point2, point3);
		Triangle t2=new Triangle(point2, point3, point1);
		Triangle t3=new Triangle(point3, point1, point2);
		Triangle t4=new Triangle(point1, point3, point2);
		Triangle t5=new Triangle(point2, point1, point3);
		Triangle t6=new Triangle(point3, point2, point1);
		int x4=0;
		for(int i=0;i<triangles.size();i++)
		{
			if(t.compareTo(triangles.get(i))==0 || t2.compareTo(triangles.get(i))==0 || t3.compareTo(triangles.get(i))==0 ||t4.compareTo(triangles.get(i))==0 || t5.compareTo(triangles.get(i))==0 ||t6.compareTo(triangles.get(i))==0)
			{
				x4=1;
				break;
			}
		}
		
		if(x4==0)
			return false;
		else return true;
	}
	
	
	public boolean belongsTo(Triangle triangle) 	//for new triangle
	{
		Point point1=triangle.point1;
		Point point2=triangle.point2;
		Point point3=triangle.point3;
		if(!contains(triangle))
		{
			int p1=0,p2=0,p3=0,index1=-1,index2=-1,index3=-1;
			
			for(int i=0;i<triangles.size();i++)
			{
	//			if(t.compareTo(triangles.get(i))==0 || t2.compareTo(triangles.get(i))==0 || t3.compareTo(triangles.get(i))==0 ||t4.compareTo(triangles.get(i))==0 || t5.compareTo(triangles.get(i))==0 ||t6.compareTo(triangles.get(i))==0)
	//			{
	//				x4=1;
	//				break;
	//			}
//				System.out.println("Triangle is "+triangles.get(i));
				if(triangles.get(i).point1.compareTo(point1)==0  )
				{
//					System.out.println("value of p1=1 set");
					p1=1;
					index1=i;
				}
				if(triangles.get(i).point1.compareTo(point2)==0)
				{
//					System.out.println("value of p2=1 set");
					index2=i;
					p2=1;
				}
				if(triangles.get(i).point1.compareTo(point3)==0)
				{
//					System.out.println("value of p3=1 set");
					index3=i;
					p3=1;
				}
				if(triangles.get(i).point2.compareTo(point1)==0 )
				{
//					System.out.println("value of p1=2 set");
					index1=i;
					p1=2;
				}
				if(triangles.get(i).point2.compareTo(point2)==0)
				{
//					System.out.println("value of p2=2 set");
					index2=i;
					p2=2;
				}
				if(triangles.get(i).point2.compareTo(point3)==0)
				{
//					System.out.println("value of p3=2 set");
					index3=i;
					p3=2;
				}
				if(triangles.get(i).point3.compareTo(point1)==0)
				{
//					System.out.println("value of p1=3 set");
					index1=i;
					p1=3;
					
				}
				if(triangles.get(i).point3.compareTo(point2)==0)
				{
//					System.out.println("value of p2=3 set");
					index2=i;
					p2=3;
				}
				if(triangles.get(i).point3.compareTo(point3)==0)
				{
//					System.out.println("value of p3=3 set");
					index3=i;
					p3=3;
				}
			}
//			System.out.println("value of p1= "+p1);
//			System.out.println("value of p2= "+p2);
//			System.out.println("value of p3= "+p3);
//			if(p1+p2+p3>=2 )
//			if(((p1>0 && p2>0 && p3==0 && index1==index2) || (p1>0 && p3>0 && p2==0 && index1==index3) || (p2>0 && p3>0 && p1==0 && index3==index2) ) )		
			if(((p1>0 && p2>0 && p3==0 ) || (p1>0 && p3>0 && p2==0 ) || (p2>0 && p3>0 && p1==0) ) )			
				return true;
			else 
//				if(((p1>0 && p2>0 && p3>0) && ((index1==index2) || index2==index3 ||index1==index3) ))
					if(((p1>0 && p2>0 && p3>0) ))
				return true;
			else return false;
		}
		else 
			return false;
		
	}
		
	public void merge(Component component)
	{
		if(triangles.size()!=0)
		{
			Triangle t=triangles.get(triangles.size()-1);
			if(component.belongsTo(t))
			{
			component.add(t);
			
			for(int i=0;i<component.triangles.size();i++)
			{
				if(component.triangles.get(i).compareTo(t)!=0)
				{
					triangles.add(component.triangles.get(i));
				}
			}
			
			}
		}
	}
	
	public String toString()
	{
		for(int i=0;i<triangles.size();i++)
		{
			System.out.println("             "+triangles.get(i)+" isVisited= "+triangles.get(i).isVisited());
		}
		return "";
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
