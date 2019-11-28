

public class Shape implements ShapeInterface
{
	Triangle Root;
	ArrayList<Point> points;
	ArrayList<Edge> edges;
	ArrayList<Triangle> triangles;
	ArrayList<Component> components;
	
	int insertedElements=0;
	Shape()

	{
		points=new ArrayList();
		edges=new ArrayList();
		triangles=new ArrayList();
		Root=null;
		components=new ArrayList<Component>();
	}
	
	public boolean isValid(Point p, Point q, Point r)	//COMPLETED
	{
		float x1=q.getX()-p.getX();
		float y1=q.getY()-p.getY();
		float z1=q.getZ()-p.getZ();
		
		float x2=r.getX()-p.getX();
		float y2=r.getY()-p.getY();
		float z2=r.getZ()-p.getY();
		
		float a1=y1*z2-z1*y2;
		float a2=x1*z2-z1*x2;
		float a3=x1*y2-y1*x2;
		
		float x=a1*a1+a2*a2+a3*a3;
		if(x<=0.000001)
		{
			return false;
		}
		else
			
		{
			return true;
		}
	}
	
	
	//INPUT [x1,y1,z1,x2,y2,z2,x3,y3,z3]
	public boolean ADD_TRIANGLE(float [] triangle_coord)	//COMPLETED
	{
//		System.out.println("asf");
//		System.out.println("size of coordinates array is "+triangle_coord.length);
		float X1=triangle_coord[0];
		float Y1=triangle_coord[1];
		float Z1=triangle_coord[2];
		float X2=triangle_coord[3];
		float Y2=triangle_coord[4];
		float Z2=triangle_coord[5];
		float X3=triangle_coord[6];
		float Y3=triangle_coord[7];
		float Z3=triangle_coord[8];
		
		Point point1=new Point(X1, Y1, Z1), point2=new Point(X2,Y2,Z2), point3=new Point(X3, Y3, Z3);
		
		
		
		if(isValid(point1, point2, point3)==true) 
		{
//			System.out.println("triangle is valid");
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
			
			if(x4==0)				//NEW TRIANGLE
			{
//				System.out.println("triangles list does not contain the triangle");
				insertedElements++;
				t.insertionTime=insertedElements;
				int p1=0,p2=0,p3=0;
				for(int i1=0;i1<points.size();i1++)
				{
					if(point1.compareTo(points.get(i1))==0)
					{
						p1++;
//						System.out.println("Point "+point1+" already exists in the list");
//						int i=points.indexOf(point1);
						
						int s2=0;
						int s3=0;
						for(int i3=0;i3<points.get(i1).getVertexNeighbours().size();i3++)
						{
							if(point2.compareTo(points.get(i1).getVertexNeighbours().get(i3))==0)
							{
								s2++;
							}
							if(point3.compareTo(points.get(i1).getVertexNeighbours().get(i3))==0)
							{
								s3++;
							}
						}
						if(s2==0)
						points.get(i1).vertexNeighbours.add(point2);
						if(s3==0)
						points.get(i1).vertexNeighbours.add(point3);
						points.get(i1).triangleNeighbours.add(t);
					}
					
					else if(point2.compareTo(points.get(i1))==0)
					{
						p2++;
//						int i=points.indexOf(point2);
						int s2=0;
						int s3=0;
						for(int i3=0;i3<points.get(i1).getVertexNeighbours().size();i3++)
						{
							if(point1.compareTo(points.get(i1).getVertexNeighbours().get(i3))==0)
							{
								s2++;
							}
							if(point3.compareTo(points.get(i1).getVertexNeighbours().get(i3))==0)
							{
								s3++;
							}
						}
						if(s2==0)
							points.get(i1).vertexNeighbours.add(point1);
						if(s3==0)
							points.get(i1).vertexNeighbours.add(point3);
						points.get(i1).triangleNeighbours.add(t);
					}
					else if(point3.compareTo(points.get(i1))==0)
					{
						p3++;
//						int i=points.indexOf(point3);
						int s2=0;
						int s3=0;
						for(int i3=0;i3<points.get(i1).getVertexNeighbours().size();i3++)
						{
							if(point2.compareTo(points.get(i1).getVertexNeighbours().get(i3))==0)
							{
								s2++;
							}
							if(point1.compareTo(points.get(i1).getVertexNeighbours().get(i3))==0)
							{
								s3++;
							}
						}
						if(s2==0)
							points.get(i1).vertexNeighbours.add(point2);
						if(s3==0)
							points.get(i1).vertexNeighbours.add(point1);
						points.get(i1).triangleNeighbours.add(t);
					}
				}
//				if(points.contains(point1))
//				{
//					System.out.println("Point "+point1+" already exists in the list");
//					int i=points.indexOf(point1);
//					points.get(i).vertexNeighbours.add(point2);
//					points.get(i).vertexNeighbours.add(point3);
//					points.get(i).triangleNeighbours.add(t);
//				}
				if(p1==0)
				{
					int s2=0;
					int s3=0;
					for(int i3=0;i3<point1.getVertexNeighbours().size();i3++)
					{
						if(point2.compareTo(point1.getVertexNeighbours().get(i3))==0)
						{
							s2++;
						}
						if(point3.compareTo(point1.getVertexNeighbours().get(i3))==0)
						{
							s3++;
						}
					}
					if(s2==0)
					point1.vertexNeighbours.add(point2);
					if(s3==0)
					point1.vertexNeighbours.add(point3);
					point1.triangleNeighbours.add(t);
					points.add(point1);
				}
				
				if(p2==0)
				{
					int s2=0;
					int s3=0;
					for(int i3=0;i3<point2.getVertexNeighbours().size();i3++)
					{
						if(point1.compareTo(point2.getVertexNeighbours().get(i3))==0)
						{
							s2++;
						}
						if(point3.compareTo(point2.getVertexNeighbours().get(i3))==0)
						{
							s3++;
						}
					}
					if(s2==0)
					point2.vertexNeighbours.add(point1);
					if(s3==0)
					point2.vertexNeighbours.add(point3);
					point2.triangleNeighbours.add(t);
					points.add(point2);
				}
//				else
//				{
//					int i=points.indexOf(point2);
//					points.get(i).vertexNeighbours.add(point1);
//					points.get(i).vertexNeighbours.add(point3);
//					points.get(i).triangleNeighbours.add(t);
//				}
				if(p3==0)
				{
					int s2=0;
					int s3=0;
					for(int i3=0;i3<point3.getVertexNeighbours().size();i3++)
					{
						if(point2.compareTo(point3.getVertexNeighbours().get(i3))==0)
						{
							s2++;
						}
						if(point1.compareTo(point3.getVertexNeighbours().get(i3))==0)
						{
							s3++;
						}
					}
					if(s2==0)
					point3.vertexNeighbours.add(point2);
					if(s3==0)
					point3.vertexNeighbours.add(point1);
					point3.triangleNeighbours.add(t);
					points.add(point3);
				}
//				else
//				{
//					int i=points.indexOf(point3);
//					points.get(i).vertexNeighbours.add(point2);
//					points.get(i).vertexNeighbours.add(point1);
//					points.get(i).triangleNeighbours.add(t);
//				}
				
				Edge e1=new Edge(point1, point2);
				Edge e11=new Edge(point2, point1);
				Edge e2=new Edge(point1, point3);
				Edge e22=new Edge(point3,point1);
				Edge e3=new Edge(point2, point3);
				Edge e33=new Edge(point3, point2);
				
//				System.out.println("e1= "+e1);
//				System.out.println("e2= "+e2);
//				System.out.println("e3= "+e3);
				
				int Edge1=0, Edge2=0, Edge3=0;
				
				for(int j=0;j<edges.size();j++)
				{
//					System.out.println("Edge to be checked is "+edges.get(j));
					if(edges.get(j).compareTo(e1)==0 || edges.get(j).compareTo(e11)==0)
					{
//						System.out.println("Matched with "+e1);
						Edge1++;
//						for(int j1=0;j1<edges.get(j).getTriangles().size();j1++)
//						{
//							t.edge1.triangles.add(edges.get(j).getTriangles().get(j1));
//							t.edge1.triangles.add(t);
//						}
						edges.get(j).triangles.add(t);
//						System.out.println(edges.get(j).getTriangles().get(edges.get(j).getTriangles().size()-1)+" has been added to "+edges.get(j));
					}
					if(edges.get(j).compareTo(e2)==0 || edges.get(j).compareTo(e22)==0)
					{
//						System.out.println("Matched with "+e2);
						Edge2++;
//						for(int j1=0;j1<edges.get(j).getTriangles().size();j1++)
//						{
//							t.edge2.triangles.add(edges.get(j).getTriangles().get(j1));
//							t.edge2.triangles.add(t);
//						}
						edges.get(j).triangles.add(t);
						
					}
					if(edges.get(j).compareTo(e3)==0 || edges.get(j).compareTo(e33)==0)
					{
//						System.out.println("Matched with "+e3);
						Edge3++;
//						for(int j1=0;j1<edges.get(j).getTriangles().size();j1++)
//						{
//							t.edge3.triangles.add(edges.get(j).getTriangles().get(j1));
//							t.edge3.triangles.add(t);
//						}
						edges.get(j).triangles.add(t);
//						System.out.println(edges.get(j).getTriangles().get(edges.get(j).getTriangles().size()-1)+" has been added to "+edges.get(j));
					}
					
				}
				
				
				if(Edge1==0  )
				{
					e1.triangles.add(t);
					
					edges.add(e1);
//					System.out.println("A new edge"+e1+" has been created ");
				}
				
				if(Edge2==0)
				{
					e2.triangles.add(t);
					edges.add(e2);
//					System.out.println("A new edge"+e2+" has been created ");
				}
				if(Edge3==0)
				{
					e3.triangles.add(t);
					edges.add(e3);
//					System.out.println("A new edge"+e3+" has been created ");
				}
				int x5=0;
				ArrayList<Component> c=new ArrayList<Component>();
				for(int j4=0;j4<components.size();j4++)
				{
//					System.out.println("component is ");
//					System.out.println(components.get(j4));
					if(!components.get(j4).contains(t))
					{
//						System.out.println("component does not contain the triangle");
						if(components.get(j4).belongsTo(t))
						{
//							System.out.println("component can contain the triangle");
						
							x5++;
							c.add(components.get(j4));
						}
					}
				}
//				System.out.println("value of x5 "+x5);
				
				if(x5==0)
				{
					Component c1=new Component();
					c1.add(t);
					components.add(c1);
				}
				else
				{
					Triangle T=t;
					c.get(0).add(T);;
					Component y=c.get(0);
					
					for(int i=1;i<c.size();i++)
					{
						y.merge(c.get(i));
//						y=c.get(i);
					}
					
					for(int i1=1;i1<c.size();i1++)
					{
						components.remove(c.get(i1));
						
					}
						
					
				}
				
				
				triangles.add(t);
				
//				for(int k1=0;k1<edges.size();k1++)
//				{
//					System.out.println(edges.get(k1)+" has triangle list as: ");
//					for(int i=0;i<edges.get(k1).getTriangles().size();i++)
//					{
//						System.out.println("                  "+edges.get(k1).getTriangles().get(i));
//					}
//				}
				if(triangles.contains(t))
				{
//					System.out.println("triangles list contains the given triangle now "+t);
				}
//				for(int j=0;j<triangles.size();j++)
//				{
//					System.out.println(triangles.get(j));
//				}
				
			}
//			System.out.println("triangles list is now: ");
//			for(int i=0;i<triangles.size();i++)
//			{
//				System.out.println(i+"th element of triangles is "+triangles.get(i));
//			}
//			System.out.println("");
//			for(int i4=0;i4<triangles.size();i4++)
//			{
//				System.out.println("The triangles in edges of the triangle "+triangles.get(i4) +" are:");
//				System.out.println("       Edge1: ");
//				for(int i5=0;i5<triangles.get(i4).getTriangleEdge1().size();i5++)
//				{
//					System.out.println("                    "+triangles.get(i4).getTriangleEdge1().get(i5));
//				}
//				System.out.println("       Edge2: ");
//				for(int i5=0;i5<triangles.get(i4).getTriangleEdge2().size();i5++)
//				{
//					System.out.println("                    "+triangles.get(i4).getTriangleEdge2().get(i5));
//				}
//				System.out.println("       Edge3: ");
//				for(int i5=0;i5<triangles.get(i4).getTriangleEdge3().size();i5++)
//				{
//					System.out.println("                    "+triangles.get(i4).getTriangleEdge3().get(i5));
//				}
//			}
			
//			for(int j1=0;j1<points.size();j1++)
//			{
//				System.out.println("Point is "+points.get(j1));
//				for(int j2=0;j2<points.get(j1).getTriangleNeighbours().size();j2++)
//				{
//					System.out.println("                      "+j2+"th element of triangles list in the point is "+points.get(j1).getTriangleNeighbours().get(j2));
//				}
//				System.out.println("");
//			}
//			for(int j1=0;j1<components.size();j1++)
//			{
//				System.out.println(j1+"th element of components is ");
//				System.out.println(components.get(j1));
//			}
			return true;
		}
		else {
//			System.out.println("triangles list is now: ");
//			for(int i=0;i<triangles.size();i++)
//			{
//				System.out.println(i+"th element of triangles is "+triangles.get(i));
//			}
//			System.out.println("");
//			for(int j1=0;j1<points.size();j1++)
//			{
//				System.out.println("Point is "+points.get(j1));
//				for(int j2=0;j2<points.get(j1).getTriangleNeighbours().size();j2++)
//				{
//					System.out.println("                      "+j2+"th element of triangles list in the point is "+points.get(j1).getTriangleNeighbours().get(j2));
//				}
//				System.out.println("");
//			}
			return false;
			
		}
	}

