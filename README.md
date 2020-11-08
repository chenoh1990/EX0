EX0

code installation:  https://github.com/chenoh1990/EX0.git

author:

chen ohayon



summary:

In this project I am developing an infrastructure of unintentional and unweighted graph.

I develop the methods of these graphs according to interfaces pre-defined for me by the lecturer.

After realizing the graph properties, I will implement an algorithm to calculate the shortest path, and another algorithm for finding the shortest trajectory using the graph properties I implemented.



NodeDate class methods:

1.getKey(): return the key value of node_data.

2.getNi(): return a collection of all neighbors of this node_data.

3.hasNi(): return true if the node_data of this given key is a neighbor of this node_data.

4.getInfo(): return the info of this node.

5.setInfo(): get string and set it as a info of this node.

6.getTag(): return the tag of this node.

7.setTag(): the tag  help us to mark the node according to our needs.

8.removeNode(): remove node from this node neighbors collection.

9.addNi(): adding a neighbor for this  node  neighbors collection , node cannot  be a  neighbor of himself.



Graph_DS class methods:

1.getNode(): return the node_data by given a key value.

2.hasEdge(): return true if there is an edge between those two nodes , and false if not exist.

3.connect(): connect between two nodes if they exist in this graph.

4.getV(): return collection of this graph nodes.

5.removeNode(): remove node data from graph by given key.

6.removeEdge(): by given two keys of nodes, this method disconnect between those two nodes if they connected.

7.nodeSize(): return the number of the nodes in this graph.

8.edgeSize(): return the number of the edges in this grpah.

9.getMC(): return the number of all changes that nade in ths graph.

10.addNode(): add a new node to the graph.



Graph_Algo algorithms & methods:


1.isConnected(): check if the graph is connected graph or not-connected grpah. return true if graph connected, if not - return false.

2.shortestPathDist(): return the distance  of the shortest path between two nodes.

3.BFS(breadth first search) (): return number of vertices connected to the start vertex.

4.shortestPath(): build the list of this path by the tag information,if start or end nodes are not exist in the graph , the method return  a null list.







