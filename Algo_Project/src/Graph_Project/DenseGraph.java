package Graph_Project;
import java.util.*;

public class DenseGraph {
	static int vertices;
	static long edges;
	static int maxWeight;
	
	LinkedList<Node> [] adjacencyList;
//	LinkedList<Edge> [] adjacencyList;
	


	public DenseGraph(int vertices) {
		super();
		this.vertices = vertices;
		this.edges = edges;
		adjacencyList = new LinkedList[vertices];
        for (int i = 0; i <vertices ; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
        edges=0;
	}
	
	public void addEdge(int src, int dest, int weight) {
		
        Node snode = new Node(src, weight);
        Node dnode = new Node(dest,weight);
		
//		 Edge sedge = new Edge(src,dest, weight);
//	     Edge dedge = new Edge(dest,src,weight);
	     
        if (!edgeExists(snode,dnode))
        {
//        	 adjacencyList[src].add(dnode); //for directed graph
//             adjacencyList[dest].add(snode);//for undirected
        	
        	 adjacencyList[src].add(dnode); //for directed graph
             adjacencyList[dest].add(snode);//for undirected
             
             edges++;
        }
//        adjacencyList[src].add(dnode); //for directed graph
//        adjacencyList[dest].add(snode);//for undirected
       
    }
	
	public int init_weight(int max,int min) {
		int random_weight= (int)((Math.random() * ((max - min) + 1)) + min);
		return random_weight;
	}
	
	public void createCycle() {
		for(int i=0;i<vertices-1;i++) {
			int randomWeight= init_weight(100,1);
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
	
	public void generateDenseGraph() {
		for(int  i=0;i<vertices;i++) {
			for(int j=1;j<vertices;j++) {
				if(i!=j) {
					double random_number=Math.random();
					if(random_number < 0.2) {
						int randomWeight=init_weight(100,1);
						addEdge(i,j,randomWeight);
					}
				}
			}
		}
	}
	 
	public void printGraph(){
		System.out.println("Total nodes:"+ vertices);
		System.out.println("Total edges:"+ 2*edges);
		System.out.println("Average degree:"+ ((2*edges)/vertices));
		
		 for(int i = 0; i < vertices; i++) 
	        { 
	            System.out.println("Adjacency list of vertex "+ i); 
//	            System.out.print("head"); 
	            for(Node ned: adjacencyList[i]){ 
	                System.out.print( ned.dest+"("+ned.weight+")"); 
	            } 
	            System.out.println("\n"); 
	        } 
     }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int vertices = 5000;
         DenseGraph graph = new DenseGraph(vertices);

         graph.createCycle();
         graph.generateDenseGraph();
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