	public int TYPE_MESH() 			//COMPLETED
	{
		int twoTriangleEdges=0;
		int oneTriangleEdges=0,moreEdges=0, zeroTriangles=0;
		for(int i=0;i<edges.size();i++)
		{
//			System.out.println(edges.get(i));
//			System.out.println("no. of triangles in this edge is "+edges.get(i).getTriangles().size());
			int x=edges.get(i).getTriangles().size();
			if(x==2)
			{
				twoTriangleEdges++;
			}
			if(x==1)
			{
				oneTriangleEdges++;
			}
			if(x>2)
			{
				moreEdges++;
			}
			if(x==0)
			{
				zeroTriangles++;
			}
		}
		
		if(twoTriangleEdges==edges.size() && oneTriangleEdges==0)
		{return 1;}
		else if(oneTriangleEdges>0 && moreEdges==0)
		{return 2;}
		else 
		return 3;
	
	}

	//
	public EdgeInterface [] BOUNDARY_EDGES()  //PLS CHECK //COMPLETED
	{
		int x=0;
		ArrayList<Edge> e=new ArrayList<Edge>();
		
		for(int i=0;i<edges.size();i++)
		{
			if(edges.get(i).getTriangles().size()==1)
			{
				x++;
				e.add(edges.get(i));
			}
		}
//		if(e.size()==0) {
//			System.out.println("afaaaaaaaaaaaaaaa");
//			return null;
//			
//		}
		
		if(e.size()!=0)
		{
			
			int size1=0;
			for(int j1=0;j1<e.size();j1++)
			{
				if(e.get(j1)!=null)
				{
					size1++;
				}
			}
			
			Edge[] E=new Edge[size1];
			int i1=0;
			for(int j=0;j<e.size();j++)						//COPY ARRAYLIST TO ARRAY
			{
				if(e.get(j)!=null)
				{
				
				E[i1]=e.get(j);
				i1++;
				}
			}
			
			ArrayList<Edge> ed=new ArrayList();
//			for(int j7=0;j7<E.length;j7++)
//			{
//				System.out.println("for "+E[j7]);
//				Point p1=E[j7].point1;
//				Point p2=E[j7].point2;
//				float dis=(p1.getX()-p2.getX())*(p1.getX()-p2.getX())+ (p1.getY()-p2.getY())*(p1.getY()-p2.getY())+ (p1.getZ()-p2.getZ())*(p1.getZ()-p2.getZ());
//				
//			}
			for(int i2=0;i2<E.length-1;i2++)			//SELECTION SORT
			{

				Point p1=E[i2].point1;
				Point p2=E[i2].point2;
				float dis=(p1.getX()-p2.getX())*(p1.getX()-p2.getX())+ (p1.getY()-p2.getY())*(p1.getY()-p2.getY())+ (p1.getZ()-p2.getZ())*(p1.getZ()-p2.getZ());
//				System.out.println("dis= "+dis);
				for(int i22=i2+1;i22<E.length;i22++)
				{
					Point p11=E[i22].point1;
					Point p21=E[i22].point2;
					float dis1=(p11.getX()-p21.getX())*(p11.getX()-p21.getX())+ (p11.getY()-p21.getY())*(p11.getY()-p21.getY())+ (p11.getZ()-p21.getZ())*(p11.getZ()-p21.getZ());
//					System.out.println("dis1= "+dis1);
//					System.out.println(E[i22]);
//					System.out.println(E[i22+1]);
					if(dis>dis1)
					{
//						System.out.println("sdfdafafa");
						Edge e4=E[i2];
//						System.out.println("e4 = "+e4);
						E[i2]=E[i22];
//						System.out.println("E[i2] becomes "+E[i2]);
						E[i22]=e4;
//						System.out.println("E[i22] becomes "+E[i22]);
//						System.out.println("af"+E[i22]);
//						System.out.println("after"+E[i22+1]);
					}
				}
			}
			
//			for(int k4=0;k4<E.length;k4++)
//			{
//				System.out.println((k4+1)+"th element of the returned boundary edges array is "+E[k4]);
//			}
//			for(int i3=0;i3<E.length;i3++)
//			{
//				System.out.println(i3+"th element of returned boundary edges array is"+E[i3]);
//			}
			
			return E;
		
		}
		
		return null;
	}
	
	
	//
	public int COUNT_CONNECTED_COMPONENTS()		//COMPLETED
	{
		
		return components.size();
		
	}

