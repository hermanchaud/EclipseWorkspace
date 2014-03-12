import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Test
 *
 */

public class Graph {
	private Node a = null;
	private Map<Integer, Node> traversedNodeMap;
	
	void initialize(){
		Node b = new Node();
		Node c = new Node();
		Node d = new Node();

		ArrayList<Node> tempnodes = new ArrayList<Node>();
		tempnodes.add(b);
		tempnodes.add(c);
		a.setNodes(tempnodes);
		
		tempnodes = new ArrayList<Node>();
		tempnodes.add(c);
		b.setNodes(tempnodes);

		tempnodes = new ArrayList<Node>();
		tempnodes.add(d);
		c.setNodes(tempnodes);

		tempnodes = new ArrayList<Node>();
		d.setNodes(tempnodes);
	}
	
	private int links = 0;
	
	public synchronized int countLinks(Node root){
		
		if(root != null){
			traversedNodeMap = new HashMap<Integer, Node>();
			links = 0;
			count(root);
			
		}
		
		return links;
	}
	
	private void count(Node trav){
		
		if(trav != null && !traversedNodeMap.containsKey(trav.getId())){
			traversedNodeMap.put(Integer.valueOf(trav.getId()), trav);
			
			links = links + trav.getNodes().size();
			
			for (Node eachNode:trav.getNodes()){
				count(eachNode);
			}
		}
	}
	
}
