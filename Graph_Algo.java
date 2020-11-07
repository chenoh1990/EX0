package ex0;

import java.util.*;

public class Graph_Algo implements graph_algorithms{

    private graph g;

    /**
     * default constructor
     */
    public Graph_Algo(){

    }

    /**
     *
     * constructor that get  a graph g
     * @param g
     */
    public Graph_Algo(graph g){

        this.init(g);
    }

    /**
     * this method
     *
     * This method performs a breadth first search on all neighbors of the start vertex
     * and  count the number of vertices connected to the start vertex.
     *
     * @param start
     *
     * @return: number of vertices connected to the start vertex.
     */
    public int BFS (node_data start){


        for(node_data i :this.g.getV()){
            i.setTag(-1);
        }

        Queue<node_data> Unvisited = new LinkedList<>();
        int num_of_nodes = 1;

        Unvisited.add(start);
        start.setTag(1);

        while(!Unvisited.isEmpty()){

           node_data temp =  Unvisited.poll();

           if(!temp.getNi().isEmpty()) {

               for (node_data i : temp.getNi()) {
                   if(i.getTag() == -1) {
                       i.setTag(1);
                       Unvisited.add(i);
                       num_of_nodes++;
                   }
               }
           }
        }
        for(node_data i :this.g.getV()){
            i.setTag(-1);
        }
        return  num_of_nodes;
    }


    /**
     * Initializing the graph g.
     * @param g
     */
    @Override
    public void init(graph g) {

        this.g = g;
    }

    /**
     *
     * @return : a deep copy og graph g
     */
    @Override
    public graph copy() {

      graph ans = new Graph_DS((Graph_DS)(g));

        return ans;
    }

    /**
     * this method check if the graph is connected graph or not-connected grpah.
     * we running a BFS on a random node from this g, and if the BFS visited all
     * the nodes in graph - the graph is connected.
     *
     * this method used in BFS function
     *
     * @return : true if graph is connected , false if not-connected.
     */
    @Override
    public boolean isConnected() {

        node_data temp = null;
        for (node_data i : this.g.getV()){

            temp = i;

            if(temp != null) break;
        }

        if (g.nodeSize() == 0) return true;

        return g.getV().size() == BFS(temp);
    }

    /**
     *
     * if start or end nodes are not exist in the graph , the method return -1.
     * we ran a BFS  and tag all the visited vertex as a distance between them and the start node.
     * finally we return the tag of the end node.
     * note: if there is not exist path between those two nodes , the method return -1.
     *
     * @param src - start node
     * @param dest - end (target) node
     * @return : return the distance  of the shortest path between two nodes.
     */
    @Override
    public int shortestPathDist(int src, int dest) {

        if (this.g.getNode(src) == null || this.g.getNode(dest) == null ){
            return -1;
        }


        for(node_data i :this.g.getV()){
            i.setTag(-1);
        }
        node_data start = this.g.getNode(src);
        Queue<node_data> Unvisited = new LinkedList<>();

        Unvisited.add(start);
        start.setTag(0);
        while(!Unvisited.isEmpty()){
            node_data temp =  Unvisited.poll();

            if(!temp.getNi().isEmpty()) {

                for (node_data i : temp.getNi()) {

                    if(i.getTag() == -1 ) {

                        i.setTag(temp.getTag() +1);
                        Unvisited.add(i);
                    }
                }
            }
        }
        int ans = this.g.getNode(dest).getTag();

        for(node_data i :this.g.getV()){
            i.setTag(-1);
        }
        return ans;
    }

    /**
     *
     * if start or end nodes are not exist in the graph , the method return  a null list.
     * we ran a BFS  and tag all the visited vertex as a tag of their father.
     * after this action done, we  build the list of this path by the tag information.
     * finally we return that list.
     * note: if there is not exist path between those two nodes , the method return null list.
     *
     * @param src - start node
     * @param dest - end (target) node
     * @return :
     */
    @Override
    public List<node_data> shortestPath(int src, int dest) {
         List<node_data> ans = new ArrayList<node_data>()  ;

        if (this.g.getNode(src) == null || this.g.getNode(dest) == null ){
            return ans;
        }


        for(node_data i : this.g.getV()){
            i.setTag(-1);
        }
        node_data start = this.g.getNode(src);
        Queue<node_data> Unvisited = new LinkedList<>();

        Unvisited.add(start);
        start.setTag(start.getKey());

        while(!Unvisited.isEmpty()){
            node_data temp =  Unvisited.poll();

            if(!temp.getNi().isEmpty()) {

                for (node_data i : temp.getNi()) {

                    if(i.getTag() == -1 ) {

                        i.setTag(temp.getKey());
                        Unvisited.add(i);
                    }
                }
            }
        }
        node_data end = this.g.getNode(dest);

        if (end.getTag() == -1) return ans;
        ans.add(start);


        node_data temp = this.g.getNode(end.getTag());

        while(temp.getTag() != temp.getKey()){
            ans.add(0, temp);
            temp = this.g.getNode(temp.getTag());

        }
        ans.add(0, end);

        return ans;
    }
}