	//INPUT [x1,y1,z1,x2,y2,z2,x3,y3,z3]
	public TriangleInterface [] NEIGHBORS_OF_TRIANGLE(float [] triangle_coord) //COMPLETED
	{
		float X1=triangle_coord[0];
		float Y1=triangle_coord[1];
		float Z1=triangle_coord[2];
		float X2=triangle_coord[3];
		float Y2=triangle_coord[4];
		float Z2=triangle_coord[5];
		float X3=triangle_coord[6];
		float Y3=triangle_coord[7];
		float Z3=triangle_coord[8];
		
		Point point1=new Point(X1, Y1, Z1), point2=new Point(X2,Y2,Z2), point3=new Point(X3, Y3, Z3);
		
		
		
		if(isValid(point1, point2, point3)==true) 
		{
			ArrayList<Triangle> tr=new ArrayList<Triangle>();
			
//			System.out.println("triangle is valid");
			
			Triangle t=new Triangle(point1, point2, point3);
			Triangle t2=new Triangle(point2, point3, point1);
			Triangle t3=new Triangle(point3, point1, point2);
			Triangle t4=new Triangle(point1, point3, point2);
			Triangle t5=new Triangle(point2, point1, point3);
			Triangle t6=new Triangle(point3, point2, point1);
			
			int x4=0;
			int index=-1;
			for(int i=0;i<triangles.size();i++)
			{
				if(t.compareTo(triangles.get(i))==0 || t2.compareTo(triangles.get(i))==0 || t3.compareTo(triangles.get(i))==0 ||t4.compareTo(triangles.get(i))==0 || t5.compareTo(triangles.get(i))==0 ||t6.compareTo(triangles.get(i))==0)
				{
					x4=1;
//					for(int j=0;j<triangles.get(i))
					
					
					index=i;
					break;
				}
			}
			
			if(x4==0)
				return null;
			else 
			{
				Point p11=triangles.get(index).point1;
				Point p22=triangles.get(index).point2;
				Point p33=triangles.get(index).point3;
				
				Edge e1=new Edge(p11,p22);
				Edge e11=new Edge(p22,p11);
				Edge e2=new Edge(p11, p33);
				Edge e22=new Edge(p33,p11);
				Edge e3=new Edge(p22,p33);
				Edge e33=new Edge(p33, p22);
				
				for(int j=0;j<edges.size();j++)
				{
					if(edges.get(j).compareTo(e1)==0 || edges.get(j).compareTo(e11)==0)
					{
						for(int j1=0;j1<edges.get(j).getTriangles().size();j1++)
						{
							if(edges.get(j).getTriangles().get(j1).compareTo(triangles.get(index))!=0 )
							tr.add(edges.get(j).getTriangles().get(j1));
						}
						
					}
					if(edges.get(j).compareTo(e2)==0 || edges.get(j).compareTo(e22)==0)
					{
						for(int j1=0;j1<edges.get(j).getTriangles().size();j1++)
						{
							if(edges.get(j).getTriangles().get(j1).compareTo(triangles.get(index))!=0 )
							tr.add(edges.get(j).getTriangles().get(j1));
						}
						
					}
					if(edges.get(j).compareTo(e3)==0 || edges.get(j).compareTo(e33)==0)
					{
						for(int j1=0;j1<edges.get(j).getTriangles().size();j1++)
						{
							if(edges.get(j).getTriangles().get(j1).compareTo(triangles.get(index))!=0 )
							tr.add(edges.get(j).getTriangles().get(j1));
						}
					}
				}
				
			}
			if(tr.size()!=0)
			{
				
				int size1=0;
				for(int j1=0;j1<tr.size();j1++)
				{
					if(tr.get(j1)!=null)
					{
						size1++;
					}
				}
				
				Triangle[] E=new Triangle[size1];
				int i1=0;
				for(int j=0;j<tr.size();j++)						//COPY ARRAYLIST TO ARRAY
				{
					if(tr.get(j)!=null)
					{
					
					E[i1]=tr.get(j);
					i1++;
					}
				}
				
				for(int i2=0;i2<E.length-1;i2++)			//SELECTION SORT
				{
					for(int i22=i2+1;i22<E.length;i22++)
					{
						if((E[i2]).compareAccordingToInsertionTime(E[i22])>0)
						{
							Triangle e4=E[i2];
							E[i2]=E[i22];
							E[i22]=e4;
						}
					}
				}
				
//				for(int k4=0;k4<E.length;k4++)
//				{
//					System.out.println((k4+1)+"th element of the returned boundary edges array is "+E[k4]);
//				}
//				for(int i3=0;i3<E.length;i3++)
//				{
//					System.out.println(i3+"th element of returned neighbours of a triangle array is"+E[i3]);
//				}
				
				return E;
			
			}
			else
				return null;
				
			
		}
		else
		return null;
		
	}

