package ex0;

import java.util.*;

public class Graph_DS implements graph {

    private HashMap<Integer,node_data> nodes = new HashMap<Integer,node_data>();
    private int edge_size = 0;
    private int counter = 0;
    private int ver_size = 0;


    /**
     *
     * copy constructor
     * @param g
     */
    public Graph_DS (Graph_DS g){

        edge_size = g.edgeSize();
        counter = g.getMC();
        Iterator<Map.Entry<Integer,node_data>> itr = nodes.entrySet().iterator();

        while(itr.hasNext()){
            NodeData temp = new NodeData((node_data)itr);
            this.nodes.put(temp.getKey(), temp);
        }
    }

    /**
     * default constructor
     */
    public Graph_DS(){

    }

    /**
     *
     * @param key - the node_id
     * @return : return the node_data by given a key value.
     */
    @Override
    public ex0.node_data getNode(int key) {

        return nodes.get(key);

    }

    /**
     * note: if one of this nodes are not exist - this function return false.
     *
     * @param node1
     * @param node2
     * @return : return true if there is an edge between those two nodes , and false if not exist.
     */
    @Override
    public boolean hasEdge(int node1, int node2) {

        node_data node_a = this.getNode(node1) ;

        if (node_a == null) return false;

        return node_a.hasNi(node2);
    }

    /**
     * this method connect between two nodes if they exist in this graph.
     *
     * @param node1
     * @param node2
     */
    @Override
    public void connect(int node1, int node2) {

        if(node1 == node2){
            return;
        }

        if(!this.hasEdge(node1, node2)) {

            node_data node_a = getNode(node1);
            node_data node_b = getNode(node2);

            node_b.addNi(node_a);
            node_a.addNi(node_b);

            edge_size++;
            counter ++;
        }
    }

    /**
     *
     * @return: collection of this graph nodes.
     */
    @Override
    public Collection<ex0.node_data> getV() {

        Collection <ex0.node_data> ans = this.nodes.values();
        return ans;
    }

    /**
     *note: if the node id not exist in this graph - the method return null.
     *
     * @param node_id
     * @return : a collection of the neighbors of that node id.
     */
    @Override
    public Collection<ex0.node_data> getV(int node_id) {

        try {
            node_data node_a = this.getNode(node_id);

            Collection<ex0.node_data> ans = node_a.getNi();

            return ans;
        }
        catch (NullPointerException Error){
            System.out.println("node is not exist");
        }
        return null;
    }

    /**
     *
     * @param key
     * @return :  the node data that remove from the graph.
     */
    @Override
    public ex0.node_data removeNode(int key) {


        node_data remove = this.getNode(key);

        if (remove != null){

            for (node_data i : remove.getNi()) {

                i.removeNode(remove);
                edge_size--;
            }

            this.nodes.remove(key);

            counter++;
        }

        return remove;
    }

    /**
     * this method disconnect between those two nodes if they connected.
     * @param node1
     * @param node2
     */
    @Override
    public void removeEdge(int node1, int node2) {

        node_data a = this.getNode(node1);
        node_data b = this.getNode(node2);

        if( a.getNi().remove(b) && b.getNi().remove(a)) {
            edge_size--;
            counter++;
        }

    }

    /**
     *
     * @return : the number of the nodes in this graph.
     */
    @Override
    public int nodeSize() {

        return this.nodes.size();
    }

    /**
     *
     * @return : the number of the edges in this grpah.
     */
    @Override
    public int edgeSize() {

        return this.edge_size;
    }

    /**
     *mode count is a counter of all the changes that we made in this graph.
     *
     * @return : return the mode count .
     */
    @Override
    public int getMC() {
        return counter;
    }

    /**
     * this method add a new node to the graph.
     * @param n
     */
    @Override
    public void addNode(ex0.node_data n) {

        int key_n = n.getKey();

        this.nodes.put(key_n,n);
    }
}
