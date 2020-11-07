package ex0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class NodeData implements node_data {
    private static int counter = 0;
    private int key;
    //private ArrayList<node_data> neighbors = new ArrayList<node_data>();
    private HashMap<Integer, node_data> neighbors = new HashMap<>();
    private String info;
    private int tag;


    /**
     * copy constructor
     * @param i
     */
    public NodeData(node_data i){

        this.key = i.getKey();

        for (node_data j : i.getNi()){
            neighbors.put(j.getKey(), j);
        }

        this.info = i.getInfo();
        this.tag = i.getTag();
    }


    /**
     * default constructor
     */
    public NodeData(){
        this.tag = -1;
        this.key = counter;
        counter ++;

    }

    /**
     *
     * @return : the key value of node_data
     */
    @Override
    public int getKey() {
        return this.key;
    }

    /**
     *
     * @return : return a collection of all neighbors of this node_data
     */
    @Override
    public Collection<ex0.node_data> getNi() {

        return neighbors.values();
    }

    /**
     *
     * @param key
     * @return : return true if the node_data of this given key is a neighbor of this node_data
     */
    @Override
    public boolean hasNi(int key) {

        node_data  neighbor = this.neighbors.get(key);
        if(neighbor == null) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return : return the info of this node
     */
    @Override
    public String getInfo() {

        return this.info;
    }

    /**
     * this method get string and set it as a info of this node
     *
     * @param s
     */
    @Override
    public void setInfo(String s) {

        this.info = s;
    }

    /**
     *
     * @return: return ta=he tag of this node
     */
    @Override
    public int getTag() {

        return tag;
    }

    /**
     *the tag  help us to mark the node according to our needs
     *
     * @param t - the new value of the tag
     */
    @Override
    public void setTag(int t) {

        this.tag =t;
    }

    /**
     * this method remove node from this node neighbors collection
     *
     * @param node
     */
    @Override
    public void removeNode(ex0.node_data node) {
        this.neighbors.remove(node.getKey());

    }

    /**
     * this method adding a neighbor for this  node  neighbors collection
     * node cannot  be a  neighbor of himself
     *
     * @param t
     */
    @Override
    public void addNi(ex0.node_data t) {


        if (t.getKey() == this.getKey()){
            return;
        }

        for (node_data i : this.getNi()){

            if(i.getKey() == t.getKey()) return;
        }
        this.neighbors.put(t.getKey() ,t);

        }
}