	//INPUT [x1,y1,z1,x2,y2,z2,x3,y3,z3]
	public EdgeInterface [] EDGE_NEIGHBOR_TRIANGLE(float [] triangle_coord)	//COMPLETED
	{
		float X1=triangle_coord[0];
		float Y1=triangle_coord[1];
		float Z1=triangle_coord[2];
		float X2=triangle_coord[3];
		float Y2=triangle_coord[4];
		float Z2=triangle_coord[5];
		float X3=triangle_coord[6];
		float Y3=triangle_coord[7];
		float Z3=triangle_coord[8];
		
		Point point1=new Point(X1, Y1, Z1), point2=new Point(X2,Y2,Z2), point3=new Point(X3, Y3, Z3);
		
		
		
		if(isValid(point1, point2, point3)==true) 
		{
			ArrayList<Edge> tr=new ArrayList<Edge>();
			
//			System.out.println("triangle is valid");
			
			Triangle t=new Triangle(point1, point2, point3);
			Triangle t2=new Triangle(point2, point3, point1);
			Triangle t3=new Triangle(point3, point1, point2);
			Triangle t4=new Triangle(point1, point3, point2);
			Triangle t5=new Triangle(point2, point1, point3);
			Triangle t6=new Triangle(point3, point2, point1);
			
			int x4=0;
			int index=-1;
			for(int i=0;i<triangles.size();i++)
			{
				if(t.compareTo(triangles.get(i))==0 || t2.compareTo(triangles.get(i))==0 || t3.compareTo(triangles.get(i))==0 ||t4.compareTo(triangles.get(i))==0 || t5.compareTo(triangles.get(i))==0 ||t6.compareTo(triangles.get(i))==0)
				{
					x4=1;
//					for(int j=0;j<triangles.get(i))
					
					
					index=i;
					break;
				}
			}
			
			if(x4==0)
				return null;
			else 
			{
				Point p11=triangles.get(index).point1;
				Point p22=triangles.get(index).point2;
				Point p33=triangles.get(index).point3;
				
				Edge e1=new Edge(p11,p22);
				Edge e11=new Edge(p22,p11);
				Edge e2=new Edge(p11, p33);
				Edge e22=new Edge(p33,p11);
				Edge e3=new Edge(p22,p33);
				Edge e33=new Edge(p33, p22);
				
				for(int j=0;j<edges.size();j++)
				{
					if(edges.get(j).compareTo(e1)==0 || edges.get(j).compareTo(e11)==0)
					{
						tr.add(edges.get(j));
					}
					if(edges.get(j).compareTo(e2)==0 || edges.get(j).compareTo(e22)==0)
					{
						tr.add(edges.get(j));
					}
					
					if(edges.get(j).compareTo(e3)==0 || edges.get(j).compareTo(e33)==0)
					{
						tr.add(edges.get(j));
					}
				}
				
				if(tr.size()!=0)
				{
					
					int size1=0;
					for(int j1=0;j1<tr.size();j1++)
					{
						if(tr.get(j1)!=null)
						{
							size1++;
						}
					}
					
					Edge[] E=new Edge[size1];
					int i1=0;
					for(int j2=0;j2<tr.size();j2++)						//COPY ARRAYLIST TO ARRAY
					{
						if(tr.get(j2)!=null)
						{
						
						E[i1]=tr.get(j2);
						i1++;
						}
					}
					
//					for(int k4=0;k4<E.length;k4++)
//					{
//						System.out.println((k4+1)+"th element of the returned boundary edges array is "+E[k4]);
//					}
//					for(int i3=0;i3<E.length;i3++)
//					{
//						System.out.println(i3+"th element of returned neighbours of a triangle array is"+E[i3]);
//					}
					
					return E;
				
				}
				else
					return null;
			}
		}
		return null;
		
	}

	//INPUT [x1,y1,z1,x2,y2,z2,x3,y3,z3]
	public PointInterface [] VERTEX_NEIGHBOR_TRIANGLE(float [] triangle_coord)	//COMPLETED
	{
		float X1=triangle_coord[0];
		float Y1=triangle_coord[1];
		float Z1=triangle_coord[2];
		float X2=triangle_coord[3];
		float Y2=triangle_coord[4];
		float Z2=triangle_coord[5];
		float X3=triangle_coord[6];
		float Y3=triangle_coord[7];
		float Z3=triangle_coord[8];
		
		Point point1=new Point(X1, Y1, Z1), point2=new Point(X2,Y2,Z2), point3=new Point(X3, Y3, Z3);
		
		
		
		if(isValid(point1, point2, point3)==true) 
		{
			
//			System.out.println("triangle is valid");
			
			Triangle t=new Triangle(point1, point2, point3);
			Triangle t2=new Triangle(point2, point3, point1);
			Triangle t3=new Triangle(point3, point1, point2);
			Triangle t4=new Triangle(point1, point3, point2);
			Triangle t5=new Triangle(point2, point1, point3);
			Triangle t6=new Triangle(point3, point2, point1);
			
			int x4=0;
			int index=-1;
			for(int i=0;i<triangles.size();i++)
			{
				if(t.compareTo(triangles.get(i))==0 || t2.compareTo(triangles.get(i))==0 || t3.compareTo(triangles.get(i))==0 ||t4.compareTo(triangles.get(i))==0 || t5.compareTo(triangles.get(i))==0 ||t6.compareTo(triangles.get(i))==0)
				{
					x4=1;
//					for(int j=0;j<triangles.get(i))
					
					
					index=i;
					break;
				}
			}
			
			if(x4==0)
				return null;
			else 
			{
				Point p11=triangles.get(index).point1;
				Point p22=triangles.get(index).point2;
				Point p33=triangles.get(index).point3;
				Point[] p=new Point[3];
				
				p[0]=p11;
				p[1]=p22;
				p[2]=p33;
				
//				for(int i=0;i<p.length;i++)
//				{
//					System.out.println(i+"th element of returned points array is "+p[i]);
//				}
				
				return p;
			}
		}
		else
		return null;
		
	}

	//INPUT [x1,y1,z1,x2,y2,z2,x3,y3,z3]
	public TriangleInterface [] EXTENDED_NEIGHBOR_TRIANGLE(float [] triangle_coord)//COMPLETED
	{
		float X1=triangle_coord[0];
		float Y1=triangle_coord[1];
		float Z1=triangle_coord[2];
		float X2=triangle_coord[3];
		float Y2=triangle_coord[4];
		float Z2=triangle_coord[5];
		float X3=triangle_coord[6];
		float Y3=triangle_coord[7];
		float Z3=triangle_coord[8];
		
		Point point1=new Point(X1, Y1, Z1), point2=new Point(X2,Y2,Z2), point3=new Point(X3, Y3, Z3);
		
		
		
		if(isValid(point1, point2, point3)==true) 
		{
			
//			System.out.println("triangle is valid");
			
			Triangle t=new Triangle(point1, point2, point3);
			Triangle t2=new Triangle(point2, point3, point1);
			Triangle t3=new Triangle(point3, point1, point2);
			Triangle t4=new Triangle(point1, point3, point2);
			Triangle t5=new Triangle(point2, point1, point3);
			Triangle t6=new Triangle(point3, point2, point1);
			
			int x4=0;
			int index=-1;
			for(int i=0;i<triangles.size();i++)
			{
				if(t.compareTo(triangles.get(i))==0 || t2.compareTo(triangles.get(i))==0 || t3.compareTo(triangles.get(i))==0 ||t4.compareTo(triangles.get(i))==0 || t5.compareTo(triangles.get(i))==0 ||t6.compareTo(triangles.get(i))==0)
				{
					x4=1;
//					for(int j=0;j<triangles.get(i))
					
					
					index=i;
					break;
				}
			}
			
			if(x4==0)
				return null;
			else 
			{
				Point p11=triangles.get(index).point1;
				Point p22=triangles.get(index).point2;
				Point p33=triangles.get(index).point3;
				
//				for(int i=0;i<p.length;i++)
//				{
//					System.out.println(i+"th element of returned points array is "+p[i]);
//				}
				ArrayList<Triangle> a=new ArrayList<Triangle>();
				for(int j1=0;j1<points.size();j1++)
				{
					if(points.get(j1).compareTo(p11)==0 || points.get(j1).compareTo(p22)==0 || points.get(j1).compareTo(p33)==0)
					{
						for(int j2=0;j2<points.get(j1).getTriangleNeighbours().size();j2++)
						{
							if(triangles.get(index).compareTo(points.get(j1).getTriangleNeighbours().get(j2))!=0 && !a.contains(points.get(j1).getTriangleNeighbours().get(j2)))
							a.add(points.get(j1).getTriangleNeighbours().get(j2));
							
						}
					}
				}
				if(a.size()!=0)
				{
					
					int size1=0;
					for(int j1=0;j1<a.size();j1++)
					{
						if(a.get(j1)!=null)
						{
							size1++;
						}
					}
					
					Triangle[] E=new Triangle[size1];
					int i1=0;
					for(int j2=0;j2<a.size();j2++)						//COPY ARRAYLIST TO ARRAY
					{
						if(a.get(j2)!=null)
						{
						
						E[i1]=a.get(j2);
						i1++;
						}
					}
					
//					for(int k4=0;k4<E.length;k4++)
//					{
//						System.out.println((k4+1)+"th element of the returned boundary edges array is "+E[k4]);
//					}

					
					for(int i2=0;i2<E.length-1;i2++)			//SELECTION SORT
					{
						for(int i22=i2+1;i22<E.length;i22++)
						{
							if((E[i2]).compareAccordingToInsertionTime(E[i22])>0)
							{
								Triangle e4=E[i2];
								E[i2]=E[i22];
								E[i22]=e4;
							}
						}
					}
					
//					for(int i3=0;i3<E.length;i3++)
//					{
//						System.out.println(i3+"th element of returned extended neighbours of a triangle array is"+E[i3]);
//					}
					return E;
				
				}
				else
					return null;
			}
		}
		else
		return null;
		
	}

