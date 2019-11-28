Assignment 6
COL 106
ASHWINI KUMAR
2018MT60778

In this assignment, we implemented the graph data structure. Using this graph data structure we are creating 
a shape by joining several triangles.

We implemented four interfaces namely PointInterface, EdgeInterface, ShapeInterface and TriangleInterface in 
the classes Point, Edge, Shape and Triangle respectively.We maintained several classes which are described 
below:

Class ArrayList{}: An object of this class represents an arrayList(dynamic array). It is implemented by 
increasing and decreasing the size of array various times as required. 

Class Triangle{}: An object of this class represents a triangle. It consists of three vertices and several 
member functions of it.

Class Point{}: An object of this class represents a point. 

Class Edge{}: An object of this class represents an edge.

Class Component{}: An object of this class represents one component of triangles in the shape. It consists 
of list of triangles that are in it.

Class Shape{}:It has various functions which are:
Time Complexity : 
Add triangle : O(size_of_triangles+ size_of_nodes+size_of_edges)
Type mesh : O(size_of_edges)
Boundary Edges : O(size_of_edges*log(size_of_edges)
Count Connected Components : O(size_of_triangles^2*log(size_of_triangles))
Neighbors of triangle : O(size_of_triangles)
Edge neighbor triangle : O(1)
Vertex neighbor triangle : O(1)
Extended neighbor triangle : O(size_of_triangles)
Incident triangles : O(size_of_triangles)
Neighbors of point : O(size_of_nodes)
Edge neighbors of triangles : O(size_of_nodes)
Face neighbors of triangles : O(size_of_triangles)
Is connected : O(size_of_triangles*log(size_of_triangles))
Triangle neighbor of edge : O(size_of_triangles)
Maximum diameter : O(size_of_triangles^4)
Centroid : O(size_of_triangles*log(size_of_triangles))
Centroid of Component : O(size_of_components*size_of_triangles*log(size_of_triangles))
Closest components : O(no. of nodes ^ 2)

This assignment was done in collaboration with Manoj Kumar 2018CS50411


 