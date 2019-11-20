package Graph_Project;
import java.util.*;

public class SparseGraph {
	static int vertices;
	static long edges;
	static int maxWeight;
	static int degree;
	
	LinkedList<Node> [] adjacencyList;
	
	public int getVertices() {
		return vertices;
	}

	public void setVertices(int vertices) {
		this.vertices = vertices;
		
	}

	public SparseGraph(int vertices) {
		super();
		this.vertices = vertices;
		this.edges = edges;
		adjacencyList = new LinkedList[vertices];
        for (int i = 0; i <vertices ; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
        
	}
	
	public void addEdge(int src, int dest, int weight) {
		
        Node snode = new Node(src, weight);
        Node dnode = new Node(dest,weight);
        if (!edgeExists(snode,dnode))
        {
        	 adjacencyList[src].add(dnode); //for directed graph
             adjacencyList[dest].add(snode);//for undirected
             edges++;
        }
//        adjacencyList[src].add(dnode); //for directed graph
//        adjacencyList[dest].add(snode);//for undirected
       
    }
	
	public int init_random(int max,int min) {
		int random_number= (int)((Math.random() * ((max - min) + 1)) + min);
		return random_number;
	}
	
	public void createCycle() {
		for(int i=0;i<vertices-1;i++) {
			int randomWeight= init_random(100,1);
			addEdge(i,i+1,randomWeight);
		}
		
	}
	
	public boolean edgeExists(Node u,Node v) {
		for(Node ed: adjacencyList[u.dest]){ 
            if (ed.dest==v.dest)
            	return true;
            
        } 	
		return false;
	}
	
	
	
	public void generateSparseGraph(int degree) {
		
		int addCounter=0;
		while(addCounter<((vertices*degree)/2)) {
			int random_v1= init_random(vertices-1,0);
			int random_v2= init_random(vertices-1,0);
			
			if(random_v1!=random_v2) {
				int random_weight=init_random(100,1);
				addEdge(random_v1,random_v2,random_weight);
			}
			addCounter++;
		}
		
	}
	 
	public void printGraph(){
		System.out.println("Total nodes:"+ vertices);
		System.out.println("Total edges:"+ 2*edges);
		System.out.println("Average degree:"+ ((2*edges)/vertices));
		
		 for(int i = 0; i < vertices; i++) 
	        { 
	            System.out.println("Adjacency list of vertex "+ i); 
	            
	            for(Node ned: adjacencyList[i]){ 
	                System.out.print( ned.dest+"("+ned.weight+")"); 
	            } 
	            System.out.println("\n"); 
	        } 
     }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int vertices = 5000;
         SparseGraph graph = new SparseGraph(vertices);

         graph.createCycle();
         graph.generateSparseGraph(6);
//         graph.addEgde(1, 3, 2);
//         graph.addEgde(1, 2, 5);
//         graph.addEgde(2, 3, 7);
//         graph.addEgde(3, 4, 2);
//         graph.addEgde(4, 1, 4);
//         graph.addEgde(4, 1, 4);
 //        graph.addEgde(4, 5, 6);
         graph.printGraph();

	}

}