	//INPUT [x,y,z]
	public TriangleInterface [] INCIDENT_TRIANGLES(float [] point_coordinates)//COMPLETED
	{
		float X=point_coordinates[0];
		float Y=point_coordinates[1];
		float Z=point_coordinates[2];
		
		Point p1=new Point(X, Y, Z);
		ArrayList<Triangle> a=new ArrayList<Triangle>();
		int x4=0;
		
		for(int i=0;i<points.size();i++)
		{
			if(points.get(i).compareTo(p1)==0)
			{
//				System.out.println("size of triangle list in point is "+points.get(i).getTriangleNeighbours().size());
				for(int i1=0;i1<points.get(i).getTriangleNeighbours().size();i1++)
				{
					int l=-1;
					for(int k=0;k<a.size();k++)
					{
						if(a.get(k).compareTo(points.get(i).getTriangleNeighbours().get(i1))==0)
						{
							l=1;
							break;
						}
					}
					if(l==-1)
					a.add(points.get(i).getTriangleNeighbours().get(i1));
					
				}
				
				x4=1;
				break;
			}
		}
		if(x4==0)
			return null;
		else
		{
			
			if(a.size()!=0)
			{
				
				int size1=0;
				for(int j1=0;j1<a.size();j1++)
				{
					if(a.get(j1)!=null)
					{
						size1++;
					}
				}
//				System.out.println("size of a= "+a.size());
				
				Triangle[] E=new Triangle[size1];
				int i1=0;
				for(int j2=0;j2<a.size();j2++)						//COPY ARRAYLIST TO ARRAY
				{
					E[i1]=a.get(j2);
					i1++;
				}
				
				
//				for(int k4=0;k4<E.length;k4++)
//				{
//					System.out.println((k4+1)+"th element of the returned boundary edges array is "+E[k4]);
//				}

				
				for(int i2=0;i2<E.length-1;i2++)			//SELECTION SORT
				{
					for(int i22=i2+1;i22<E.length;i22++)
					{
						if((E[i2]).compareAccordingToInsertionTime(E[i22])>0)
						{
							Triangle e4=E[i2];
							E[i2]=E[i22];
							E[i22]=e4;
						}
					}
				}
				
//				for(int i3=0;i3<E.length;i3++)
//				{
//					System.out.println(i3+"th element of returned incident triangles array is"+E[i3]);
//				}
				return E;
			
			}
			else
				return null;
		}
		
	}

	// INPUT [x,y,z]
	public PointInterface [] NEIGHBORS_OF_POINT(float [] point_coordinates)//COMPLETED	
	{
		float X=point_coordinates[0];
		float Y=point_coordinates[1];
		float Z=point_coordinates[2];
		
		Point p1=new Point(X, Y, Z);
		ArrayList<Point> a=new ArrayList<Point>();
		int x4=0;
		
		for(int i=0;i<points.size();i++)
		{
			if(points.get(i).compareTo(p1)==0)
			{
//				System.out.println("size of triangle list in point is "+points.get(i).getTriangleNeighbours().size());
				for(int i1=0;i1<points.get(i).getVertexNeighbours().size();i1++)
				{
					a.add(points.get(i).getVertexNeighbours().get(i1));
					
				}
				
				x4=1;
				break;
			}
		}
		if(x4==0)
			return null;
		else
		{
			
			if(a.size()!=0)
			{
				
				int size1=0;
				for(int j1=0;j1<a.size();j1++)
				{
					if(a.get(j1)!=null)
					{
						size1++;
					}
				}
				
				Point[] E=new Point[size1];
				int i1=0;
				for(int j2=0;j2<a.size();j2++)						//COPY ARRAYLIST TO ARRAY
				{
					if(a.get(j2)!=null)
					{
					
					E[i1]=a.get(j2);
					i1++;
					}
				}
				
//				for(int k4=0;k4<E.length;k4++)
//				{
//					System.out.println((k4+1)+"th element of the returned boundary edges array is "+E[k4]);
//				}

				
				
				
//				for(int i3=0;i3<E.length;i3++)
//				{
//					System.out.println(i3+"th element of returned incident triangles array is"+E[i3]);
//				}
				return E;
			
			}
			else
				return null;
		}
	}

	// INPUT[x,y,z]
	public EdgeInterface [] EDGE_NEIGHBORS_OF_POINT(float [] point_coordinates)//COMPLETED
	{
		float X=point_coordinates[0];
		float Y=point_coordinates[1];
		float Z=point_coordinates[2];
		Point p1=new Point(X, Y, Z);
		
		ArrayList<Edge> E=new ArrayList<Edge>();
//		System.out.println("fsaafasdf");
		
int x4=0;
		
		for(int i=0;i<points.size();i++)
		{
			if(points.get(i).compareTo(p1)==0)
			{
//				System.out.println("size of triangle list in point is "+points.get(i).getTriangleNeighbours().size());
				for(int i1=0;i1<points.get(i).getVertexNeighbours().size();i1++)
				{
//					a.add(points.get(i).getVertexNeighbours().get(i1));
					Edge e=new Edge(p1, points.get(i).getVertexNeighbours().get(i1));
					E.add(e);
				}
				
				x4=1;
				break;
			}
		}
//		for(int i=0;i<points.size();i++)
//		{
//			
//			if(p1.compareTo(points.get(i))==0)
//			{
//				System.out.println("fsaafasdf");
//				for(int j=0;j<points.get(i).getVertexNeighbours().size();i++)
//				{
//					Edge e=new Edge(points.get(i), points.get(i).getVertexNeighbours().get(j));
//					E.add(e);
//					
//				}//Directly returning edges with end points only
//			
//				break;
//			}							//if not correct, inside the inner for loop
//										//search that edge from edges and then return it
//		}
//		System.out.println("size of E is "+E.size());
		if(E.size()!=0)
		{
			int size1=0;
			for(int j1=0;j1<E.size();j1++)
			{
				if(E.get(j1)!=null)
				{
					size1++;
				}
			}
			
			Edge[] E1=new Edge[size1];
			int i1=0;
			for(int j2=0;j2<E.size();j2++)						//COPY ARRAYLIST TO ARRAY
			{
				if(E.get(j2)!=null)
				{
				
				E1[i1]=E.get(j2);
				i1++;
				}
			}
			
//			for(int i4=0;i4<E1.length;i4++)
//			{
//				System.out.println(i4+"th element of returned edges list is "+E1[i4]);
//			}
			return E1;
		
		
		}
		else
		return null;
		
	}

	// INPUT[x,y,z]
	public TriangleInterface [] FACE_NEIGHBORS_OF_POINT(float [] point_coordinates)//COMPLETED
	
	{ 
		float X=point_coordinates[0];
		float Y=point_coordinates[1];
		float Z=point_coordinates[2];
		
		Point p1=new Point(X, Y, Z);
		ArrayList<Triangle> a=new ArrayList<Triangle>();
		int x4=0;
		
		for(int i=0;i<points.size();i++)
		{
			if(points.get(i).compareTo(p1)==0)
			{
//				System.out.println("size of triangle list in point is "+points.get(i).getTriangleNeighbours().size());
				for(int i1=0;i1<points.get(i).getTriangleNeighbours().size();i1++)
				{
					a.add(points.get(i).getTriangleNeighbours().get(i1));
					
				}
				
				x4=1;
				break;
			}
		}
		if(x4==0)
			return null;
		else
		{
			
			if(a.size()!=0)
			{
				
				int size1=0;
				for(int j1=0;j1<a.size();j1++)
				{
					if(a.get(j1)!=null)
					{
						size1++;
					}
				}
				
				Triangle[] E=new Triangle[size1];
				int i1=0;
				for(int j2=0;j2<a.size();j2++)						//COPY ARRAYLIST TO ARRAY
				{
					if(a.get(j2)!=null)
					{
					
					E[i1]=a.get(j2);
					i1++;
					}
				}
				
//				for(int k4=0;k4<E.length;k4++)
//				{
//					System.out.println((k4+1)+"th element of the returned boundary edges array is "+E[k4]);
//				}

				
				for(int i2=0;i2<E.length-1;i2++)			//SELECTION SORT
				{
					for(int i22=i2+1;i22<E.length;i22++)
					{
						if((E[i2]).compareAccordingToInsertionTime(E[i22])>0)
						{
							Triangle e4=E[i2];
							E[i2]=E[i22];
							E[i22]=e4;
						}
					}
				}
				
//				for(int i3=0;i3<E.length;i3++)
//				{
//					System.out.println(i3+"th element of returned incident triangles array is"+E[i3]);
//				}
				return E;
			
			}
			else
				return null;
		}
	}

	// INPUT // [xa1,ya1,za1,xa2,ya2,za2,xa3,ya3,za3 , xb1,yb1,zb1,xb2,yb2,zb2,xb3,yb3,zb3]   where xa1,ya1,za1,xa2,ya2,za2,xa3,ya3,za3 are 3 coordinates of first triangle and xb1,yb1,zb1,xb2,yb2,zb2,xb3,yb3,zb3 are coordinates of second triangle as given in specificaition.
	public boolean IS_CONNECTED(float [] triangle_coord_1, float [] triangle_coord_2)//COMPLETED
	{
		float X1=triangle_coord_1[0];
		float Y1=triangle_coord_1[1];
		float Z1=triangle_coord_1[2];
		float X2=triangle_coord_1[3];
		float Y2=triangle_coord_1[4];
		float Z2=triangle_coord_1[5];
		float X3=triangle_coord_1[6];
		float Y3=triangle_coord_1[7];
		float Z3=triangle_coord_1[8];
		
		float X11=triangle_coord_2[0];
		float Y11=triangle_coord_2[1];
		float Z11=triangle_coord_2[2];
		float X21=triangle_coord_2[3];
		float Y21=triangle_coord_2[4];
		float Z21=triangle_coord_2[5];
		float X31=triangle_coord_2[6];
		float Y31=triangle_coord_2[7];
		float Z31=triangle_coord_2[8];
		Point point1=new Point(X1, Y1, Z1), point2=new Point(X2,Y2,Z2), point3=new Point(X3, Y3, Z3);
		Point point11=new Point(X11, Y11, Z11), point21=new Point(X21,Y21,Z21), point31=new Point(X31, Y31, Z31);
		
		
		if(isValid(point1, point2, point3)==true && isValid(point11, point21, point31)==true) 
		{
			
//			System.out.println("triangle is valid");
			
			Triangle t=new Triangle(point1, point2, point3);
			Triangle t2=new Triangle(point2, point3, point1);
			Triangle t3=new Triangle(point3, point1, point2);
			Triangle t4=new Triangle(point1, point3, point2);
			Triangle t5=new Triangle(point2, point1, point3);
			Triangle t6=new Triangle(point3, point2, point1);
			
			int x4=0;
			int index=-1, indexC=-1;
			for(int i=0;i<triangles.size();i++)
			{
				if(t.compareTo(triangles.get(i))==0 || t2.compareTo(triangles.get(i))==0 || t3.compareTo(triangles.get(i))==0 ||t4.compareTo(triangles.get(i))==0 || t5.compareTo(triangles.get(i))==0 ||t6.compareTo(triangles.get(i))==0)
				{
					x4=1;
//					for(int j=0;j<triangles.get(i))
					
					
					index=i;
					break;
				}
			}
			
			for(int i=0;i<components.size();i++)
			{
				for(int j=0;j<components.get(i).triangles.size();j++)
				{
					if(components.get(i).triangles.get(j).compareTo(t)==0 || components.get(i).triangles.get(j).compareTo(t2)==0 || components.get(i).triangles.get(j).compareTo(t3)==0 || components.get(i).triangles.get(j).compareTo(t4)==0 || components.get(i).triangles.get(j).compareTo(t5)==0 || components.get(i).triangles.get(j).compareTo(t6)==0)
					{
						x4=1;
						indexC=i;
						index=j;
						break;
					}
				}
			}
			if(x4==0)
				return false;
			else 
			{
				Triangle t1=new Triangle(point11, point21, point31);
				Triangle t21=new Triangle(point21, point31, point11);
				Triangle t31=new Triangle(point31, point11, point21);
				Triangle t41=new Triangle(point11, point31, point21);
				Triangle t51=new Triangle(point21, point11, point31);
				Triangle t61=new Triangle(point31, point21, point11);
					int x41=0;
				for(int i1=0;i1<components.get(indexC).triangles.size();i1++)
				{
					if(components.get(indexC).triangles.get(i1).compareTo(t1)==0 || components.get(indexC).triangles.get(i1).compareTo(t21)==0 || components.get(indexC).triangles.get(i1).compareTo(t31)==0 || components.get(indexC).triangles.get(i1).compareTo(t41)==0 || components.get(indexC).triangles.get(i1).compareTo(t51)==0 || components.get(indexC).triangles.get(i1).compareTo(t61)==0)
					{
						x41=1;
//						indexC=i;
//						index=j;
						break;
					}
					
				}
				if(x41==0)
				{
					return false;
					
				}
				else
					return true;
				
			}
		}
		else return false;
		
		
	}

	// INPUT [x1,y1,z1,x2,y2,z2] // where (x1,y1,z1) refers to first end point of edge and  (x2,y2,z2) refers to the second.
	public TriangleInterface [] TRIANGLE_NEIGHBOR_OF_EDGE(float [] edge_coordinates)//COMPLETED
	{ 
		float X1=edge_coordinates[0];
		float Y1=edge_coordinates[1];
		float Z1=edge_coordinates[2];
		float X2=edge_coordinates[3];
		float Y2=edge_coordinates[4];
		float Z2=edge_coordinates[5];
		
		Point point1=new Point(X1, Y1, Z1);
		Point point2=new Point(X2, Y2, Z2);
		
		Edge e1=new Edge(point1, point2);
		Edge e11=new Edge(point2, point1);
		
		int x4=0,index=-1;
		

		
		for(int i=0;i<edges.size();i++)
		{
			if(e1.compareTo(edges.get(i))==0 || e11.compareTo(edges.get(i))==0)
			{
//				System.out.println(edges.get(i)+" matched");
				x4=1;
				index=i;
				break;
			}
		}
//		System.out.println("asfdaf");

		if(x4==0)
			return null;
		else
		{
			ArrayList<Triangle> a=new ArrayList<Triangle>();
			for(int j=0;j<edges.get(index).getTriangles().size();j++)
			{
				a.add(edges.get(index).getTriangles().get(j));
			}
//			System.out.println("size of a is "+a.size());
			if(a.size()!=0)
			{
				
				int size1=0;
				for(int j1=0;j1<a.size();j1++)
				{
					if(a.get(j1)!=null)
					{
						size1++;
					}
				}
				
				Triangle[] E=new Triangle[size1];
				int i1=0;
				for(int j2=0;j2<a.size();j2++)						//COPY ARRAYLIST TO ARRAY
				{
					if(a.get(j2)!=null)
					{
					
					E[i1]=a.get(j2);
					i1++;
					}
				}
				
//				for(int k4=0;k4<E.length;k4++)
//				{
//					System.out.println((k4+1)+"th element of the returned boundary edges array is "+E[k4]);
//				}

				
				for(int i2=0;i2<E.length-1;i2++)			//SELECTION SORT
				{
					for(int i22=i2+1;i22<E.length;i22++)
					{
						if((E[i2]).compareAccordingToInsertionTime(E[i22])>0)
						{
							Triangle e4=E[i2];
							E[i2]=E[i22];
							E[i22]=e4;
						}
					}
				}
				
//				for(int i3=0;i3<E.length;i3++)
//				{
//					System.out.println(i3+"th element of returned triangle neighbours of edge array is"+E[i3]);
//				}
				return E;
			
			}
			else
				return null;
		}
		
	}
	
	public int dia(ArrayList<Triangle> t, Triangle t1)
	{
		ArrayList<ArrayList<Triangle>> n=new ArrayList<ArrayList<Triangle>>();
		ArrayList<Triangle> n0=new ArrayList<Triangle>();
		int index=-1;
		for(int i=0;i<t.size();i++)
		{
			if(t.get(i).compareTo(t1)==0)
			{
				index=i;
				n0.add(t.get(i));
			}
		}
		n.add(n0);
		for(int i3=0;i3<n.size();i3++)
		{
//			System.out.println("biggest list executed "+i3+1+" times");
				ArrayList<Triangle> n1=new ArrayList<Triangle>();
			for(int i1=0;i1<n.get(i3).size();i1++)
			{
//				System.out.println(i1+"th child of biggest list executed");
//				System.out.println("triangle to be checked is "+n.get(i3).get(i1));
				Point p1=n.get(i3).get(i1).point1;
				Point p2=n.get(i3).get(i1).point2;
				Point p3=n.get(i3).get(i1).point3;
				int x=0;
	//			Edge e1=new Edge(p1, p2);
	//			Edge e2=new Edge(p2, p1);
	//			Edge e3=new Edge(p1, p3);
	//			Edge e4=new Edge(p3, p1);
	//			Edge e5=new Edge(p2, p3);
	//			Edge e6=new Edge(p3, p2);
				for(int j=0;j<t.size();j++)
				{
//					System.out.println("              triangle is "+t.get(j));
					if(t.get(j).compareTo(n.get(i3).get(i1))!=0)
					{
						if(t.get(j).point1.compareTo(p1)==0 || t.get(j).point1.compareTo(p2)==0 || t.get(j).point1.compareTo(p3)==0)
						{
//							System.out.println(t.get(j).point1 +" matched ");
							x++;
							
						}
						 if(t.get(j).point2.compareTo(p1)==0 || t.get(j).point2.compareTo(p2)==0 || t.get(j).point2.compareTo(p3)==0)
						{
//							System.out.println(t.get(j).point2 +" matched ");
							x++;
							
						}
						if(t.get(j).point3.compareTo(p1)==0 || t.get(j).point3.compareTo(p2)==0 || t.get(j).point3.compareTo(p3)==0)
						{
//							System.out.println(t.get(j).point3 +" matched ");
							x++;
							
						}
//						System.out.println("value of x= "+x);
						if(x==2)
						{
//							System.out.println("edge matched with this triangle having isVisted= "+t.get(j).isVisited());
							if(t.get(j).isVisited()==false)
							{
								
							t.get(j).vis=true;
							n1.add(t.get(j));
//							System.out.println("list added to this child of biggest list");
							}
							x=0;
	//						if(t.get(j).compareTo(t2)==0)
	//						{
	//							break;
	//						}
						}
						else
						{
							x=0;
							
						}
					}
					else 
					{
						t.get(j).vis=true;
					}
				}
	//			if(n1.get(n1.size()-1).compareTo(t2)==0)
	//			{
	//				break;
	//			}
				
			}
			
			if(n1.size()!=0) {
				n.add(n1);
//				System.out.println("size of n1 = "+n1.size());	
			}
			else 
				return (n.size()-1);
		}
		return 0;
	}
	public int MAXIMUM_DIAMETER()
	{
		for(int i1=0;i1<components.size();i1++)
		{
//			System.out.println("component is "+components.get(i1));
			for(int j1=0;j1<components.get(i1).triangles.size();j1++)
			{
				components.get(i1).triangles.get(j1).vis=false;
				
				
			}
			
		}
		ArrayList<Integer> d=new ArrayList<Integer>();
		int x1=0;
		for(int i=0;i<components.size();i++)
		{
			for(int i1=0;i1<components.get(i).triangles.size();i1++)
			{
			int x=dia(components.get(i).triangles, components.get(i).triangles.get(i1) );
//			System.out.println("dia of component is "+x);
			if(x1<x)
			{
				x1=x;
			}
			}
		}
//		System.out.println("x1= "+x1); 
		return x1;
		
	} //////////////////////////////////////////////////////////////////// 

	public PointInterface [] CENTROID ()		//COMPLETED

	{
		Point[] cen=new Point[components.size()];
		int ind=-1, ind2=-1;
		
		for(int i=0;i<components.size();i++)
		{
			
			float sumx=0, sumy=0, sumz=0, x1=0, y1=0, z1=0;
			for(int i1=0;i1<components.get(i).triangles.size();i1++)
			{
				
				sumx+=components.get(i).triangles.get(i1).point1.getX()+components.get(i).triangles.get(i1).point2.getX()+components.get(i).triangles.get(i1).point3.getX();
				sumy+=components.get(i).triangles.get(i1).point1.getY()+components.get(i).triangles.get(i1).point2.getY()+components.get(i).triangles.get(i1).point3.getY();
				sumz+=components.get(i).triangles.get(i1).point1.getZ()+components.get(i).triangles.get(i1).point2.getZ()+components.get(i).triangles.get(i1).point3.getZ();
				x1+=3;
				y1+=3;
				z1+=3;
				
			}
			float x3=sumx/x1;
			float y3=sumy/y1;
			float z3=sumz/z1;
			
			cen[i]=new Point(x3, y3, z3);
			
		}
//		for(int i1=0;i1<cen.length;i1++)
//		{
//			System.out.print(cen[i1]+" ");
//		}
		return cen;
	}

	// INPUT [x,y,z]
	public PointInterface CENTROID_OF_COMPONENT (float [] point_coordinates)		//COMPLETED
	{
		float X=point_coordinates[0];
		float Y=point_coordinates[1];
		float Z=point_coordinates[2];
		Point point=new Point(X, Y,Z );
		int ind=-1, ind2=-1;
		
		for(int i=0;i<components.size();i++)
		{
			
			float sumx=0, sumy=0, sumz=0, x1=0, y1=0, z1=0;
			for(int i1=0;i1<components.get(i).triangles.size();i1++)
			{
				if(point.compareTo(components.get(i).triangles.get(i1).point1)==0 || point.compareTo(components.get(i).triangles.get(i1).point2)==0 || point.compareTo(components.get(i).triangles.get(i1).point3)==0)
				{
					
					ind=i;
				}
				
				sumx+=components.get(i).triangles.get(i1).point1.getX()+components.get(i).triangles.get(i1).point2.getX()+components.get(i).triangles.get(i1).point3.getX();
				sumy+=components.get(i).triangles.get(i1).point1.getY()+components.get(i).triangles.get(i1).point2.getY()+components.get(i).triangles.get(i1).point3.getY();
				sumz+=components.get(i).triangles.get(i1).point1.getZ()+components.get(i).triangles.get(i1).point2.getZ()+components.get(i).triangles.get(i1).point3.getZ();
				x1+=3;
				y1+=3;
				z1+=3;
				
			}
			if(ind!=-1) {
			float x3=sumx/x1;
			float y3=sumy/y1;
			float z3=sumz/z1;
			
			Point p=new Point(x3, y3, z3);
			
//			System.out.println(p);
			return p;
			}
		}
	return null;
	}


	public 	PointInterface [] CLOSEST_COMPONENTS(){	/////////////////////////////////////////////
//		System.out.println("fadfaff");
		float d=1000000000;
		Point[] p=new Point[2];
		for(int i=0;i<components.size();i++)
		{
//			System.out.println("component reference is: ");
//			System.out.println(components.get(i));
			for(int i1=0;i1<components.get(i).triangles.size();i1++)
			{
//				System.out.println("triangle reference is "+components.get(i).triangles.get(i1));
				Point p1=components.get(i).triangles.get(i1).point1;
//				System.out.println("value of d= "+d);
				
				for(int i2=0;i2<components.size();i2++)
				{
					if(i2!=i)
					
					{
						
//						System.out.println("component to be checked is: ");
//						System.out.println(components.get(i2));
					for(int i3=0;i3<components.get(i2).triangles.size();i3++)
					{
//						System.out.println("triangle to be checked is "+components.get(i2).triangles.get(i3));
//						if(i3!=i1)
//						{
							Point p11=components.get(i2).triangles.get(i3).point1;
//							System.out.println("triangle to be ch");
							Point p21=components.get(i2).triangles.get(i3).point2;
							Point p31=components.get(i2).triangles.get(i3).point3;
//							System.out.println("p1 is "+p1);
//							System.out.println("p11 is "+p11);
//							System.out.println("value of p1-p11 x comp= "+(p1.getX()-p11.getX()));
							float d1=(p1.getX()-p11.getX())*(p1.getX()-p11.getX())+(p1.getY()-p11.getY())*(p1.getY()-p11.getY())+(p1.getZ()-p11.getZ())*(p1.getZ()-p11.getZ());
							float d2=(p1.getX()-p21.getX())*(p1.getX()-p21.getX())+(p1.getY()-p21.getY())*(p1.getY()-p21.getY())+(p1.getZ()-p21.getZ())*(p1.getZ()-p21.getZ());
							float d3=(p1.getX()-p31.getX())*(p1.getX()-p31.getX())+(p1.getY()-p31.getY())*(p1.getY()-p31.getY())+(p1.getZ()-p31.getZ())*(p1.getZ()-p31.getZ());
							
//							System.out.println("value of d1= "+d1);
//							System.out.println("value of d2= "+d2);
//							System.out.println("value of d3= "+d3);
							if(d1<=d2 && d1<=d3 && d1<=d)
							{
//								System.out.println("afaaafsad");
								d=d1;
								p[0]=p1;
								p[1]=p11;
							}
							if(d2<=d1 && d2<=d3 && d2<=d)
							{
								d=d2;
								p[0]=p1;
								p[1]=p21;
							}
							if(d3<=d1 && d3<=d2 && d3<=d)
							{
								d=d3;
								p[0]=p1;
								p[1]=p31;
							}
							
//						}
							
						
					}
					}
				}
//				System.out.println("array p is "+p[0]+ "  "+p[1]);
//				System.out.println("sdsssssssssssssssssss");
				Point p2=components.get(i).triangles.get(i1).point2;
				
				for(int i2=0;i2<components.size();i2++)
				{
					
					if(i2!=i)
						
					{
//						System.out.println("component to be checked is: ");
//						System.out.println(components.get(i2));
					for(int i3=0;i3<components.get(i2).triangles.size();i3++)
					{
//						System.out.println("triangle to be checked is "+components.get(i2).triangles.get(i3));
//						
//						if(i3!=i1)
//						{
							Point p11=components.get(i2).triangles.get(i3).point1;
							
							Point p21=components.get(i2).triangles.get(i3).point2;
							Point p31=components.get(i2).triangles.get(i3).point3;
							
							float d1=(p2.getX()-p11.getX())*(p2.getX()-p11.getX())+(p2.getY()-p11.getY())*(p2.getY()-p11.getY())+(p2.getZ()-p11.getZ())*(p2.getZ()-p11.getZ());
							float d2=(p2.getX()-p21.getX())*(p2.getX()-p21.getX())+(p2.getY()-p21.getY())*(p2.getY()-p21.getY())+(p2.getZ()-p21.getZ())*(p2.getZ()-p21.getZ());
							float d3=(p2.getX()-p31.getX())*(p2.getX()-p31.getX())+(p2.getY()-p31.getY())*(p2.getY()-p31.getY())+(p2.getZ()-p31.getZ())*(p2.getZ()-p31.getZ());
							
							if(d1<=d2 && d1<=d3 && d1<=d)
							{
								d=d1;
								p[0]=p2;
								p[1]=p11;
							}
							else if(d2<=d1 && d2<=d3 && d2<=d)
							{
								d=d2;
								p[0]=p2;
								p[1]=p21;
							}
							else if(d3<=d1 && d3<=d2 && d3<=d)
							{
								d=d3;
								p[0]=p2;
								p[1]=p31;
							}
//						}
					}
					}
				}
//				System.out.println("array p is "+p[0]+ "  "+p[1]);
//				System.out.println("2222222222222222222222");
				Point p3=components.get(i).triangles.get(i1).point3;
				for(int i2=0;i2<components.size();i2++)
				{
					if(i2!=i)
						
					{
					for(int i3=0;i3<components.get(i2).triangles.size();i3++)
					{
						if(i3!=i1)
						{
//							System.out.println("triangle to be checked is "+components.get(i2).triangles.get(i3));
//							
							Point p11=components.get(i2).triangles.get(i3).point1;
							Point p21=components.get(i2).triangles.get(i3).point2;
							Point p31=components.get(i2).triangles.get(i3).point3;
//							System.out.println("p3 is "+p3);
//							System.out.println("p11 is "+p11);
//							System.out.println("value of p3-p11 x comp= "+(p3.getX()-p11.getX()));
							float d1=(p3.getX()-p11.getX())*(p3.getX()-p11.getX())+(p3.getY()-p11.getY())*(p3.getY()-p11.getY())+(p3.getZ()-p11.getZ())*(p3.getZ()-p11.getZ());
							float d2=(p3.getX()-p21.getX())*(p3.getX()-p21.getX())+(p3.getY()-p21.getY())*(p3.getY()-p21.getY())+(p3.getZ()-p21.getZ())*(p3.getZ()-p21.getZ());
							float d3=(p3.getX()-p31.getX())*(p3.getX()-p31.getX())+(p3.getY()-p31.getY())*(p3.getY()-p31.getY())+(p3.getZ()-p31.getZ())*(p3.getZ()-p31.getZ());
							
							if(d1<=d2 && d1<=d3 && d1<=d)
							{
								d=d1;
								p[0]=p3;
								p[1]=p11;
							}
							else if(d2<=d1 && d2<=d3 && d2<=d)
							{
								d=d2;
								p[0]=p3;
								p[1]=p21;
							}
							else if(d3<=d1 && d3<=d2 && d3<=d)
							{
								d=d3;
								p[0]=p3;
								p[1]=p31;
							}
							
						}
					}
					}
				}
//				System.out.println("array p is "+p[0]+ "  "+p[1]);
//				System.out.println("333333333");
				
				
				
			}
		}
		if(p[0]==null)
		{
			return null;
		}
		else {
//			System.out.println("closest points are ");
//			System.out.print(p[0]+" ");
//			System.out.print(p[1]);
			
			return p;
			
		}
	}

}

